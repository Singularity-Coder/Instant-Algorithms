import java.util.ArrayList

// Permutations without Dups
// Write a method to compute all permutations of a string of unique characters.

fun main() {
    val list = getPerms("abcde")
    println("There are " + list!!.size + " permutations.")
    for (s in list) {
        println(s)
    }
}

fun getPerms(str: String?): ArrayList<String>? {
    if (str == null) {
        return null
    }
    val permutations = ArrayList<String>()
    if (str.isEmpty()) { // base case
        permutations.add("")
        return permutations
    }
    val first = str[0] // get the first character
    val remainder = str.substring(1) // remove the first character
    val words = getPerms(remainder)
    for (word in words!!) {
        for (j in 0..word.length) {
            val s = insertCharAt(word, first, j)
            permutations.add(s)
        }
    }
    return permutations
}

fun insertCharAt(word: String, c: Char, i: Int): String {
    val start = word.substring(0, i)
    val end = word.substring(i)
    return start + c + end
}