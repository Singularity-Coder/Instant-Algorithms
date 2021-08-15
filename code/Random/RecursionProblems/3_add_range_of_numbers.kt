fun main() {
    println(recAddRange(5, 10))
    println(recAddRange2(5, 10))
}

// start = 5
// end = 10
// 5 + 6 + 7 + 8 + 9 + 10
// start reaching end
fun recAddRange(start: Int, end: Int): Int {
    if (start > end) return 1
    return start + recAddRange(start + 1, end)
}

// start = 5
// end = 10
// 10 + 9 + 8 + 7 + 6 + 5
// end reaching start
fun recAddRange2(start: Int, end: Int): Int {
    if (end < start) return 1
    return recAddRange2(start, end - 1) + end
}