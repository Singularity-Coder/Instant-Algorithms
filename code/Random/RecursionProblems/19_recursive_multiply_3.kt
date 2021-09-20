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

fun minProductHelper(smaller: Int, bigger: Int): Int {
    if (smaller == 0) return 0 else if (smaller == 1) return bigger
    val s = smaller shr 1
    val halfProd = minProductHelper(s, bigger)
    return if (smaller % 2 == 0) {
        counter++
        halfProd + halfProd
    } else {
        counter += 2
        halfProd + halfProd + bigger
    }
}

fun minProduct(a: Int, b: Int): Int {
    val bigger = if (a < b) b else a
    val smaller = if (a < b) a else b
    return minProductHelper(smaller, bigger)
}