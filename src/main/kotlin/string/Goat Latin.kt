package string

val vowel = listOf('a','e','i','o','u')

fun main() {
    println(toGoatLatin("I speak Goat Latin"))
}

/**
 * 1. If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 *
 * 2. If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * 3. Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 */
fun toGoatLatin(sentence: String): String {
    val strings = sentence.split(" ")
    return strings.mapIndexed { index, s -> refactor(s,index + 1) }.joinToString(" ")
}

fun refactor(str:String,index:Int): String{
    val sb = StringBuilder(str)
    vowelAndConsonant(sb)
    addA(sb, index)
    return sb.toString()
}

fun vowelAndConsonant(sb:StringBuilder): StringBuilder {
    val first = sb.first().lowercaseChar()

    if(first in vowel){
        sb.append("ma")
    }else{
        val first = sb.first()
        sb.deleteAt(0)
        sb.append(first)
        sb.append("ma")
    }
    return sb
}


fun addA(ssb:StringBuilder, index: Int){
    for (i in 0 ..< index){
        ssb.append('a')
    }
}