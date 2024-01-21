package src.main.kotlin.explore.string2array.string

fun main() {
    println(longestCommonPrefix(arrayOf("", "")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1) {
        return strs[0]
    }
    var commonPreFixIndex = 0
    // 문자열 배열을 정렬합니다.
    strs.sort()

    while (true) {
        // 첫 번째 문자열과 마지막 문자열에서 commonPreFixIndex 위치의 문자를 비교합니다.
        val firstStrChar = strs[0].getOrNull(commonPreFixIndex) ?: break
        val lastStrChar = strs[strs.size - 1].getOrNull(commonPreFixIndex) ?: break

        if (firstStrChar == lastStrChar) {
            // 첫 번째 문자열과 마지막 문자열의 현재 위치의 문자가 같다면, 공통 접두사의 인덱스를 증가시킵니다.
            commonPreFixIndex++
        } else {
            // 그렇지 않다면, 공통 접두사가 더 이상 없는 것이므로 반복문을 탈출합니다.
            break
        }
    }

    if (commonPreFixIndex == 0) {
        // 공통 접두사가 없는 경우에는 빈 문자열("")을 반환합니다.
        return ""
    }

    // 공통 접두사가 있는 경우에는 첫 번째 문자열의 공통 접두사 부분을 반환합니다.
    return strs[0].substring(0, commonPreFixIndex)
}
