import java.time.Duration
import java.time.Instant

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 * Follow-up: Can you do this in O(N) time and constant space?
 * */

// The qs is not very clear with the wording. I/O helps but still hard to understand until u do it.
// Find max value first
// Find min value
// Iterate from first and last
fun main() {
    println(findMaxSumNonAdjacent3(intArrayOf(5, 1, 1, 5)))
//    println(giveMethodExecTime(method = { findMaxSumNonAdjacent3(intArrayOf(5, 1, 1, 5)) }, timeType = "ms"))
}

// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
// [5, 1, 1, 5]
// Find max first
// Find 2nd max
// If an element at a position is max then the adjacent element is invalidated
// This is a strange way of thinking.
fun findMaxSumNonAdjacent3(arr: IntArray): Int {
    var incl = arr[0]
    var excl = 0
    var exclNew: Int
    var i = 1

    while (i < arr.size) {
        exclNew = if (incl > excl) incl else excl   // current max excluding i
        incl = excl + arr[i]     // current max including i
        excl = exclNew
        i++
    }

    return if (incl > excl) incl else excl  // return max of incl and excl
}

fun findMaxSumNonAdjacent4(arr: IntArray): Int {
    var maxIncl = arr[0]    // choose any random value as max first
    var maxExcl = 0
    var tempMaxExcl = 0

    for (i in 1 until arr.size) {
        tempMaxExcl = if (maxIncl > maxExcl) maxIncl else maxExcl
        maxIncl = maxExcl + arr[i]
        maxExcl = tempMaxExcl
    }

    return if (maxIncl > maxExcl) maxIncl else maxExcl
}

// Wrong Solution
private fun findMaxSumNonAdjacent(arr: IntArray): Int {
    if (arr.isEmpty()) return 0

    var sum = 0
    var i = 0
    while (i < arr.size) {
        sum += arr[i]
        i += 2
    }

    println("Sum: $sum")
    return sum
}

// Wrong Solution
private fun findMaxSumNonAdjacent2(arr: IntArray): Int {
    if (arr.isEmpty()) return 0

    var sum = 0
    for (i in arr.indices step 2) {
        sum += arr[i]
    }

    println("Sum: $sum")
    return sum
}

fun giveMethodExecTime(method: () -> Any, timeType: String = "ns"): String {
    val ONE_SEC_IN_MILLI_SEC = 1E3
    val ONE_SEC_IN_MICRO_SEC = 1E6
    val ONE_SEC_IN_NANO_SEC = 1E9

    val startedAt = System.nanoTime()
    val moment1 = Instant.now()

    method.invoke()

    val endedAt = System.nanoTime()
    val moment2 = Instant.now()

    val duration = Duration.between(moment1, moment2)
    val elapsedTime = endedAt - startedAt

    return when (timeType) {
        "ms" -> (elapsedTime / ONE_SEC_IN_MICRO_SEC).toString().plus(" milli seconds")
        "Ms" -> (elapsedTime / ONE_SEC_IN_MILLI_SEC).toString().plus(" micro seconds")
        "s" -> (elapsedTime / ONE_SEC_IN_NANO_SEC).toString().plus(" seconds")
        else -> elapsedTime.toString().plus(" nano seconds")
    }
}