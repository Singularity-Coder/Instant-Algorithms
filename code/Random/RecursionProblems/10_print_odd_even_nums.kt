// Indirect recursion example
// https://www.youtube.com/watch?v=t9whckmAEq0

// Write a program to print numbers from 1 to 10 in such a way that when number is odd, add 1 and when number is even, subtract 1.
// Output: 2 1 4 3 6 5 8 7 10 9

var n = 1

fun main() = odd()

fun odd() {
    if (n <= 10) {
        print("${n + 1} ")
        n++
        even()  // immediately jump to next func to solve next subproblem
    }
    return
}

fun even() {
    if (n <= 10) {
        print("${n - 1} ")
        n++
        odd() // immediately jump to next func to solve next subproblem
    }
    return
}

fun iterativePrintNumbers() {
    repeat(times = 10) { it: Int ->
        val num = it + 1
        if (num % 2 == 0) print("${num - 1} ") else print("${num + 1} ")
    }
}


// Print numbers 1 to 10 using indirect recursion

fun main() {
    odd(0)  // 12345678910
}

fun odd(n: Int): Int = if (n < 10) {
    print(n + 1)
    even(n + 1)
} else 0

fun even(n: Int): Int = if (n < 10) {
    print(n + 1)
    odd(n + 1)
} else 0

// Random printing

fun myFunc1(n: Int) {
    if (n == 0) return else print(n)
    return myFunc1(n - 1)
}

fun myFunc3(n: Int) {
    if (n > 0) println(n) else return
    myFunc3(n - 1)
}

fun myFunc5(n: Int) {
    if (n == 0) return
    myFunc5(n / 2)
    print(n % 2)
}

fun myFunc6(n: Int) {
    if (n <= 0) return
    print(n)
    myFunc6(2 * n)
    print(2)
}

// Non-Tail Recursion

fun myFunc2(n: Int) {
    if (n == 0) return
    myFunc2(n - 1)
    print(n)
}

fun myFunc4(n: Int): Int {
    return if (n == 1) 0
    else 1 + myFunc4(n / 2)
}