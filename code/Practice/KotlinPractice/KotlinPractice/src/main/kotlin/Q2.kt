import java.util.*

class Q2 {
    fun main(args: Array<String>) {
        val pairs = arrayOf(
            arrayOf("apple", "ppale"),
            arrayOf("mango", "maoen"),
            arrayOf("carrot", "rraoct")
        )
        for (pair in pairs) {
            val word1 = pair[0]
            val word2 = pair[1]
            // check word1 chars match word2
            println("${word2} is permutation of ${word1}: ${word2.isPermutationOf(word1)}")
        }
    }

    fun String.isPermutationOf(s: String): Boolean = this.sort() == s.sort()

    fun String.sort(): String = this.toSortedSet().joinToString("")

//    fun sort(s: String): String {
////    "mapple".toList().sorted().joinToString("")
////    "mapple".toSortedSet().joinToString("")
//        val content = s.toCharArray()
//        Arrays.sort(content)
//        return String(content)
//    }
//
//    fun permutation(s: String, t: String): Boolean {
//        return sort(s) == sort(t)
//    }
}

class Q2Variation {

    fun main() {
        arrayOf(
            arrayOf("carrot", "rrocat"),
            arrayOf("apple", "ppale"),
            arrayOf("M", "m"),
            arrayOf("Na", "aN"),
        ).forEach {
            println("${it[0]} is a permutation of ${it[1]}: ${isPermutation(s1 = it[0], s2 = it[1])}")
        }
    }

    fun isPermutation(s1: String, s2: String): Boolean {
        // if lengths are diff then they are not
        if (s1.length != s2.length) return false
        if (s1.length == 1) {
            return s1[0].code == s2[0].code
        }

        val flagsArray = IntArray(128) // Standard ASCII char set number of elems

        for (i in 0 until s1.length) {
            flagsArray.set(index = s1[i].code, value = flagsArray[s1[i].code] + 1)
        }

        for (j in 0 until s2.length) {
            flagsArray.set(index = s2[j].code, value = flagsArray[s2[j].code] - 1)
            if (flagsArray[s2[j].code] < 0) return false
        }

        return true
    }

}