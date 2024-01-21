package src.main.kotlin.explore.twopointer

fun main() {
    println(arrayPairSum(intArrayOf(1, 4, 3, 2)))
}

fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var result = 0
    val pairingNum = nums.size / 2
    var sumCnt = 0
    for (i in nums.lastIndex - 1 downTo 0 step 2) {
        sumCnt++
        result += nums[i]
        if (pairingNum == sumCnt) {
            break
        }
    }

    return result
}
