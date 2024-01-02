package today_leetcode

fun main() {
println(findContentChildren(intArrayOf(1,2), intArrayOf(1,2,3)))
}

/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 *
 *
 */
fun findContentChildren(g: IntArray, s: IntArray): Int {
    var result = 0

    var gIndex = 0
    var sIndex = 0


    g.sort()
    s.sort()


    while (gIndex < g.size && sIndex < s.size){
        if(g[gIndex] <= s[sIndex]){
            result += 1
            gIndex++
            sIndex++
        }else{
            sIndex++
        }
    }



    return result
}