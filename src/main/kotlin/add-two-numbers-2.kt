import java.math.BigInteger

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1!!.next!!.next = ListNode(3)
    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2!!.next!!.next = ListNode(4)
    addTwoNumbers(l1, l2)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 *
 */

fun nodeToInt(strBuilder: StringBuilder, node: ListNode?) {
    if (node?.next != null) {
        nodeToInt(strBuilder, node.next!!)
    }
    strBuilder.append(node?.`val`)
}

fun injectNext(node: ListNode?, value: Int) {
    if (node?.next == null) {
        node?.next = ListNode(value)
    } else {
        injectNext(node.next, value)
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val strBuilder1 = StringBuilder()
    val strBuilder2 = StringBuilder()
    nodeToInt(strBuilder1, l1)
    nodeToInt(strBuilder2, l2)

    val left = BigInteger(strBuilder1.toString())
    val right = BigInteger(strBuilder2.toString())

    val result = left + right
    val resultString = result.toString().reversed()
    var resultNode: ListNode? = null

    resultString.forEach { c ->
        val n = c.digitToInt()
        if (resultNode == null) {
            resultNode = ListNode(c.digitToInt())
        } else {
            injectNext(resultNode, n)
        }
    }

    return resultNode
}
