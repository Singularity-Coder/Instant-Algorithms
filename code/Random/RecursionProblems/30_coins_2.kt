// Coins
// Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents),
// and pennies (1 cent), write code to calculate the number of ways of representing n cents.

fun makeChange(n: Int, denoms: IntArray): Int {
    val map = Array(n + 1) { IntArray(denoms.size) }
    return makeChangeHelper(n, denoms, 0, map)
}

fun makeChangeHelper(total: Int, denoms: IntArray, index: Int, map: Array<IntArray>): Int {
    /* Check cache for prior result. */
    if (map[total][index] > 0) { // retrieve value
        return map[total][index]
    }
    val coin = denoms[index]
    if (index == denoms.size - 1) {
        val remaining = total % coin
        return if (remaining == 0) 1 else 0
    }
    var numberOfWays = 0
    /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
    var amount = 0
    while (amount <= total) {
        numberOfWays += makeChangeHelper(total - amount, denoms, index + 1, map) // go to next denom
        amount += coin
    }

    /* Update cache with current result. */map[total][index] = numberOfWays
    return numberOfWays
}

fun main() {
    val denoms = intArrayOf(25, 10, 5, 1)
    val ways = makeChange(10, denoms)
    println(ways)
}

// Check tests for all problems
fun test() {
    for (i in 0..199) {
        val denoms = intArrayOf(25, 10, 5, 1)
        val waysA: Int = makeChange(i, denoms)
        val waysB: Int = makeChange(i, denoms)
        if (waysA != waysB) {
            println("Error: $i : $waysA, $waysB")
        }
    }
}