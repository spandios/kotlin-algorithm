package src.main.kotlin.explore.array_strings

fun main() {
    println(pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
}

fun pivotIndex(nums: IntArray): Int {
    var result = -1

    for (i in 0..<nums.size) {
        var leftSum = 0
        var rightSum = 0

        // left
        for (l in 0..<i) {
            leftSum += nums[l]
        }

        // right
        for (r in i + 1..<nums.size) {
            rightSum += nums[r]
        }

        if (leftSum == rightSum) {
            result = i
            break
        }
    }

    return result
}
