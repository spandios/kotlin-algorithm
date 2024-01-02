package explore.array2d

fun main() {
}

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    var results = mutableListOf<Int>()

    var i = 0
    var j = 0

    while (i < mat.size && j < mat[i].size) {
        // up right
        while (i >= 0) {
            results.add(mat[i][j])
            i--
            j++
        }

        if (j == mat) {
            i = 0
        } else {
            i += 1
            j = mat[i].size - 1
        }

        // down left
        while (i < mat.size && j > 0) {
            results.add(mat[i][j])
            i++
            j--
        }

        if (i == mat.lastIndex) {
            j++
        } else {
            i++
        }
    }

    return results.toIntArray()
}
