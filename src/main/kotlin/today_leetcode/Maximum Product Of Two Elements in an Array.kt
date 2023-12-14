package src.main.kotlin.today_leetcode

fun main() {
    maxProduct(intArrayOf(3, 4, 5, 2))
}

fun maxProduct(nums: IntArray): Int {
    var max = 0
    for (i in 0..<nums.size) {
        for (j in i + 1..<nums.size) {
            val r = (nums[i] - 1) * (nums[j] - 1)
            if (r > max) {
                max = r
            }
        }
    }
    return max
}
