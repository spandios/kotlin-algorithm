package src.main.kotlin.explore.array_strings

fun main() {
    println(dominantIndex(intArrayOf(3, 6, 1, 0)))
}

fun dominantIndex(nums: IntArray): Int {
    var largest = -1
    for (i in 0..<nums.size) {
        val current = nums[i]
        var isLargest = true

        for (j in 0..<nums.size) {
            if (i == j) continue
            val find = nums[j]
            if (find * 2 > current) {
                isLargest = false
                break
            }
        }
        if (isLargest) {
            largest = i
        }
    }

    return largest
}
