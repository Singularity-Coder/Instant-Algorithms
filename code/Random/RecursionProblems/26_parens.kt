// Parens
// Implement an algorithm to print all valid
// (e.g., properly opened and closed) combinations of n pairs of parentheses.

// EXAMPLE
// Input: 3
// Output: ((())), (()()), (())(), ()(()), ()()()

fun main() {
    val list = generateParens(4)
    for (s in list) println(s)
    println(list.size)
}

fun insertInside(str: String, leftIndex: Int): String {
    val left = str.substring(0, leftIndex + 1)
    val right = str.substring(leftIndex + 1, str.length)
    return "$left()$right"
}

fun generateParens(remaining: Int): Set<String> {
    val set: MutableSet<String> = HashSet()
    if (remaining == 0) set.add("") else {
        val prev = generateParens(remaining - 1)
        for (str in prev) {
            for (i in 0 until str.length) {
                if (str[i] == '(') {
                    val s = insertInside(str, i)
                    /* Add s to set if it is not already in there. Note:
						 * HashSet automatically checks for duplicates before
						 * adding, so an explicit check is not necessary. */set.add(s)
                }
            }
            set.add("()$str")
        }
    }
    return set
}