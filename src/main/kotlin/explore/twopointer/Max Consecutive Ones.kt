package src.main.kotlin.explore.twopointer

fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(0)))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var cnt = 0
    var l = 0
    var r = 0

    while (r < nums.size) {
        if (nums[l] == 0) {
            l++
            r++
            continue
        }
        if (nums[l] == nums[r]) {
            cnt++
            r++
        } else {
            l = r + 1
            r = l
            max = Math.max(cnt, max)
            cnt = 0
        }
    }
    max = Math.max(cnt, max)
    return max
}
