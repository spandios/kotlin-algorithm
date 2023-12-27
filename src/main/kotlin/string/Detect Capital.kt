package string

fun main() {
    println(detectCapitalUse("Google"))

}

fun detectCapitalUse(word: String): Boolean {
    if(word.first().isUpperCase()){
        var isNextCharAllUpper = true
        var isNextCharAllLower = true

        if(word.length > 1){

            for (i in 1 ..<word.length){
                if(word[i].isUpperCase()){
                    isNextCharAllLower = false
                }else{
                    isNextCharAllUpper = false
                }
            }
        }

        return isNextCharAllUpper || isNextCharAllLower
    }else{
        return word.all { it.isLowerCase() }
    }
}