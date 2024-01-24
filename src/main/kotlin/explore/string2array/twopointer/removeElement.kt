package src.main.kotlin.explore.string2array.twopointer

fun main() {
}

fun removeElement(
    nums: IntArray,
    `val`: Int,
): Int {
    var k = 0
    for (v in nums) {
        if (v != `val`) {
            nums[k] = v
            k++
        }
    }
    return k
}
