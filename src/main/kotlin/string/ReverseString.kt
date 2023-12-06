package string

/**
 * 344 Reverse String
 */
fun main() {
}

fun reverseString(s: CharArray) {
    var left = 0
    var right = s.size - 1

    while (left < right) {
        // also는 수신 객체 그대로를 반환한다.
        s[left] = s[right].also { s[right] = s[left] }
        left++
        right--
    }
}
