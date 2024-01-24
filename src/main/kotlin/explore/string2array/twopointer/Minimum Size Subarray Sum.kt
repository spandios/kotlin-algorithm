package src.main.kotlin.explore.string2array.twopointer

fun main() {
    minSubArrayLen(
        7,
        intArrayOf(
            2,
            3,
            1,
            2,
            4,
            3,
        ),
    )
}

fun minSubArrayLen(
    target: Int,
    nums: IntArray,
): Int {
    var minLen = Int.MAX_VALUE
    var left = 0
    var sum = 0
    for (right in nums.indices) {
        sum += nums[right]
        while (sum >= target) {
            minLen = minLen.coerceAtMost(right - left + 1)
            sum -= nums[left++]
        }
    }
    return if (minLen == Int.MAX_VALUE) 0 else minLen
}
