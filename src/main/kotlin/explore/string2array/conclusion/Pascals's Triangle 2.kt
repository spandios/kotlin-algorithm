package src.main.kotlin.explore

fun main() {
    println(getRow(3))
}

fun getRow(rowIndex: Int): List<Int> {
    val result = mutableListOf<IntArray>()
    for (i in 0..rowIndex) {
        result.add(IntArray(i + 1) { 1 })
    }
    if (rowIndex < 2) {
        return result[rowIndex].toList()
    } else {
        for (i in 2..rowIndex) {
            for (j in 1..<i) {
                result[i][j] = result[i - 1 ][j - 1] + result[i - 1 ][j]
            }
        }
    }
    return result[rowIndex].toList()
}
