package string

fun main() {
    print(reorderLogFiles(arrayOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")).contentToString())
}

fun reorderLogFiles(logs: Array<String>): Array<String> {
    // 아이디를 제외한 나머지 문자열이 모두 스트링이면 문자 logs
    // 아이디를 제외한 나머지 문자열이 모두 넘버이면면 숫자 logs

    // 1. 문자 로그를 숫자 로그보다 빠른 인덱스

    // 2. letter 정렬은 id를 제외한 컨테츠를 기반으로 사전적 순서로 정렬함, 만약 각 컨텐츠가 모두 동일하다면 id를 기반으로 사전적 순서로 정렬함

    // 3. 숫자 logs는 기존 순서를 유지한다.
    val letterLogs = mutableListOf<String>()
    val digitsLogs = mutableListOf<String>()

    logs.forEach {
        if (it.split(" ")[1][0].isDigit()) {
            digitsLogs.add(it)
        } else {
            letterLogs.add(it)
        }
    }

    val sorted = letterLogs.sortedWith { s1, s2 ->
        // 각 문자열이 ""로 구분되어 있다. 맨 처음과 나머지만 필요하기 때문에 limit을 2로 둔다.
        val split1 = s1.split(" ", limit = 2)
        val split2 = s2.split(" ", limit = 2)

        // 0, 1 인덱스는 각각 id와 content이다.
        val (id, content) = split1
        val (id2, content2) = split2

//        if (content == content2) {
//            if (id == id2) {
//                0
//            } else if (id > id2) {
//                1
//            } else {
//                -1
//            }
//        }

        val compared = content.compareTo(content2)

        if (compared == 0) {
            id.compareTo(id2)
        } else {
            compared
        }
    }

    return (sorted + digitsLogs).toTypedArray()
}
