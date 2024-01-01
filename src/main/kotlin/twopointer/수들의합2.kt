package src.main.kotlin.twopointer

// https://www.acmicpc.net/problem/2003
// N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
fun main() {
    function(listOf(1, 2, 3, 4, 2, 5, 3, 1, 1, 2), 5)
}

// 반복문
fun function(
    l: List<Int>,
    m: Int,
): Int {
    var cnt = 0
    for (i in l.indices) {
        var sum = l[i]
        if (sum == m) {
            cnt++
            continue
        }
        for (j in i + 1..<l.size) {
            sum += l[j]
            if (sum > m) {
                break
            }
            if (sum == m) {
                cnt++
                break
            }
        }
    }
    return cnt
}

// two pointer도 윈도우 슬라이딩과 마찬가지로 1차원 배열에서 연속된 된 값을 구할 때 사용할 수 있다.
// 다만 윈도우슬라이딩은 고정된 범위라면 포인터는 한 인덱스씩 움직이면서 체크한다.
fun functionTwoPointer(
    l: List<Int>,
    m: Int,
): Int {
    var cnt = 0

    var start = 0

    var end = 0

    var sum = 0

    while (true) {
        if (end == l.size - 1) {
            break
        }
        if (sum < m) {
            sum += l[end++]
        } else {
            sum -= l[start++]
        }

        if (sum == m) {
            cnt++
        }
    }

    return cnt
}
