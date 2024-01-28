package src.main.kotlin.explore.string2array.conclusion

fun main() {
    moveZeroes(intArrayOf(1, 3, 5))
}

fun moveZeroes(nums: IntArray) {
    var left = 0
    var right = 0

    while (left < nums.size && right < nums.size) {
        if (nums[left] == 0) {
            while (right < nums.lastIndex && nums[right] == 0) {
                right++
            }
            nums[left] = nums[right].also { nums[right] = nums[left] }
        }
        left++
        right++
    }
}

/**
 * 값이 0일 때 writing index를 ++하지 않아 오른쪽 값을 왼쪽에 넣는 작업
 * 그 후 나머지 writing index를 배열 크기만큼 돌리면서 0을 붙임
 */
// fun moveZeroes(nums: IntArray) {
//    var r = 0 // reading
//    var w = 0 // writing
//
//    while (r < nums.size) {
//        if (nums[r] != 0) {
//            nums[w++] = nums[r] // 0이 아니면 전에 writing 인덱스에 그대로 넣고 ++함
//        }
//        r++
//    }
//
//    while (w < nums.size) {
//        nums[w++] = 0
//    }
// }
