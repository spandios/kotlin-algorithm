package string


fun main() {
    println(romanToInt("MCMXCIV"))


}

// 반복문
fun romanToInt(s: String): Int {
    var r = 0
    val values: MutableMap<Char, Int> = mutableMapOf()
    values['I'] = 1
    values['V'] = 5
    values['X'] = 10
    values['L'] = 50
    values['C'] = 100
    values['D'] = 500
    values['M'] = 1000


    for (index in s.indices) {
        val c = s[index]
        if (index > 0) {
            if (c == 'V' || c == 'X') {
                if (s[index - 1] == 'I') {
                    r -= values[s[index - 1]]!!
                    r += (values[c]!! - values['I']!!)
                    continue
                }
            } else if (c == 'L' || c == 'C') {
                if (s[index - 1] == 'X') {
                    r -= values[s[index - 1]]!!
                    r += (values[c]!! - values['X']!!)
                    continue
                }
            } else if (c == 'D' || c == 'M') {
                if (s[index - 1] == 'C') {
                    r -= values[s[index - 1]]!!
                    r += (values[c]!! - values['C']!!)
                    continue
                }
            }
        }
        r += values[c]!!
    }
    return r

}

// 왼쪽이 오른쪽 문자의 값보다 작은 것인지 체크하는 방법 + map index + sum + 확장 게터
fun romanToUsing(s: String): Int {
    return s.mapIndexed { i, c ->
        c.roman * if ((s.getOrNull(i + 1)?.roman ?: 0) >= c.roman) -1 else 1
    }.sum()
}

private val Char.roman
    get() = when (this) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }