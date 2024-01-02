package explore.array_strings

import java.util.LinkedList

fun main() {
    println(plusOne(intArrayOf(1,2,3,)).contentToString())
}

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
fun plusOne(digits: IntArray): IntArray {
    val results = LinkedList(digits.toMutableList())

    results[results.lastIndex] += 1

    for (i in results.size - 1  downTo 0){
        if(results[i] == 10){
            results[i] = 0
            val previousDigit = results.getOrNull(i - 1)
            if(previousDigit == null){
                results.addFirst(1)
            }else{
                results[i - 1] += 1
            }
        }
    }
    return results.toIntArray()
}