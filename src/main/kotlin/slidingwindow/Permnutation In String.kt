package slidingwindow

fun main() {
}

fun checkInclusion(
    s1: String,
    s2: String,
): Boolean {
    if (s1.length > s2.length) return false

    val s1Freq = IntArray('z' - 'a' + 1)
    val s2Freq = IntArray('z' - 'a' + 1)

    for (i in s1.indices) {
        s1Freq['z' - s1[i]]++
        s2Freq['z' - s2[i]]++
    }

    for (i in 0 until s2.length - s1.length) {
        if (s1Freq.contentEquals(s2Freq)) return true

        // decrease current start
        s2Freq['z' - s2[i]]--
        // and increase current end
        s2Freq['z' - s2[i + s1.length]]++
    }

    return s1Freq.contentEquals(s2Freq)
}
