package src.main.kotlin.string

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/?envType=daily-question&envId=2023-12-11

fun main() {
}

fun findSpecialInteger(arr: IntArray): Int {
    val size = arr.size * 0.25

    val groupBy = arr.groupBy {
        it
    }.mapValues {
        it.value.size
    }.filter { it.value > size }
    return groupBy.keys.first()
}
