package src.main.kotlin.string

// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/

fun main() {
    println(strStr("mississippi", "issi"))
}

fun strStr(
    haystack: String,
    needle: String,
): Int {
    var result = Int.MAX_VALUE
    val firstNeedleWord = needle[0]
    val needleLength = needle.length

    haystack.forEachIndexed { index, c ->
        if (c == firstNeedleWord && index + needleLength <= haystack.length) {
            if (haystack.slice(index..<index + needleLength) == needle) {
                result = Math.min(result, index)
            }
        }
    }

    if (result == Int.MAX_VALUE) {
        return -1
    }
    return result
}

fun strStrWithTwoPointer(
    haystack: String,
    needle: String,
): Int {
    var p = 0
    var l = 0
    while (l < haystack.length) {
        if (needle[p] == haystack[l]) {
            if (p == needle.length - 1) {
                return l - p
            }
            p++
            l++
        } else {
            l -= p - 1
            p = 0
        }
    }
    return -1
}
