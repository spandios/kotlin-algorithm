package string

fun main() {
    isPalindrome("A man, a plan, a canal: Panama")
}

fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    val alpaNumberic = s.filter {
        Regex("[a-zA-Z0-9]").matches(it.toString())
    }.lowercase()

    for (i in 0 until alpaNumberic.length) {
        if (i > alpaNumberic.length - 1 / 2) return true
        val left = alpaNumberic[i]
        val right = alpaNumberic[alpaNumberic.length - 1 - i]
        if (left != right) {
            return false
        }
    }
    return true
}
