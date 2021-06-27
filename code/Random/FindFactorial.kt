import java.math.BigInteger

fun main() {
    println(doRecursiveFactorial(12))
    println(doIterativeFactorial(80))
    println(recAdd(5))
    println(recAddRange(5, 10))
    println(recAddRange2(5, 10))
}

// Factorial - 5! = 5 * 4 * 3 * 2 * 1
// Mostly no extra memory (If u r not using big integer), in-place operation
// It must have return value
// It must have a termination condition
// It must call itself

// call 1: 5 * f(5 - 1) = 20
// call 2: 4 * f(4 - 1) = 60
// call 1: 3 * f(3 - 1) = 120
// call 1: 2 * f(2 - 1) = 120
// call 1: 1 * f(1 - 1) = 120 as n != 0 is false and quits the operation
fun doRecursiveFactorial(n: Int): BigInteger {
    val fact = BigInteger.valueOf(n.toLong())
    return if (fact.toString() != "0")  // termination condition
        fact * BigInteger(doRecursiveFactorial(n - 1).toString()) // recursive call
    else BigInteger.ONE
}

fun doIterativeFactorial(n: Int): BigInteger {
    var fact = BigInteger.ONE
    for (i in n downTo 2) fact *= BigInteger.valueOf(n.toLong())
    return fact
}

fun recFact(n: Int): Int = if (n != 0) n * recFact(n - 1) else 1

fun itFact(n: Int): Int {
    if (n > 11) return 0
    var fact = n
    for (i in n downTo 2) fact *= i - 1
    return fact
}

fun recAdd(n: Int): Int {
    if (n <= 1) return 1
    return n + recAdd(n - 1)
}

// start = 5
// end = 10
// 5 + 6 + 7 + 8 + 9 + 10
// start reaching end
fun recAddRange(start: Int, end: Int): Int {
    if (start > end) return 1
    return start + recAddRange(start + 1, end)
}

// start = 5
// end = 10
// 10 + 9 + 8 + 7 + 6 + 5
// end reaching start
fun recAddRange2(start: Int, end: Int): Int {
    if (end < start) return 1
    return recAddRange2(start, end - 1) + end
}