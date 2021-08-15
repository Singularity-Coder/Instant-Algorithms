// Top-Down Dynamic Programming

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
    println(calcMemoizedFibonacciRunTime())
}

fun fibonacci(n: Int): Int {
    return memoizedFibonacci(n, IntArray(n + 1))
}

// 0.002 seconds for memoized Fib 43
// 1.801 seconds without memoization for Fib 43
fun memoizedFibonacci(i: Int, memo: IntArray): Int {
    if (i == 0 || i == 1) return i
    if (memo[i] == 0) {
        memo[i] = memoizedFibonacci(i - 1, memo) + memoizedFibonacci(i - 2, memo)
    }
    return memo[i]
}

fun calcMemoizedFibonacciRunTime(): String {
    val start = System.currentTimeMillis()
    fibonacci(43)
    val end = System.currentTimeMillis()
    val time = end - start
    return "${time.toDouble()/1000.0} seconds"
}