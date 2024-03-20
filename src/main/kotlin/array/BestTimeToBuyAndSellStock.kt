package src.main.kotlin.array

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

// fun maxProfit(prices: IntArray): Int {
//    var profit = 0
//    for (i in prices.indices) {
//        val buy = prices[i]
//        for (j in i + 1..<prices.size) {
//            val sell = prices[j]
//            profit = (sell - buy).coerceAtLeast(profit)
//        }
//    }
//    return profit
// }

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var minPrice = -1

    prices.forEach { price ->
        minPrice = price.coerceAtMost(minPrice)
        profit = price.coerceAtLeast(price - minPrice)
    }
    return profit
}
