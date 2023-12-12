package slidingwindow

// https://www.acmicpc.net/problem/21921
fun main() {
    blog(5, listOf(1, 1, 1, 1, 1, 5, 1))
}

/**
 * 반복문으로 해결해보기
 */
fun blog(x: Int, numArr: List<Int>) {
    var max = 0
    var cnt = 0
    for (i in 0..<numArr.size - x + 1) {
        var js = 0
        for (j in i..<i + x) {
            js += numArr[j]
        }
        if (max == js) {
            cnt++
        } else if (max < js) {
            max = js
            cnt = 1
        }
    }
    println("max ${max}")
    println("cnt ${cnt}")
}


/**
 * 슬라이딩 윈도우로 해결해보기
 */
fun blogSliding(x: Int, numArr: List<Int>) {
    var max = 0
    var cnt = 0
    var sum = 0

    for (i in 0..numArr.size - x) {
        if (i == 0) {
            for (j in 0..<x) {
                sum += numArr[j]
                max = sum
            }
        } else {
            sum = sum - numArr[i - 1] + numArr[i + x - 1]
            if (sum == max) {
                cnt++
            } else if (sum > max) {
                max = sum
                cnt = 1
            }
        }
    }

    println("max ${max}")
    println("cnt ${cnt}")
}