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
    counter++
    return x + y
}

fun minProductHelper(smaller: Int, bigger: Int): Int {
    if (smaller == 0) { // 0 x bigger = 0
        return 0
    } else if (smaller == 1) { // 1 x bigger = bigger
        return bigger
    }

    /* Compute half. If uneven, compute other half. If even, * double it. */
    val s = smaller shr 1 // Divide by 2
    val side1 = minProductHelper(s, bigger)
    var side2 = side1
    if (smaller % 2 == 1) {
        counter++
        side2 = minProductHelper(smaller - s, bigger)
    }
    counter++
    return side1 + side2
}

fun minProduct(a: Int, b: Int): Int {
    val bigger = if (a < b) b else a
    val smaller = if (a < b) a else b
    return minProductHelper(smaller, bigger)
}