package string

fun main() {
    groupAnagrams(arrayOf("ac", "c"))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        // 정렬해서 같은거인지 확인할 수 있음
        val sortedString = str.toCharArray().sortedArray().joinToString("")
        // 정렬한 키가 없으면 list초기화
        result.getOrPut(sortedString) { mutableListOf() }
        // 정렬된 키 값을 str에 넣기
        result[sortedString]!!.add(str)
    }

    return ArrayList(result.values)
}
