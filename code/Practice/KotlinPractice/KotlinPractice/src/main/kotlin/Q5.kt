import kotlin.math.abs

class Q5 {
    fun main(){
        val a = "pale"
        val b = "plae"
        val isOneEdit = oneEditAway(a, b)
        println("$a, $b: $isOneEdit")
//    println(oneEditLeft2(a, b))
    }

    // The imp thing is to understand that this is simply meant to determine if it is 1 edit away or not and nto to do any sort of operation or modification on the stirngs
// Insert, Update, Delete a char - check
// check if char needs to be udpated from a space to a low case char or remove it and add a space in its place
// check if str 1 == str 2 ---- char size of str equality, same order. Iterate over b, maintain count of modifications
    fun oneEditLeft(str1: String, str2: String): Boolean {
        // check if both string lengths are 1 edit apart
        if (str2.length > str1.length && str1.length != str2.length - 1) return false
        if (str1.length > str2.length && str2.length != str1.length - 1) return false
//    if (str1.length == str2.length)

        // Insert - in 4 chars 3 are correct n present. Need to add 4th
        // Update - in 4 chats 4 r present but 1 char is wrong n must be updated

        // Check if less char string has all chars of more char string. create an ASCII array of large char string and iterate over less char string
        val arr = Array<Int>(256, { int -> 0 })
        var charPresentCount = 0
        if (str1.length > str2.length) {
            for (i in 0..str1.length - 1) {
                arr[str1[i].code] = 1
            }
            // check if str1 has all chars of str2
            for (i in 0..str2.length - 1) {
                if (arr[str2[i].code] == 1) {
                    charPresentCount++
                }
            }
            println("arr: ${arr.contentToString()}")
            println("presentCount: $charPresentCount")
            return charPresentCount == str1.length - 1 // insert condition
        } else {
            for (i in 0..str2.length - 1) {
                arr[str2[i].code] = 1
            }
            // check if str1 has all chars of str2
            for (i in 0..str1.length - 1) {
                if (arr[str1[i].code] == 1) {
                    charPresentCount++
                }
            }
            println("arr: ${arr.contentToString()}")
            println("presentCount: $charPresentCount")
            return charPresentCount == str2.length - 1 // insert condition
        }

        // Check the anomoly in the less char string. determine if its an update or an add
    }

    fun oneEditLeft2(correctStr: String, wrongStr: String): Boolean {
        if (Math.abs(correctStr.length - wrongStr.length) > 1) return false

        // wrong string can be equal to or > than correct string
        // Compare every char of correctStr to every char of wrongStr. O(n^2) sol. No extra space needed
        var correctCharCount = 0
        for (i in 0.. correctStr.lastIndex) {
            for (j in 0..wrongStr.lastIndex) {
                if (correctStr[i] == wrongStr[j]) {
                    correctCharCount++
                    break
                }
            }
        }
        // insert - if 1 char missing
        // update - if wrong char present
        // delete - if 1 extra char is present
        println("count: $correctCharCount")

        return correctStr.length - correctCharCount == 1
    }

    // U do replace when both s1 and s2 have same length
    fun oneEditReplace(correctStr: String, wrongStr: String): Boolean {
        var foundDifference = false
        for (i in 0 until correctStr.length) {
            if (correctStr[i] != wrongStr[i]) {
                if (foundDifference) { // For 2nd difference return false
                    return false
                }
                foundDifference = true
            }
        }
        return true
    }

    /* Check if you can insert a character into s1 to make s2. */
    fun oneEditInsert(correctStr: String, wrongStr: String): Boolean {
        var index1 = 0
        var index2 = 0
        // A way to avoid nested loops to compare elements
        // variable pointers
        while (index2 < wrongStr.length && index1 < correctStr.length) {
            // Does edit mean removing a char as well?
            // first check if both values are the same
            // if not then check value by increasing the wrongstr pointer
            // if the above also fails then its not a single edit away'
            // Here wrong sequence is also an edit. That is why u can quit iteration if the sequence of correctStr does not match with the sequence of wrongStr
            if (correctStr[index1] != wrongStr[index2]) {
                if (index1 != index2) {
                    return false
                }
                index2++
            } else {
                index1++
                index2++
            }
        }
        return true
    }

    fun oneEditAway(first: String, second: String): Boolean {
        if (first.length == second.length) {
            return oneEditReplace(first, second)
        } else if (first.length + 1 == second.length) {
            return oneEditInsert(first, second)
        } else if (first.length - 1 == second.length) {
            return oneEditInsert(second, first)
        }
        return false
    }



}

class OneEditVariation {

    fun main() {
        val a = "palee"
        val b = "pale"
        val isOneEdit1 = oneEditAway(a, b)
        println("$a, $b: $isOneEdit1")
        val c = "pale"
        val d = "pkle"
        val isOneEdit2 = oneEditAway(c, d)
        println("$c, $d: $isOneEdit2")
//        println(oneEditAway("abcd", "abkdk"))
    }

    fun oneEditAway(first: String, second: String): Boolean {
        /* Length checks. */
        if (abs((first.length - second.length).toDouble()) > 1) {
            return false
        }

        /* Get shorter and longer string.*/
        val s1 = if (first.length < second.length) first else second
        val s2 = if (first.length < second.length) second else first
        var index1 = 0
        var index2 = 0
        var foundDifference = false
        while (index2 < s2.length && index1 < s1.length) {
            if (s1[index1] != s2[index2]) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false
                foundDifference = true
                if (s1.length == s2.length) { // On replace, move shorter pointer
                    index1++
                }
            } else {
                index1++ // If matching, move shorter pointer
            }
            index2++ // Always move pointer for longer string
        }
        return true
    }

    fun oneEditAway2(first: String, second: String): Boolean {
        // Check if the string lengths are 1 edit away
        if (abs(first.length - second.length) > 1) return false

        val s1 = if (first.length < second.length) first else second
        val s2 = if (first.length < second.length) second else first
        var index1 = 0
        var index2 = 0
        var isCharFoundOnce = false

        while (index2 < s2.length && index1 < s1.length) {
            // check if there is a deviation in the sequence of chars for both the strs
            if (s2[index2] != s1[index1]) {
                if (isCharFoundOnce) return false // this shows there are 2 chars in a sequence that are wrong
                isCharFoundOnce = true

                // For inserts u must compare the lengths of the strings. If it is simply update then no need to increment
                if (s1.length == s2.length) index1++
            } else {
                index1++
            }
            index2++
        }

        return true
    }
}

class OneEdit3 {

    fun main() {
        println(oneEditAway2("mango", "mangoo"))
    }
    fun oneEditAway2(first: String, second: String): Boolean {
        // When both are same then its update/replace
        if (first.length == second.length) {
            return isReplace(first, second)
        }

        // if first is bigger
        if (first.length - 1 == second.length) {
            return isInsert(first, second)
        }

        // if second is bigger
        if (second.length - 1 == first.length) {
            return isInsert(second, first)
        }

        return false
    }

    fun isReplace(first: String, second: String): Boolean {
        if (first.length != second.length) return false

        // if 2 consecutive chars are not matching in both the strings
        var isMismatch = false
        for (i in 0..first.lastIndex) {
            if (first[i] != second[i]) {
                if (isMismatch) return false
                isMismatch = true
            }
        }
        return true
    }

    fun isInsert(first: String, second: String): Boolean {
        // check if the string lengths are 1 length away
        if (abs(first.length - second.length) - 1 != 0) return false

        val s1 = if (first.length < second.length) first else second
        val s2 = if (first.length < second.length) second else first
        var index1 = 0
        var index2 = 0
        var isMismatch = false

        while (index2 < s2.length && index1 < s1.length) {
            if (s1[index1] != s2[index2]) {
                if (isMismatch) return false
                isMismatch = true
                index1++
            } else index1++
            index2++
        }

        return true
    }

}