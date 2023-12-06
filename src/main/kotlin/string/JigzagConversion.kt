package src.main.kotlin.string

fun main() {
    println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 2))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }

    var x = 0
    var y = 0
    val ar = Array(numRows) { CharArray(s.length) }

    var direction = 1

    for (c in s) {
        ar[y][x] = c
        if (y == 0) direction = 1
        if (y == numRows - 1) direction = -1
        y += direction
        if (direction == -1) x++
    }

    return ar.joinToString("") { it.filter { it != '\u0000' }.joinToString("") }
}
