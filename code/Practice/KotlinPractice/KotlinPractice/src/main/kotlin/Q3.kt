class Q3 {

    fun main() {
        replaceSpaces(str = "Mr John Smith    ")
    }

    fun replaceSpaces2(str: String): String = str.trim().replace(" ", "%20", true)

    // Assume string has sufficient free space at the end
    fun replaceSpaces(str: String) {
        val strArr = str.toCharArray()
        val trueLength: Int =
            findLastCharacter(strArr) + 1 // get index of last char that is not a space. true length is last index + 1

        println("trueLength: $trueLength")

        // trueLength is the length of the statement with spaces in btw but not at the start and end of sentence
        var spaceCount = 0
        var i = 0

        // Count all spaces. i is the length of the statement with spaces in btw the words as well but not at the start and end of the words
        // spaceCount is teh spaces present in btw the words in sentence
        while (i < trueLength) {
            if (strArr[i] == ' ') {
                spaceCount++
            }
            i++
        }

        println("i: $i")
        println("spaceCount: $spaceCount")

        var index: Int =
            trueLength + spaceCount * 2 // This is to accommodate %,2,0 chars. In the 17 slots, 13 are the actual slots with 2 spaces in btw. So total 6 spaces for 2 sets of %,2,0 chars.
//    if (trueLength < strArr.size) strArr[trueLength] = '\u0000' // NULL char
        i = trueLength - 1 // last index

        println("index: $index")

        // i is 13 in this case. So it checks if strArr[13] == ' ' which its not. Its 'h'. So else triggers. Then strArr[17 - 1] = strArr[13]. u r assigning 13th pos to 17th pos.
        // And for every space u need to add %20 so 3 slots are occupied and removed from index
        while (i >= 0) {
            if (strArr[i] == ' ') {
                strArr[index - 1] = '0'
                strArr[index - 2] = '2'
                strArr[index - 3] = '%'
                index = index - 3
            } else {
                println("strArr[index - 1]: ${strArr[index - 1]}")
                println("strArr[i]: ${strArr[i]}")
                strArr[index - 1] = strArr[i]
                index--
            }
            i--
        }

        println(charArrayToString(strArr))
    }

    fun findLastCharacter(str: CharArray): Int {
        for (i in str.indices.reversed()) {
            if (str[i] != ' ') {
                return i
            }
        }
        return -1
    }

    fun charArrayToString(array: CharArray): String {
        val buffer = StringBuilder(array.size)
        for (c in array) {
            if (c.code == 0) {
                break
            }
            buffer.append(c)
        }
        return buffer.toString()
    }
}

class Q3Variation {

    fun main() {
        replaceSpacesWithPerc20("  Hello My New World    ")
    }

    fun replaceSpacesWithPerc20(str: String) {
        // find the true length of the string without the stray spaces at the start and the end but with required spaces in btw
        // Then find the required spaces in btw the words

        val charArr = str.toCharArray()

        println(charArr.contentToString())

        var firstPos = 0
        for (i in 0..charArr.size - 1) {
            if (charArr[i] != ' ') {
                firstPos = i
                break
            }
        }

        var lastPos = 0
        for (i in charArr.size - 1 downTo 0) {
            if (charArr[i] != ' ') {
                lastPos = i
                break
            }
        }

        if (charArr[0] == ' ') {
            for (i in 0..charArr.lastIndex) {
                if ((i + firstPos) < charArr.lastIndex) {
                    charArr[i] = charArr[i + firstPos]
                    charArr[i + firstPos] = ' '
                }
            }
            println("rotateArray: ${charArr.contentToString()}")
        }

//    val oldTrueLengthOfStr = lastPos - firstPos + 1
        var trueLengthOfStr = 0
        for (i in charArr.size - 1 downTo 0) {
            if (charArr[i] != ' ') {
                trueLengthOfStr = i + 1
                break
            }
        }

        println("trueLengthOfStr: $trueLengthOfStr")

        var requiredSpaceCount = 0
//    for (i in firstPos..lastPos) {
//        if (charArr[i] == ' ') {
//            requiredSpaceCount++
//        }
//    }
        for (i in 0..trueLengthOfStr - 1) {
            if (charArr[i] == ' ') {
                requiredSpaceCount++
            }
        }

        println("requiredSpaceCount: $requiredSpaceCount")

        var index =
            trueLengthOfStr - 1 + requiredSpaceCount * 2 // * 2 is to fit 20 into spaces. % is handled by the spaces in btw the sentences. So 3 slots for %20 * 3 spaces

        println("index: $index")

        for (i in trueLengthOfStr - 1 downTo 0) {
            if (charArr[i] == ' ') {
                charArr[index] = '0'
                charArr[index - 1] = '2'
                charArr[index - 2] = '%'

                println("i: $i")
                println("index: $index")
                println(charArr.contentToString())
                println("requiredSpaceCount: $requiredSpaceCount")

                index -= 3
                requiredSpaceCount--
            } else {
                charArr[index] = charArr[i]

                println("i: $i")
                println("index: $index")
                println(charArr.contentToString())

                index--
            }
        }

        println(charArr.contentToString())
    }
}