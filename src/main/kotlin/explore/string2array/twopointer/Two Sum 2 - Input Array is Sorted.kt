package src.main.kotlin.explore.string2array.twopointer

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
}

fun twoSum(
    numbers: IntArray,
    target: Int,
): IntArray {
    var left = 0
    var right = numbers.size - 1
    val intArray = IntArray(2)

    while (true) {
        val s = numbers[left] + numbers[right]
        if (s == target) {
            intArray[0] = left + 1
            intArray[1] = right + 1
            break
        }
        if (s > target) {
            right--
        } else {
            left++
        }
    }

    return intArray
}

// -5 -1 0
