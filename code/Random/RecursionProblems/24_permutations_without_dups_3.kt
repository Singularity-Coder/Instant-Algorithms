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

fun getPerms(prefix: String, remainder: String, result: ArrayList<String?>) {
    if (remainder.isEmpty()) {
        result.add(prefix)
    }
    val len = remainder.length
    for (i in 0 until len) {
        val before = remainder.substring(0, i)
        val after = remainder.substring(i + 1, len)
        val c = remainder[i]
        getPerms(prefix + c, before + after, result)
    }
}

fun getPerms(str: String): ArrayList<String?> {
    val result = ArrayList<String?>()
    getPerms("", str, result)
    return result
}