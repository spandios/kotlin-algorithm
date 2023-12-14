package string

fun main() {
    val a = longestCommonPrefix(arrayOf("a"))
    println(a)
}

fun longestCommonPrefix(strs: Array<String>): String {
    var i = 0
    val ii = strs.minOf { it.length }

    while (i < ii) {
        val ch = strs[0].getOrNull(i)

        val map = strs.map {
            it[i]
        }.count { it == ch } == strs.size

        if (map) {
            i++
        } else {
            if (i == 0) {
                return ""
            }
            break
        }
    }

    return strs[0].substring(0, i)
}
