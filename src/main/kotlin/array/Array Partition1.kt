package src.main.kotlin.array

// https://leetcode.com/problems/array-partition/description/
fun main() {
}

// 1,3,4,2
fun arrayPairSum(nums: IntArray): Int {
    var sum = 0
    val sorted = nums.sorted()

    for (i in sorted.indices step 2) {
        sum += sorted[i]
    }
    return sum
}
