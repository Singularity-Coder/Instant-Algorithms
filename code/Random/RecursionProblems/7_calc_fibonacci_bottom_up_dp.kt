// Bottom-Up Dynamic Programming

// Calculate the sum of all Fibonacci numbers of a given number (OR) Calculate the nth term of Fibonacci series
// Fibonacci numbers - each num is sum of 2 preceding ones starting from 0 and 1
// 0, 1, 1, 2, 3, 5, 8, 13, 21...
// 0 + 1 = 1
// 1 + 1 = 2
// 1 + 2 = 3
// 2 + 3 = 5
// 3 + 5 = 8
// 5 + 8 = 13
// 8 + 13 = 21
// ...

fun main() {
    println(calcFibonacciBottomUpRunTime())
}

// 2774 ns - really fast
fun fibonacciBottomUp(n: Int): Int {
    if (n == 0 || n == 1) return n

    val memo = IntArray(n)
    memo[0] = 0
    memo[1] = 1
    for (i in 2 until n) {
        memo[i] = memo[i - 1] + memo[i - 2]
    }
    return memo[n - 1] + memo[n - 2]
}

// 1889 ns
fun fibonacciBottomUpOptimised(n: Int): Int {
    if (n == 0) return 0
    var a = 0
    var b = 1
    for (i in 2 until n) {
        val c = a + b
        a = b
        b = c
    }
    return a + b
}

fun calcFibonacciBottomUpRunTime(): String {
    val start = System.nanoTime()
    fibonacciBottomUp(43)
    val end = System.nanoTime()
    val time = end - start
    return "$time ns"
}