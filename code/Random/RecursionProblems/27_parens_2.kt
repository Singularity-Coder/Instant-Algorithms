import java.util.ArrayList

// Parens
// Implement an algorithm to print all valid
// (e.g., properly opened and closed) combinations of n pairs of parentheses.

// EXAMPLE
// Input: 3
// Output: ((())), (()()), (())(), ()(()), ()()()

fun main() {
    val list = generateParens(6)
    for (s in list) println(s)
    println(list.size)
}

fun addParen(list: ArrayList<String?>, leftRem: Int, rightRem: Int, str: CharArray, index: Int) {
    if (leftRem < 0 || rightRem < leftRem) return  // invalid state
    if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
        list.add(String(str))
    } else {
        str[index] = '(' // Add left and recurse
        addParen(list, leftRem - 1, rightRem, str, index + 1)
        str[index] = ')' // Add right and recurse
        addParen(list, leftRem, rightRem - 1, str, index + 1)
    }
}

fun generateParens(count: Int): ArrayList<String?> {
    val str = CharArray(count * 2)
    val list = ArrayList<String?>()
    addParen(list, count, count, str, 0)
    return list
}