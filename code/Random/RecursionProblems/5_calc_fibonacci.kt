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
    println(fibonacci(13))
    println(calcFibonacciRunTime())
}

fun fibonacci(i: Int): Int {
    if (i == 0 || i == 1) return i    // base case
    return fibonacci(i - 1) + fibonacci(i - 2)
}

fun calcFibonacciRunTime(): String {
    val start = System.currentTimeMillis()
    fibonacci(43)
    val end = System.currentTimeMillis()
    val time = end - start
    return "${time.toDouble()/1000.0} seconds"
}

// 0 + 1 = 1
// 1 + 1 = 2
// 1 + 2 = 3
// 2 + 3 = 5
// 5 + 3 = 8
// starting the iteration with 2 cause we have computed 0 and 1 and assigned in the variables fib and preFib
fun iterativeFibonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    var prevFib = 1; var fib = 1
    for (i in 2 until n) {
        val temp = fib
        fib += prevFib
        prevFib = temp
    }
    return fib
}