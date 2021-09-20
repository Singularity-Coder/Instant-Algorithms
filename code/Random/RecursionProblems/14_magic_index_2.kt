import java.lang.StringBuilder
import java.util.*

// Magic Index
// A magic index in an array A[ 0...n -1] is defined to be an index such that A[i] = i.
// Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

// FOLLOW UP
// What if the values are not distinct?

fun main() {
    for (i in 0..999) {
        val size: Int = randomIntInRange(5, 20)
        val array = getSortedArray(size)
        val v2 = magicFast(array)
        if (v2 == -1 && magicSlow(array) != -1) {
            val v1 = magicSlow(array)
            println("Incorrect value: index = -1, actual = $v1 $i")
            println(arrayToString(array))
            break
        } else if (v2 > -1 && array[v2] != v2) {
            println("Incorrect values: index= " + v2 + ", value " + array[v2])
            println(arrayToString(array))
            break
        }
    }
}

fun magicSlow(array: IntArray): Int {
    for (i in array.indices) {
        if (array[i] == i) return i
    }
    return -1
}

fun magicFast(array: IntArray, start: Int, end: Int): Int {
    if (end < start) return -1
    val midIndex = (start + end) / 2
    val midValue = array[midIndex]
    if (midValue == midIndex) return midIndex
    /* Search left */
    val leftIndex = Math.min(midIndex - 1, midValue)
    val left = magicFast(array, start, leftIndex)
    if (left >= 0) return left

    /* Search right */
    val rightIndex = Math.max(midIndex + 1, midValue)
    return magicFast(array, rightIndex, end)
}

fun magicFast(array: IntArray): Int {
    return magicFast(array, 0, array.size - 1)
}

/* Creates an array that is sorted */
fun getSortedArray(size: Int): IntArray {
    val array: IntArray = randomArray(size, -1 * size, size)
    Arrays.sort(array)
    return array
}

fun randomInt(n: Int): Int = (Math.random() * n).toInt()

fun randomIntInRange(min: Int, max: Int): Int = randomInt(max + 1 - min) + min

fun arrayToString(array: IntArray?): String? {
    return if (array == null) "" else arrayToString(array, 0, array.size - 1)
}

fun arrayToString(array: IntArray, start: Int, end: Int): String? {
    val sb = StringBuilder()
    for (i in start..end) {
        val v = array[i]
        sb.append("$v, ")
    }
    return sb.toString()
}

fun randomArray(N: Int, min: Int, max: Int): IntArray {
    val array = IntArray(N)
    for (j in 0 until N) {
        array[j] = randomIntInRange(min, max)
    }
    return array
}