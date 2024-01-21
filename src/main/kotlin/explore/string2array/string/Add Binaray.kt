package src.main.kotlin.string

// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/

fun main() {
    println(addBinary("1110110101", "1110111011"))
}

fun addBinary(
    a: String,
    b: String,
): String {
    val sum = (a.toBigInteger() + b.toBigInteger()).toString().map { it.digitToInt() }.toMutableList()
    for (i in sum.size - 1 downTo 0) {
        if (sum[i] >= 2) {
            sum[i] = sum[i] % 2
            if (i == 0) {
                return "1${sum.joinToString("")}"
            }
            sum[i - 1] = sum[i - 1] + 1
        }
    }

    return sum.joinToString("")
}
