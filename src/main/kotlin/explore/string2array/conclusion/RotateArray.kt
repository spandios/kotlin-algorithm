package src.main.kotlin.explore.string2array.conclusion

fun main() {
    rotate(intArrayOf(1, 2), 3)
}

// 1. 반복문으로 해결해보기
// fun rotate(
//    nums: IntArray,
//    k: Int,
// ) {
//    for (i in 0..<k) {
//        var tmp = 0
//        for (j in nums.indices) {
//            // 가장 첫번째 인덱스는 마지막 인덱스의 값으로 교체된다.
//            if (j == 0) {
//                tmp = nums[j]
//                nums[j] = nums[nums.lastIndex]
//            } else {
//                val ttmp = nums[j]
//                nums[j] = tmp
//                tmp = ttmp
//            }
//        }
//    }
// }

// 2. 새로운 배열에 복사하기
fun rotate(
    nums: IntArray,
    k: Int,
) {
    if (nums.size == 1) {
        return
    }
    val result = IntArray(nums.size)
    nums.forEachIndexed { index, v ->
        result[(index + k) % nums.size] = v
    }
    System.arraycopy(result, 0, nums, 0, nums.size)
}
