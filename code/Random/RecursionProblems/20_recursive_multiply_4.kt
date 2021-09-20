// Recursive Multiply
// Write a recursive function to multiply two positive integers without using the
// *operator. You can use addition, subtraction, and bit shifting,
// but you should minimize the number of those operations.

var counter = 0

fun main() {
    for (i in 0..99) {
        for (j in 0..99) {
            val prod1 = minProduct(i, j)
            val prod2 = i * j
            if (prod1 != prod2) {
                println("ERROR: $i * $j = $prod2, not $prod1")
            }
        }
    }
}

/* This is an algorithm called the peasant algorithm.
* https://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication
*/
fun minProduct(a: Int, b: Int): Int {
    var a = a
    var b = b
    if (a < b) return minProduct(b, a)
    var value = 0
    while (a > 0) {
        counter++
        if (a % 10 % 2 == 1) value += b
        a = a shr 1
        b = b shl 1
    }
    return value
}