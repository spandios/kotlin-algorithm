package src.main.kotlin.explore.array2d

fun main() {
    println(generate(5))
}

fun generate(numRows: Int): List<List<Int>> {
    val arr = Array(numRows) { IntArray(it + 1) { 1 } }

    for (i in 0..<numRows) {
        if (i < 2) continue
        val size = i + 1
        val upArray = arr[i - 1]
        for (j in 1..<size - 1) {
            val sum = upArray[j - 1] + upArray[j]
            arr[i][j] = sum
        }
    }

    return arr.map { it.toList() }
}
