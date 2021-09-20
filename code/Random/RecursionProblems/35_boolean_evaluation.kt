// Boolean Evaluation
// Given a boolean expression consisting of the symbols
// 0 (false), 1 (true), & (AND), I (OR), and /\ (XOR), and a desired boolean
// result value result, implement a function to count the
// number of ways of parenthesizing the expression such that it evaluates to result.

// EXAMPLE
// countEval("l /\01011", false) -> 2 countEval("0&0&0&1/\ll0", true) -> 10

var count = 0

fun main() {
    val expression = "0^0|1&1^1|0|1"
    val result = true
    println(countEval(expression, result))
    println(count)
}

fun stringToBool(c: String): Boolean {
    return if (c == "1") true else false
}

fun countEval(s: String, result: Boolean): Int {
    count++
    if (s.length == 0) return 0
    if (s.length == 1) return if (stringToBool(s) == result) 1 else 0
    var ways = 0
    var i = 1
    while (i < s.length) {
        val c = s[i]
        val left = s.substring(0, i)
        val right = s.substring(i + 1, s.length)
        val leftTrue = countEval(left, true)
        val leftFalse = countEval(left, false)
        val rightTrue = countEval(right, true)
        val rightFalse = countEval(right, false)
        val total = (leftTrue + leftFalse) * (rightTrue + rightFalse)
        var totalTrue = 0
        if (c == '^') { // required: one true and one false
            totalTrue = leftTrue * rightFalse + leftFalse * rightTrue
        } else if (c == '&') { // required: both true
            totalTrue = leftTrue * rightTrue
        } else if (c == '|') { // required: anything but both false
            totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse
        }
        val subWays = if (result) totalTrue else total - totalTrue
        ways += subWays
        i += 2
    }
    return ways
}

object Others {

    fun main() {
        val terms = "0^0|1&1^1|0|1"
        val result = true
        bruteForce(terms, HashMap(), result, BooleanArray((terms.length - 1) / 2))
        println(countR(terms, result, 0, terms.length - 1))
        println(countDP(terms, result, 0, terms.length - 1, HashMap()))
        println(countDPEff(terms, result, 0, terms.length - 1, HashMap()))
    }

    fun reduce(expression: String, start: Int, end: Int): String {
        if (start == end) {
            if (expression[start] == '1') {
                return "1"
            } else if (expression[start] == '0') {
                return "0"
            }
        }
        var count = 0
        var i = 0
        val reduced = arrayOfNulls<String>(3)
        var index = 0
        var left = start
        var right = start
        i = start
        while (i <= end) {
            if (expression[i] == '(') {
                if (count == 0) {
                    left = i + 1
                }
                count++
            } else if (expression[i] == ')') {
                count--
                if (count == 0) {
                    right = i - 1
                }
            }
            if (count == 0) {
                reduced[index] = reduce(expression, left, right)
                if (index == 0) {
                    reduced[index + 1] = Character.toString(expression[i + 1])
                    i += 1
                    left = i + 1
                    right = i + 1
                }
                index += 2
            }
            i++
        }
        if (reduced[1] == "&") {
            return if (reduced[0] == "1" && reduced[2] == "1") "1" else "0"
        } else if (reduced[1] == "|") {
            return if (reduced[0] == "1" || reduced[2] == "1") "1" else "0"
        } else if (reduced[1] == "^") {
            if (reduced[0] == "1" && reduced[2] == "0") return "1" else if (reduced[0] == "0" && reduced[2] == "1") return "1"
            return "0"
        }
        return "0"
    }

    fun evaluate(expression: String, start: Int, end: Int): Boolean {
        val result = reduce(expression, start, end)
        return result !== "0"
    }

    fun isOperator(c: Char): Boolean {
        return when (c) {
            '&', '|', '^' -> true
            else -> false
        }
    }

    fun insertParensAround(expression: String, ind: Int): String {
        var left = 0
        var right = 0
        var index = 0
        var count = 0
        for (i in 0 until expression.length) {
            if (isOperator(expression[i])) {
                if (count == ind) {
                    index = i
                }
                count++
            }
        }
        count = 0
        for (i in index - 1 downTo 0) {
            if (expression[i] == ')') {
                count++
            } else if (expression[i] == '(') {
                count--
            }
            if (count == 0) {
                left = i
                break
            }
        }
        count = 0
        for (i in index + 1..expression.length) {
            if (expression[i] == '(') {
                count++
            } else if (expression[i] == ')') {
                count--
            }
            if (count == 0) {
                right = i
                break
            }
        }
        return if (left == 0 && right == expression.length - 1) {
            expression
        } else expression.substring(0, left) + '(' + expression.substring(left, right + 1) + ')' + expression.substring(right + 1)
    }

    fun bruteForce(expression: String, completed: HashMap<String?, Boolean?>, result: Boolean, flags: BooleanArray): Int {
        var count = 0
        var isDone = true
        if (completed.containsKey(expression)) {
            return 0
        }
        for (i in flags.indices) {
            if (!flags[i]) {
                flags[i] = true
                val newexpression = insertParensAround(expression, i)
                isDone = false
                count += bruteForce(newexpression, completed, result, flags)
                flags[i] = false
            }
        }
        if (isDone) {
            return if (evaluate(expression, 0, expression.length - 1) == result) {
                //System.out.println(expression + " = " + result);
                1
            } else {
                //System.out.println(expression + " = " + !result);
                0
            }
        }
        completed[expression] = true
        return count
    }

    fun countR(exp: String, result: Boolean, start: Int, end: Int): Int {
        if (start == end) {
            if (exp[start] == '1' && result) {
                return 1
            } else if (exp[start] == '0' && !result) {
                return 1
            }
            return 0
        }
        var c = 0
        if (result) {
            var i = start + 1
            while (i <= end) {
                val op = exp[i]
                if (op == '&') {
                    c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
                } else if (op == '|') {
                    c += countR(exp, true, start, i - 1) * countR(exp, false, i + 1, end)
                    c += countR(exp, false, start, i - 1) * countR(exp, true, i + 1, end)
                    c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
                } else if (op == '^') {
                    c += countR(exp, true, start, i - 1) * countR(exp, false, i + 1, end)
                    c += countR(exp, false, start, i - 1) * countR(exp, true, i + 1, end)
                }
                i += 2
            }
        } else {
            var i = start + 1
            while (i <= end) {
                val op = exp[i]
                if (op == '&') {
                    c += countR(exp, false, start, i - 1) * countR(exp, true, i + 1, end)
                    c += countR(exp, true, start, i - 1) * countR(exp, false, i + 1, end)
                    c += countR(exp, false, start, i - 1) * countR(exp, false, i + 1, end)
                } else if (op == '|') {
                    c += countR(exp, false, start, i - 1) * countR(exp, false, i + 1, end)
                } else if (op == '^') {
                    c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
                    c += countR(exp, false, start, i - 1) * countR(exp, false, i + 1, end)
                }
                i += 2
            }
        }
        return c
    }

    fun countDP(exp: String, result: Boolean, start: Int, end: Int, cache: HashMap<String?, Int?>): Int {
        val key = "" + result + start + end
        if (cache.containsKey(key)) {
            return cache[key]!!
        }
        if (start == end) {
            if (exp[start] == '1' && result == true) {
                return 1
            } else if (exp[start] == '0' && result == false) {
                return 1
            }
            return 0
        }
        var count = 0
        if (result) {
            var i = start + 1
            while (i <= end) {
                val op = exp[i]
                if (op == '&') {
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                } else if (op == '|') {
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                } else if (op == '^') {
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                }
                i += 2
            }
        } else {
            var i = start + 1
            while (i <= end) {
                val op = exp[i]
                if (op == '&') {
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                } else if (op == '|') {
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                } else if (op == '^') {
                    count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache)
                    count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache)
                }
                i += 2
            }
        }
        cache[key] = count
        return count
    }

    fun total(n: Int): Int {
        // Function to return (2n) ! / ((n+1)! * n!)

        // To keep the numbers small, we divide by i when possible to do evenly. If not,
        // we store up the remainder and divide when possible.
        var num: Long = 1
        var rem: Long = 1
        for (i in 2..n) {
            num *= (n + i).toLong()
            rem *= i.toLong()
            if (num % rem == 0L) {
                num /= rem
                rem = 1
            }
        }
        return num.toInt()
    }

    fun countDPEff(exp: String, result: Boolean, start: Int, end: Int, cache: HashMap<String?, Int?>): Int {
        val key = "" + start + end
        var count = 0
        if (!cache.containsKey(key)) {
            if (start == end) {
                count = if (exp[start] == '1') {
                    1
                } else {
                    0
                }
            }
            var i = start + 1
            while (i <= end) {
                val op = exp[i]
                if (op == '&') {
                    count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache)
                } else if (op == '|') {
                    val left_ops = (i - 1 - start) / 2 // parens on left
                    val right_ops = (end - i - 1) / 2 // parens on right
                    val total_ways = total(left_ops) * total(right_ops)
                    val total_false = countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache)
                    count += total_ways - total_false
                } else if (op == '^') {
                    count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache)
                    count += countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache)
                }
                i += 2
            }
            cache[key] = count
        } else {
            count = cache[key]!!
        }
        return if (result) {
            count
        } else {
            val num_ops = (end - start) / 2
            total(num_ops) - count
        }
    }

    enum class Term {
        True, False, And, Or, Xor, LeftParen, RightParen
    }
}

object Tester {
    fun allEqual(map: HashMap<String?, Int>): Boolean {
        var `val` = 0
        for ((_, value) in map) {
            if (`val` != 0 && `val` != value) {
                return false
            }
            `val` = value
        }
        return true
    }

    val randomOperator: Char
        get() {
            val rand = Random()
            val r = rand.nextInt(3)
            val ops = charArrayOf('^', '&', '|')
            return ops[r]
        }
    val randomExpression: String
        get() {
            val rand = Random()
            val len = rand.nextInt(10) * 2 + 1
            var s = ""
            for (i in 0 until len) {
                var next = '1'
                next = if (i % 2 == 0) {
                    if (rand.nextBoolean()) '1' else '0'
                } else {
                    randomOperator
                }
                s += next
            }
            return s
        }

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0..49) {
            //String terms = "0^0|1&1^1|0|1";
            val terms = randomExpression
            val result = true
            val oBF: Int = Others.bruteForce(terms, java.util.HashMap<String, Boolean>(), result, BooleanArray((terms.length - 1) / 2))
            val oR: Int = Others.countR(terms, result, 0, terms.length - 1)
            val oDP: Int = Others.countDP(terms, result, 0, terms.length - 1, java.util.HashMap<String, Int>())
            val oDPEFF: Int = Others.countDPEff(terms, result, 0, terms.length - 1, java.util.HashMap<String, Int>())
            val a: Int = countEval(terms, result)
            val b: Int = countEval(terms, result)
            val results = java.util.HashMap<String?, Int>()
            results["oBF"] = oBF
            results["oR"] = oR
            results["oDP"] = oDP
            results["oDPEFF"] = oDPEFF
            results["a"] = a
            results["b"] = b
            if (allEqual(results)) {
                println("Success: $terms->$b")
                println(results.toString())
            } else {
                println("Failure: $terms")
                println(results.toString())
                break
            }
        }
    }
}
