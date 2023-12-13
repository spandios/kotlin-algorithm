package string

import kotlin.collections.EmptyMap.values

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

// two pointer
fun romanToIntUsingTwoPointer(s: String): Int {
    val values: MutableMap<Char, Int> = mutableMapOf()
    values['I'] = 1
    values['V'] = 5
    values['X'] = 10
    values['L'] = 50
    values['C'] = 100
    values['D'] = 500
    values['M'] = 1000

    var r = 0
    var start = 0
    var end = 0

    while (true) {
        if (end == s.length - 1) break
        if (s[start] == 'I' && (s[end] == 'V' || s[end] == 'X')) {
            r -= values[s[start]]!!
            r += (values[s[end]]!! - values[s[start]]!!)
            start++
            continue
        }else if(s[start] == 'X' && (s[end] == 'L' || s[end] == 'C')){
            r -= values[s[start]]!!
            r += (values[s[end]]!! - values[s[start]]!!)
            start++
            continue
        }else if(s[start] == 'C' && (s[end] == 'D' || s[end] == 'M')){
            r -= values[s[start]]!!
            r += (values[s[end]]!! - values[s[start]]!!)
            start++
            continue
        }

        r += values[s[end]]!!
        end++
    }



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