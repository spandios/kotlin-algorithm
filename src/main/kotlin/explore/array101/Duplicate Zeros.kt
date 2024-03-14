package src.main.kotlin.explore.array101

fun main() {
    duplicateZeros(intArrayOf(0, 0, 0, 0, 0, 0, 0))
}

fun duplicateZeros(arr: IntArray) {
    val original = arr.copyOf()
    var originalIndex = 0
    var currentIndex = 0

    while (currentIndex < arr.size) {
        val v = original[originalIndex]
        if (v == 0) {
            arr[currentIndex] = v
            if (currentIndex + 1 >= arr.size) {
                break
            }
            currentIndex++
            arr[currentIndex] = v
        } else {
            arr[currentIndex] = v
        }
        currentIndex++
        originalIndex++
    }
}
