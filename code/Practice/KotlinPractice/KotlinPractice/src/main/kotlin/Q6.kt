class Q6 {

    fun main() {
        val str = "aaaabbbc"
        println(str)
        println(compressString(str))
    }

    // compress string - if it has repeating chars contiguously, replace with char,count. aaaaabbb = a4b3
// if u cannot compress then return the original string
// iterate over each char, keep track of the char, start counting comparing with next char as conditon
    fun compressString(str: String): String {
        if (str.length <= 2) return str

        var compressedStr = StringBuilder()
        var charCount = 0
        for (i in 0..str.lastIndex) {
            charCount++ // increment count until u find a diff char

            // check if the current char and next char r diff
            // i + 1 <= str.lastIndex && str[i] != str[i + 1] ----in this scenario if 7 is the last index then this condition will not satisfy since there is no 7 + 1 th element
            // In order to accomodate the last iteration value u need to allow the last iteration OR check for the difference btw i and i + 1
            // So a conditon for last iteration and one condition for all other iterations
            if (i + 1 >= str.lastIndex || str[i] != str[i + 1]) {
                compressedStr.append(str[i])
                compressedStr.append(charCount)
                charCount = 0 // reset count for new char
            }
        }

        return compressedStr.toString()
    }


    fun compressBad(str: String): String {
        var compressedString = ""
        var countConsecutive = 0
        for (i in 0 until str.length) {
            countConsecutive++

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length || str[i] != str[i + 1]) {
                compressedString += "" + str[i] + countConsecutive
                countConsecutive = 0
            }
        }
        return if (compressedString.length < str.length) compressedString else str
    }

    fun compress(str: String): String {
        val compressed = StringBuilder()
        var countConsecutive = 0
        for (i in 0 until str.length) {
            countConsecutive++

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length || str[i] != str[i + 1]) {
                compressed.append(str[i])
                compressed.append(countConsecutive)
                countConsecutive = 0
            }
        }
        return if (compressed.length < str.length) compressed.toString() else str
    }

    fun compress2(str: String): String {
        val finalLength = countCompression(str)
        if (finalLength >= str.length) return str
        val compressed = StringBuffer(finalLength) // initialize capacity
        var countConsecutive = 0
        for (i in 0 until str.length) {
            countConsecutive++

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length || str[i] != str[i + 1]) {
                compressed.append(str[i])
                compressed.append(countConsecutive)
                countConsecutive = 0
            }
        }
        return compressed.toString()
    }

    fun countCompression(str: String): Int {
        var compressedLength = 0
        var countConsecutive = 0
        for (i in 0 until str.length) {
            countConsecutive++

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length || str[i] != str[i + 1]) {
                compressedLength += 1 + countConsecutive.toString().length
                countConsecutive = 0
            }
        }
        return compressedLength
    }
}