
/**
 * return a new sorted merged list from K sorted lists, each with size N.
 * Ex: [[10, 15, 30], [12, 15, 20], [17, 20, 32]]
 * Result: [10, 12, 15, 15, 17, 20, 20, 30, 32]
 * */

// find K elements in each of list
// Heaps are great for finding the smallest element.
// If used heaps - O(KN log K) since we remove and append to heap K * N times.


// Tests
// List is []
// list contains empty lists [[], [], []]
// list contains both empty and non-empty lists [[], [1], [1, 2]]
// list contains 1 list with 1 elemnt [[1]]
// list contains list of varying sizes [[1], [1, 3, 5], [1, 10, 20, 30, 40]]

// In how many ways can we solve this - divide-and-conquer strategy, recursive merge
fun main() {
//    flatenAndSortListOfArrays(arrayOf(
//        arrayOf(10, 15, 30),
//        arrayOf(12, 15, 20),
//        arrayOf(17, 20, 32)
//    ))

    eachElemProductOfEveryOther(arrayOf(1, 2, 3, 4, 5))
}

// Brute Force - O(KN log KN), since we have K * N total elements
fun flatenAndSortListOfArrays(arr: Array<Array<Int>>) {
    val flatArray = ArrayList<Int>()
    arr.forEach {
        it.forEach {
            flatArray.add(it)
        }
    }
    flatArray.sort()
    println(flatArray)
}


/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 * */
fun eachElemProductOfEveryOther(arr: Array<Int>) {
    if (arr.isEmpty()) return
    // if all values are 1s or 0s

    var prodAtI = 1
    val newArray = ArrayList<Int>()
    for (i in arr.indices) {
        for (j in arr.indices) {
            if (i == j) continue
            prodAtI *= arr[j]
        }
        newArray.add(prodAtI)
        prodAtI = 1
    }
    println(newArray)
}

// Try recursive