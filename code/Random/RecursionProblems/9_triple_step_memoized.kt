import java.util.*

// Triple Step Memoized

// A child is running up a staircase with n steps and can hop either
// 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

// Go to nth step in 3 ways
// 1. go to (n - 1)st step and hop 1 step
// 2. go to (n - 2)st step and hop 2 steps
// 3. go to (n - 3)st step and hop 3 steps

// So maybe the way to comeup with a recursive formula is by trying to reach the nth step
// runtime is exponential (O(3^n)), since each call branches out to 3 more calls
// A cache in DP is typically a hashmap something like HashMap<Integer, Integer>

// How many possible ways? Typically double for loop. ????????????
// Overflowing a particular type - Ex: Int can only handle 32 digits in Java n Kotlin. Use BigInteger or BigDecimal to solve this issue.

fun main() {
    val n = 10  // steps
    val ways: Int = countWays(n)
    println(ways)   // 274 ways of going up stairs
}

fun countWays(n: Int): Int {
    val map = IntArray(n + 1)
    Arrays.fill(map, -1)
    return countWays(n, map)
}

// If you see new value cache it or return the value from cache instead of computing it
fun countWays(n: Int, memo: IntArray): Int {
    return when {
        n < 0 -> 0
        n == 0 -> 1
        memo[n] > -1 -> memo[n]
        else -> {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo)  // store the computed value in the memo. So the value is stored in the return trip and not as we call the function.
            memo[n] // returning the value form the memo instead of directly
        }
    }
}

