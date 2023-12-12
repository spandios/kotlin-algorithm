package slidingwindow

// 찬솔이는
// $X$일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
//
// 찬솔이를 대신해서
// $X$일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.
// https://www.acmicpc.net/problem/21921
// 고정된 기간에서 연속된 값을 구함 => 윈도우 슬라이딩
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
    println("max $max")
    println("cnt $cnt")
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

    println("max $max")
    println("cnt $cnt")
}
