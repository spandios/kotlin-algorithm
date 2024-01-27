package src.main.kotlin.explore.string2array.conclusion

fun main() {
    reverseWords3("Let's take LeetCode contest")
}

fun reverseWords3(s: String): String {
    val reversed = s.split(" ").toMutableList().map { it.reversed() }
    return reversed.joinToString(" ")
}
