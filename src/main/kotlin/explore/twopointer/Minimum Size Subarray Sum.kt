package explore.twopointer

fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
}

fun minSubArrayLen(
    target: Int,
    nums: IntArray,
): Int {
    var left = 0
    var sum = 0
    var min = Int.MAX_VALUE
    for (i in nums.indices) {
        sum += nums[i]
        while (sum >= target) {
            min = Math.min(min, i - left + 1)
            sum -= nums[left++]
        }
    }
    return if (min == Int.MAX_VALUE) 0 else min
}
