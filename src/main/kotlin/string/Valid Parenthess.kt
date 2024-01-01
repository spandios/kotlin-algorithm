package src.main.kotlin.string

import java.util.ArrayDeque

fun main() {
    isValid("()")
}

fun isValid(s: String): Boolean {
    val map = mapOf(Pair('(', ')'), Pair('{', '}'), Pair('[', ']'))
    val stack = ArrayDeque<Char>()
    val charArray = s.toCharArray()
    charArray.forEach {
        if (it == '(' || it == '{' || it == '[') {
            stack.addFirst(map[it]!!)
        } else {
            if (stack.isEmpty()) return false
            if (it != stack.pop()) {
                return false
            }
        }
    }
    if (stack.size > 0) return false
    return true
}
