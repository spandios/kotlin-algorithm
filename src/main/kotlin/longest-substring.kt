fun main() {
    lengthOfLongestSubstring("")
}

fun lengthOfLongestSubstring(s: String): Int {
    var r = 0
    val tempSet = mutableSetOf<Char>()
    for (i in 0 ..< s.length) {
        val fs = s[i]
        tempSet.add(fs)

        for (j in i + 1 ..< s.length) {
            if (!tempSet.add(s[j])) {
                break
            }
        }

        r = maxOf(r, tempSet.size)
        tempSet.clear()
    }
    return r
}
