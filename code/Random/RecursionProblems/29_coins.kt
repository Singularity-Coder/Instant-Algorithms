// Coins
// Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents),
// and pennies (1 cent), write code to calculate the number of ways of representing n cents.

fun main() {
    val denoms = intArrayOf(25, 10, 5, 1)
    val ways = makeChange(10, denoms)
    println(ways)
}

fun makeChangeHelper(total: Int, denoms: IntArray, index: Int): Int {
    val coin = denoms[index]
    if (index == denoms.size - 1) { // One denom left, either you can do it or not
        val remaining = total % coin
        return if (remaining == 0) 1 else 0
    }
    var ways = 0
    /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
    var amount = 0
    while (amount <= total) {
        ways += makeChangeHelper(total - amount, denoms, index + 1) // go to next denom
        amount += coin
    }
    return ways
}

fun makeChange(amount: Int, denoms: IntArray): Int {
    return makeChangeHelper(amount, denoms, 0)
}