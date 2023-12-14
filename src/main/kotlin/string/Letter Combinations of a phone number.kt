package src.main.kotlin.string

fun main() {
}

// TODO Backtraking
fun letterCombinations(digits: String): List<String> {
    val map = mapOf(
        Pair(2, listOf('a', 'b', 'c')),
        Pair(3, listOf('d', 'e', 'f')),
        Pair(4, listOf('g', 'h', 'i')),
        Pair(5, listOf('j', 'k', 'l')),
        Pair(6, listOf('m', 'n', 'o')),
        Pair(7, listOf('p', 'q', 'r', 's')),
        Pair(8, listOf('t', 'u', 'v')),
        Pair(9, listOf('w', 'x', 'y', 'z')),
    )

    if (digits.length > 1) {
    }
    return listOf()
}
