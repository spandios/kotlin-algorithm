package src.main.kotlin.explore.string2array.twopointer

fun reverseString(s: CharArray) {
    var l = 0
    var r = s.size - 1

    while (l < r) {
        s[l] = s[r].also { s[r] = s[l] }
        l++
        r--
    }
}
