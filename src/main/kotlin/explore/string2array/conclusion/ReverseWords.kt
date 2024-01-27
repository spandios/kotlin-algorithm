package src.main.kotlin.explore.string2array.conclusion

fun main() {
    reverseWords("a good   example")
}

fun reverseWords(s: String): String {
    val result = StringBuilder()
    val reversed = s.split(" ").reversed().toMutableList()

    while (reversed.first() == "") {
        reversed.removeAt(0)
    }

    while (reversed.last() == "") {
        reversed.removeAt(reversed.lastIndex)
    }

    for (i in reversed.indices) {
        if (reversed[i] == "") {
            if (i != reversed.lastIndex) {
                if (reversed[i + 1] == "") {
                    continue
                }
            }
            result.append(reversed[i])
        } else {
            result.append(reversed[i] + if (i != reversed.lastIndex) " " else "")
        }
    }

    return result.toString()
}
