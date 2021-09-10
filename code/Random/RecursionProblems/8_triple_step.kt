// Triple Step

// A child is running up a staircase with n steps and can hop either
// 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

// Go to nth step in 3 ways
// 1. go to (n - 1)st step and hop 1 step
// 2. go to (n - 2)st step and hop 2 steps
// 3. go to (n - 3)st step and hop 3 steps

// So maybe the way to comeup with a formula recursive formula is by trying to reach the nth step
// runtime is exponential (O(3^n)), since each call branches out to 3 more calls

// How many possible ways? Typically double for loop. ????????????
fun main() {
    val n = 10  // steps
    val ways: Int = countWays(n)
    println(ways)
}

fun countWays(n: Int): Int {
    return when {
        n < 0 -> 0
        n == 0 -> 1
        else -> countWays(n - 1) + countWays(n - 2) + countWays(n - 3)
    }
}

