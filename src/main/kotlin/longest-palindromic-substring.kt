fun main() {
    print(longestPalindromeWithTwoPointer("abbab"))
}

// // 느림 = 계속 모든 문자열마다 찾고 palindrome찾아야해서
// fun longestPalindrome(s: String): String {
//    if (s.length < 2) return s
//
//    if (s.length == 2 && s.first() == s.last()) {
//        return s
//    }
//
//    var longest = ""
//
//    for (i in 0..<s.length) {
//        for (j in i + 1..s.length) {
//            val sub = s.substring(i, j)
//            if (isPalindrome(sub) && sub.length > longest.length) {
//                longest = sub
//            }
//        }
//    }
//    return longest
// }

// fun isPalindrome(s: String): Boolean {
//    var left = 0
//    var right = s.length - 1
//
//    while (left < right) {
//        if (s[left] != s[right]) {
//            return false
//        }
//        left += 1
//        right -= 1
//    }
//    return true
// }

var left: Int = 0
var maxLen: Int = 0

fun longestPalindromeWithTwoPointer(s: String): String {
    if (s.length < 2) return s

    for (i in 0..<s.length - 1) {
        extendPalindrome(s, i, i + 1)
        extendPalindrome(s, i, i + 2)
    }

    return s.substring(left, left + maxLen)
}

fun extendPalindrome(s: String, ii: Int, jj: Int) {
    var i = ii
    var j = jj

    while (i >= 0 && j < s.length && s[i] == s[j]) {
        i--
        j++
    }

    val tmax = j - i - 1

    if (tmax > maxLen) {
        maxLen = tmax
        left = i + 1
    }
}
