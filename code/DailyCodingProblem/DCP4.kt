/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 * */
fun main() {
    lowestPositiveInteger2(arrayOf(3, 4, -1, 1))
}

fun lowestPositiveInteger(arr: Array<Int>):Int {
    arr.sort()
    println(arr.contentToString())
    var lowestPositiveNum = 0
    var firstPositivePos = 0
    for (i in arr.indices) {
        if (arr[i] <= 0) continue
        firstPositivePos = i
        break
    }
    for (i in firstPositivePos..arr.lastIndex) {
        if (arr[i] == i) continue
        lowestPositiveNum = i
        println(lowestPositiveNum)
        break
    }
    return lowestPositiveNum
}

// According to question the non positive integer is occupying the positive integer place
// List size is the set of positive numbers that must exist
fun lowestPositiveInteger2(arr: Array<Int>): Int {
    arr.sort()
    println(arr.contentToString())
    var lowestPositiveNum = 0
    var firstPositivePos = 0
    for (i in arr.indices) {
        if (arr[i] <= 0) continue
        firstPositivePos = i
        break
    }
    for (i in firstPositivePos..arr.lastIndex) {
        if (arr[i] == i) continue
        lowestPositiveNum = i
        println(if (lowestPositiveNum == 0) arr.size else lowestPositiveNum)
        break
    }
    println(if (lowestPositiveNum == 0) arr.size else lowestPositiveNum)
    return if (lowestPositiveNum == 0) arr.size else lowestPositiveNum
}