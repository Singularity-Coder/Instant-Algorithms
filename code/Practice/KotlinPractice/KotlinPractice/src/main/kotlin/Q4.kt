class Q4 {
    fun main() {
        val pali = "AattqaA"
        println(isPermutationOfPalindrome(pali))
    }

    // Permutation means arrangement
// Palindrome means it reads the same forwards and backwards
    fun isPermutationOfPalindrome(phrase: String?): Boolean {
        val table: IntArray = buildCharFrequencyTable(phrase)
        return checkMaxOneOdd(table)
    }

    // In Palindrome the chars have to be even count as each char has a mirror rep on the other side: Ex: Rat s taR. And it can only have a single odd char count.
    private fun checkMaxOneOdd(table: IntArray): Boolean {
        var foundOdd = false
        for (count in table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false // In the next iteration you return false because u already saw 1 odd
                }
                foundOdd = true // This is set to true for seeing the first odd
            }
        }
        return true
    }

    // Num of times a char appeared in the string. If char a appeared twice then in the table you will see the first position updated to 2. 26 positions for 26 letters.
    private fun buildCharFrequencyTable(phrase: String?): IntArray {
        println('z'.code - 'a'.code + 1)
        println('a'.code)
        println('z'.code)
        val table = IntArray('z'.code - 'a'.code + 1) // Num of english alphabets
        for (c in phrase?.toCharArray()!!) {
            val x = getCharNumber(c)
            if (x != -1) {
                table[x] = table[x] + 1
            }
        }
        println("table: ${table.contentToString()}")
        return table
    }

    // This solution is only for low case chars and all up case will be ignored
    private fun getCharNumber(char: Char): Int {
        return if (char.code in 'a'.code..'z'.code) {
            println("char num: ${char.code - 'a'.code}")
            char.code - 'a'.code
        } else -1
    }
}

class Q4Variation {

    fun main() {
        val pali = "Ratzs live on no evil starz"
        val pali2 = "Zeus was deified, saw Suez"
        println(isPermutationOfPalindrome("ZabaabaZ"))
    }
    fun isPermutationOfPalindrome(sentence: String): Boolean {
        // check if the sentence has even set of chars and/or a single odd char count
        val table = getCharTable(sentence)
        var oddCount = 0
        for (count in table) {
            if (count % 2 == 1) {
                oddCount++
                if (oddCount > 1) return false
            }
        }
        return true
    }

    // create a table of low case letter char code count
// goal is to check if the table contains no more than 1 odd char count
// constrain urself to low case only. if u need up case then u need a diff table and a diff set of similar computation
    fun getCharTable(sentence: String): IntArray {
        val englishLowCaseAlphabetCount = 'z'.code - 'a'.code + 1 // 26
        val arr = IntArray(englishLowCaseAlphabetCount)
        for (char in sentence) {
            if (char.code < 'a'.code || char.code > 'z'.code) continue
            arr[char.code - 'a'.code]++
        }
        println(arr.contentToString())
        return arr
    }

    fun getCharTable2(sentence: String): Boolean {
        val englishLowCaseAlphabetCount = 'z'.code - 'a'.code + 1 // 26
        val table = IntArray(englishLowCaseAlphabetCount)
        var oddCount = 0
        for (char in sentence) {
            if (char.code < 'a'.code || char.code > 'z'.code) continue
            val alphabet = char.code - 'a'.code
            table[alphabet]++
            if (table[alphabet] % 2 == 1) {
                oddCount++
            } else {
                oddCount--
            }
        }
        return oddCount <= 1
    }
}

class Q4BitwiseOps {
    fun main() {
        val pali = "Rats live on no evil star"
//    println(isPermutationOfPalindrome(pali))
        println("sum: ${sum()}")
    }

    fun sum(): Int {
        var sum = 0
        for (i in 0..32) {
            sum += Math.pow(2.0, i.toDouble()).toInt()
        }
        return sum
    }


    // For now think of bitwise AND as subtracting and bitwise OR as adding the value
// bitwise OR is for turning on a bit and AND is to turn off a bit. Someting like that
    fun isPermutationOfPalindrome(phrase: String): Boolean {
        val bitVector = createBitVector(phrase) // bit set or bit array or bit vector
        return checkAtMostOneBitSet(bitVector)
    }

    /* Create bit vector for string. For each letter with value i,
         * toggle the ith bit. */
// bitVector accumulates the value which in the binary form becomes like a list of values stored
// each mask is an item in the bitVector binary rep list
    fun createBitVector(phrase: String): Int {
        var bitVector = 0
        for (c in phrase.toCharArray()) {
            bitVector = toggle(bitVector, getCharCode(c))
        }
        return bitVector
    }

    /* Check that at most one bit is set by subtracting one from the
         * integer and ANDing it with the original integer. */
    fun checkAtMostOneBitSet(bitVector: Int): Boolean = bitVector and bitVector - 1 == 0 // Why AND with itself?

    /* Toggle the ith bit in the integer. */
// Kotlin inv() seems to be increasing a bit by 1 with a negative value instead of decresing it by 1. Is this 2s complement thing?
// With masks u can store boolean values at specific bit positions. So instead of creating an array n setting a value to a positon u can turn a bit on or off for a value itself. efficient. No need of DS
    fun toggle(bitVec: Int, charCode: Int): Int {
        var bitVector = bitVec
        println("bitVector1: $bitVector")
        println("charCode: $charCode")
        if (charCode < 0) return bitVector
        val mask = 1 shl charCode // mask for a certain charcode value. if charcode is 17 then u shl 17 bits. Mask here is value instead of binary rep. Mask can be perfomed by any bitwise op
        println("mask: $mask")
//    println("bitVector and mask: ${bitVector and mask}")
//    println("mask.inv(): ${mask.inv()}")
        bitVector = if (bitVector and mask == 0) { // this is subtraction
//        println("bitVector or mask: ${bitVector or mask}")
            bitVector or mask // we are adding mask value to bitvector value
        } else {
//        println("bitVector and mask.inv(): ${bitVector and mask.inv()}")
            bitVector and mask.inv() // why mask.inv() - maybe because we masked it with 1 shl charCode. Since inv() will remove 1 from value
        }
        println("bitVector2: $bitVector")
        println()
        println()
        return bitVector
    }

    private fun getCharCode(char: Char): Int {
        return if (char.code in 'a'.code..'z'.code) {
            char.code - 'a'.code
        } else -1
    }

    fun bitMasking() {
        // Binary literals in Java use the 0b prefix
        val READ_PERMISSION = 1
        val WRITE_PERMISSION = 2
        val EXECUTE_PERMISSION = 4

        // Bitwise OR and AND
        val userPermissions = READ_PERMISSION or EXECUTE_PERMISSION // 0b011 = 3

        // Bitwise AND
        val canReadBitwise = userPermissions and READ_PERMISSION == READ_PERMISSION
        val canWriteBitwise = userPermissions and WRITE_PERMISSION == WRITE_PERMISSION
        val canExecuteBitwise = userPermissions and EXECUTE_PERMISSION == EXECUTE_PERMISSION

        // Logical OR and AND
        val userPermissionsLogical = READ_PERMISSION or WRITE_PERMISSION

        // Logical OR
        val canReadLogical = userPermissionsLogical == READ_PERMISSION || userPermissionsLogical == WRITE_PERMISSION
        val canWriteLogical = userPermissionsLogical == WRITE_PERMISSION || userPermissionsLogical == READ_PERMISSION
        val canExecuteLogical =
            userPermissionsLogical == EXECUTE_PERMISSION || userPermissionsLogical == READ_PERMISSION || userPermissionsLogical == WRITE_PERMISSION
        println("Bitwise - User Permissions: " + Integer.toBinaryString(userPermissions))
        println("Bitwise - Can Read: $canReadBitwise")
        println("Bitwise - Can Write: $canWriteBitwise")
        println("Bitwise - Can Execute: $canExecuteBitwise")
        println("Logical - User Permissions: " + Integer.toBinaryString(userPermissionsLogical))
        println("Logical - Can Read: $canReadLogical")
        println("Logical - Can Write: $canWriteLogical")
        println("Logical - Can Execute: $canExecuteLogical")
    }
}