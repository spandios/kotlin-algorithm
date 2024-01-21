package explore.array2d

fun main() {
    println(findDiagonalOrder(arrayOf(intArrayOf(2, 5), intArrayOf(8, 4), intArrayOf(0, -1))).contentToString())
}

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    var results = mutableListOf<Int>()

    var i = 0
    var j = 0
    val size = mat.size * mat[i].size
    val maxJ = mat[i].lastIndex
    while (results.size < size) {
        // up right
        while (i >= 0 && j < mat[i].size) {
            results.add(mat[i][j])
            if (results.size == size) {
                return results.toIntArray()
            }
            i--
            j++
        }

        i++
        j--

        if (mat.get(i).getOrNull(j + 1) == null) {
            i++
        } else {
            j++
        }

        // down left
        while (i < mat.size && j >= 0) {
            results.add(mat[i][j])
            i++
            j--
        }

        i--
        j++

        if (mat.getOrNull(i + 1) == null) {
            j++
        } else {
            i++
        }
    }

    return results.toIntArray()
}
