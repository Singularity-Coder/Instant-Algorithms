import java.util.ArrayList

// Permutations without Dups
// Write a method to compute all permutations of a string of unique characters.

fun main() {
    val list = getPerms("abc")
    println("There are " + list.size + " permutations.")
    for (s in list) {
        println(s)
    }
}

fun getPerms(remainder: String): ArrayList<String> {
    val len = remainder.length
    val result = ArrayList<String>()

    /* Base case. */
    if (len == 0) {
        result.add("") // Be sure to return empty string!
        return result
    }
    for (i in 0 until len) {
        /* Remove char i and find permutations of remaining characters.*/
        val before = remainder.substring(0, i)
        val after = remainder.substring(i + 1, len)
        val partials = getPerms(before + after)

        /* Prepend char i to each permutation.*/
        for (s in partials) {
            result.add(remainder[i].toString() + s)
        }
    }
    return result
}