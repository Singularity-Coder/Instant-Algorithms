// Boolean Evaluation
// Given a boolean expression consisting of the symbols
// 0 (false), 1 (true), & (AND), I (OR), and /\ (XOR), and a desired boolean
// result value result, implement a function to count the
// number of ways of parenthesizing the expression such that it evaluates to result.

// EXAMPLE
// countEval("l /\01011", false) -> 2 countEval("0&0&0&1/\ll0", true) -> 10

var count = 0

fun main() {
    val expression = "0&0&0&1^1|0"
    val result = true
    println(countEval(expression, result))
    println(count)
}

fun stringToBool(c: String): Boolean = c == "1"

fun countEval(s: String, result: Boolean): Int {
    count++
    if (s.isEmpty()) return 0
    if (s.length == 1) return if (stringToBool(s) == result) 1 else 0
    var ways = 0
    var i = 1
    while (i < s.length) {
        val c = s[i]
        val left = s.substring(0, i)
        val right = s.substring(i + 1, s.length)
        var subWays = 0
        if (c == '^') { // required: one true and one false
            subWays = if (result) {
                val leftTrue = countEval(left, true)
                val leftFalse = countEval(left, false)
                val rightTrue = countEval(right, true)
                val rightFalse = countEval(right, false)
                leftTrue * rightFalse + leftFalse * rightTrue
            } else {
                val leftTrue = countEval(left, true)
                val leftFalse = countEval(left, false)
                val rightTrue = countEval(right, true)
                val rightFalse = countEval(right, false)
                leftTrue * rightTrue + leftFalse * rightFalse
            }
        } else if (c == '&') { // required: both true
            subWays = if (result) {
                val leftTrue = countEval(left, true)
                val rightTrue = countEval(right, true)
                leftTrue * rightTrue
            } else {
                val leftTrue = countEval(left, true)
                val leftFalse = countEval(left, false)
                val rightTrue = countEval(right, true)
                val rightFalse = countEval(right, false)
                leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse
            }
        } else if (c == '|') { // required: anything but both false
            subWays = if (result) {
                val leftTrue = countEval(left, true)
                val leftFalse = countEval(left, false)
                val rightTrue = countEval(right, true)
                val rightFalse = countEval(right, false)
                leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue
            } else {
                val leftFalse = countEval(left, false)
                val rightFalse = countEval(right, false)
                leftFalse * rightFalse
            }
        }
        ways += subWays
        i += 2
    }
    return ways
}