package src.main.kotlin.array

import java.util.Arrays

fun main() {
    threeSum(intArrayOf(1, -1, -1, 0))
}

// 1. 브루트 포스 => Time Limit Exceeded
// fun threeSum(nums: IntArray): List<List<Int>> {
//    val results = mutableListOf<List<Int>>()
//    for (i in 0..nums.size - 3) {
//        val iv = nums[i]
//        for (j in i + 1..nums.size - 2) {
//            val jv = nums[j]
//            for (k in j + 1..<nums.size) {
//                val kv = nums[k]
//                if (iv + jv + kv == 0) {
//                    val r = listOf(iv, jv, kv).sorted()
//                    if (results.count { it == r } == 0) {
//                        results.add(r)
//                    }
//                }
//            }
//        }
//    }
//    return results
// }

// 2. 투포인터로 계산
fun threeSum(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    val results = mutableListOf<List<Int>>()
    var l: Int
    var r = nums.size - 1

    for (i in 0 until nums.size - 2) {
        l = i + 1
        if (i > 0 && nums[i - 1] == nums[i]) {
            continue
        }
        while (l < r) {
            val iv = nums[i]
            val lv = nums[l]
            val rv = nums[r]
            val result = iv + lv + rv

            if (result < 0) {
                l += 1
            } else if (result > 0) {
                r -= 1
            } else {
                results.add(listOf(iv, lv, rv))

                while (l < r && nums[l] == nums[l + 1]) {
                    l += 1
                }
                while (l < r && nums[r] == nums[r - 1]) {
                    r -= 1
                }
                l += 1
                r -= 1
            }
        }
    }

    return results
}
