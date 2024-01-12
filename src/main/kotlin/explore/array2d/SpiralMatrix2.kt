package src.main.kotlin.explore.array2d

// [[1]]
// ySize=  1
// xSize = 1

fun main() {
    println(
        spiralOrder(
            arrayOf(
                intArrayOf(1),
            ),
        ),
    )
}

/**
 * Returns a list of integers representing the elements of the given matrix in spiral order.
 *
 * @param matrix The 2-dimensional array of integers representing the matrix.
 * @return The list of integers in spiral order.
 * 0 : 북 , 1 : 서 , 2 : 남 , 3: 동
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val yv = listOf(-1, 0, +1, 0)
    val xv = listOf(0, -1, 0, +1)

    val results = mutableListOf<Int>()
    var y = 0
    var x = 0
    val ySize = matrix.size
    val xSize = matrix[0].size

    val visit: Array<Array<Boolean>> = Array(ySize) { Array(xSize) { false } }

    if (ySize == 1 && xSize == 1) {
        return listOf(matrix[0][0])
    }

    while (true) {
        // to Right
        while (x < xSize - 1) {
            if (b(visit, y, x, results, matrix, yv, xv, ySize, xSize)) return results
            if (!visit[y][x + 1]) {
                x++
            } else {
                break
            }
        }

        // to Down
        while (y < ySize - 1) {
            if (b(visit, y, x, results, matrix, yv, xv, ySize, xSize)) return results
            if (!visit[y + 1][x]) {
                y++
            } else {
                break
            }
        }

        // to Left
        while (x > 0) {
            if (b(visit, y, x, results, matrix, yv, xv, ySize, xSize)) return results
            if (!visit[y][x - 1]) {
                x--
            } else {
                break
            }
        }

        // to UP
        while (y > 0) {
            if (b(visit, y, x, results, matrix, yv, xv, ySize, xSize)) return results
            if (!visit[y - 1][x]) {
                y--
            } else {
                break
            }
        }

        if (results.size == (matrix.size * matrix[0].size)) return results

        x++
    }
}

private fun b(
    visit: Array<Array<Boolean>>,
    y: Int,
    x: Int,
    results: MutableList<Int>,
    matrix: Array<IntArray>,
    yv: List<Int>,
    xv: List<Int>,
    ySize: Int,
    xSize: Int,
): Boolean {
    var isExistNoVisit = false
    if (!visit[y][x]) {
        visit[y][x] = true
        results.add(matrix[y][x])
    }
    for (i in yv.indices) {
        val tempY = y + yv[i]
        val tempX = x + xv[i]
        if (tempY in 0..<ySize && tempX in 0..<xSize) {
            if (!visit[tempY][tempX]) {
                isExistNoVisit = true
                break
            }
        }
    }
    if (!isExistNoVisit) {
        return true
    }
    return false
}

fun spiralOrder2(matrix: Array<IntArray>): List<Int> {
    var ySize = matrix.size
    var xSize = matrix[0].size

    var y = 0
    var x = -1
    var direction = 1

    val results = mutableListOf<Int>()

    while (ySize > 0 && xSize > 0) {
        for (i in 0..<xSize) {
            results.add(matrix[y][x])
            x += direction
        }
        ySize--

        for (i in 0..<ySize) {
            results.add(matrix[y][x])
            y += direction
        }
        xSize--

        direction *= -1
    }

    return results
}
