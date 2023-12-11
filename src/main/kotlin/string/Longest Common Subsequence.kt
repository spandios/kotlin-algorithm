package src.main.kotlin.string

fun main() {
}

// subsequence란 어떤 문자열에서 새로운 문자열인데 이것은 기존의 문자열의 순서를 지키되 몇개의 문자가 (안지워질수있음) 삭제된 것이다.
// 두 문자열에서 공통인 부분 subsequence중 가장 길이가 긴 subsequecne구하기
// DP부분이라 아직 못풀겠음
// TODO DP끝나고 돌아오기
fun longestCommonSubsequence(text1: String, text2: String): Int {
    // 생각1 같으면 아무거나 잡아서 length
    if (text1 == text2) {
        return text1.length
    }

    if (text1.length > text2.length) {
    } else if (text1.length < text2.length) {
    }

    // 못찾으면 0
    return 0
}
