// Recursive Multiply
// Write a recursive function to multiply two positive integers without using the
// *operator. You can use addition, subtraction, and bit shifting,
// but you should minimize the number of those operations.

var counter = 0

fun main() {
    val a = 13494
    val b = 22323
    val product = a * b
    val minProduct = minProduct(a, b)
    if (product == minProduct) {
        println("Success: $a * $b = $product")
    } else {
        println("Failure: $a * $b = $product instead of $minProduct")
    }
    println("Adds: $counter")
}


fun sum(x: Int, y: Int): Int {
    counter += 1
    return x + y
}

fun minProduct(smaller: Int, bigger: Int, memo: IntArray): Int {// Compute half

    /* Sum and cache.*/
    // Divide by 2
    when {
        smaller == 0 -> return 0
        smaller == 1 -> return bigger
        memo[smaller] > 0 -> return memo[smaller]
        else -> {
            /* Compute half. If uneven, compute other half. If even, * double it. */
            val s = smaller shr 1 // Divide by 2
            val side1 = minProduct(s, bigger, memo) // Compute half
            var side2 = side1
            if (smaller % 2 == 1) {
                counter++
                side2 = minProduct(smaller - s, bigger, memo)
            }

            /* Sum and cache.*/counter++
            memo[smaller] = side1 + side2
            return memo[smaller]
        }
    }

}

fun minProduct(a: Int, b: Int): Int {
    val bigger = if (a < b) b else a
    val smaller = if (a < b) a else b
    val memo = IntArray(sum(smaller, 1))
    return minProduct(smaller, bigger, memo)
}