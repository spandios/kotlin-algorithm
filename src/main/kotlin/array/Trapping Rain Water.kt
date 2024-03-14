package src.main.kotlin.array

fun main() {
    println(trap(intArrayOf(4, 9, 4, 5, 3, 2)))
}

fun trap(height: IntArray): Int {
    var sum = 0

    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]

    while (left < right) {
        if (height[left] < height[right]) {
            leftMax = maxOf(leftMax, height[left])
            sum += leftMax - height[left]
            left++
        } else {
            rightMax = maxOf(rightMax, height[right])
            sum += rightMax - height[right]
            right--
        }
    }

    return sum
}
