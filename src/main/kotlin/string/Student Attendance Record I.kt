package src.main.kotlin.string

fun main() {
    checkRecord("LLPPPLLL")
}

// 출석상 받는 조건 : A(Absent)가 총 2개 미만이고
// 3일연속으로 L(Late)가 없어야 한다.
fun checkRecord(s: String): Boolean {
    val chars = s.toCharArray()
    if (chars.filter { it == 'A' }.size > 1) {
        return false
    }
    var isConsecutive = false
    var lCnt = 0

    if (chars.size > 2) {
        chars.forEachIndexed { index, c ->
            if (c == 'L') {
                lCnt++
                if (isConsecutive) {
                    if (lCnt > 2) {
                        return false
                    }
                } else {
                    isConsecutive = true
                }
            } else {
                isConsecutive = false
                lCnt = 0
            }
        }
    }

    return true
}
