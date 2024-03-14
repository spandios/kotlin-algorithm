package src.main.kotlin.array

// https://leetcode.com/problems/product-of-array-except-self/solutions/4203737/96-no-extra-space-one-loop-3-solutions/
fun main() {
    productExceptSelf(intArrayOf(1, 2, 3, 4))
}

fun productExceptSelf(nums: IntArray): IntArray {
    val end = nums.lastIndex
    val res = IntArray(nums.size) { 1 }
    var left = 1
    var right = 1

    for (i in nums.indices) {
        res[i] *= left
        res[end - i] *= right

        left *= nums[i]
        right *= nums[end - i]
    }

    return res
}
