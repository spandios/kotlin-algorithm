package src.main.kotlin.explore.string2array.conclusion

fun main() {
    removeDuplicates(intArrayOf(1, 1, 2))
}

fun removeDuplicates(nums: IntArray): Int {
    val result = mutableListOf<Int>()

    for (i in nums.indices) {
        if (nums[i] == -101) {
            continue
        }
        result.add(nums[i])
        for (j in i + 1..<nums.size) {
            if (nums[i] == nums[j]) {
                nums[j] = -101
            } else {
                break
            }
        }
    }

    result.forEachIndexed { index, v ->
        nums[index] = v
    }

    return result.size
}
