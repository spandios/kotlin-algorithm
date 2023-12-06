package string

/**
 * https://leetcode.com/problems/most-common-word/description/
 */

fun main() {
    mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
}

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val word = paragraph.replace(Regex("\\W"), " ").lowercase().trim()
    return word.split(" ").groupBy {
        it
    }.filter {
        !banned.contains(it.key) && it.key.isNotBlank()
    }.mapValues {
        println(it)
        it.value.size
    }.maxBy {
        it.value
    }.key
}
