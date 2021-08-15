fun main() {
    println(addIteratively(5))
    println(addRecursively(5))
}


// Add numbers from 1 to n recursively & iteratively
// 5 + 4 + 3 + 2 + 1
fun addRecursively(n: Int): Int {
    if (n <= 1) return 1                                    // base case
    return n + addRecursively(n - 1)
}

fun addIteratively(n: Int): Int {
    var result = 0
    repeat(n + 1) { it: Int ->
        result += it
    }
    return result
}