/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 *  */

// EDGE CASES
// empty input
// bad input
// large input

// Different ways of traversing through data
// Iteration from start to end - constant and variable/dynamic step size
// Iteration from end to start - constant and variable/dynamic step size

// https://stackoverflow.com/questions/46304035/what-is-a-one-pass-algorithm-and-is-mine-one
// One-pass algorithm: is one which reads its input exactly once, in order.
// Each input can only be accessed once, and everything should be processed in order.
// A one-pass algorithm generally requires O(n) (if you have n items, it takes n steps to finish) and less than O(n) storage (since you don't always need to use extra storage, it could be low as O(1)), where n is the size of the input.
// A for loop is a quintessential one-pass algorithm - you look at each value exactly once and move on. A while loop can work too, as long as it only looks at each value exactly once and does not repeat what the for loop looks at

// Unbounded buffering: storing input somewhere else unrestrictedly.

fun main() {
//    twoNumsInListAddUpToGivenValue3(arr = arrayOf(10, 15, 3, 7), k = 17)
    startToEndIterationWithVaryingStepSize()
}

// O(n^2) time and O(1) space
// Comparing each element with every other element in the list. So not a single iteration solution
fun twoNumsInListAddUpToGivenValue(arr: Array<Int>?, k: Int?): Boolean {
    if (arr == null || arr.isEmpty()) return false
    if (k == null || k <= 0) return false

    for (i in 0..arr.size) {
        for (j in 1..arr.size) {
            if (arr[i] + arr[j] == k) {
                println("There is one")
                return true
            }
        }
    }

    return false
}

// One pass algo solution - O(n) time and O(1) space
// You can do it in a single iteration if you traverse from both start and end directions
fun twoNumsInListAddUpToGivenValue3(arr: Array<Int>?, k: Int?): Boolean {
    if (arr == null || arr.isEmpty()) return false
    if (k == null || k <= 0) return false

    for (i in 0..arr.size) {
        if (arr[i] + arr[arr.size - 1] == k) {
            println("There is one")
            return true
        }
    }

    return false
}

// This only works for adjacent items n not items at random places. So not a solution
fun twoNumsInListAddUpToGivenValue2(arr: Array<Int>?, k: Int?): Boolean {
    if (arr == null || arr.isEmpty()) return false
    if (k == null || k <= 0) return false

    for (i in 0..arr.size) {
        if (i + 1 < arr.size && arr[i] + arr[i + 1] == k) {
            println("There is one")
            return true
        }
    }

    return false
}

fun startToEndIteration() {
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    arr.forEach { it: Int ->
        println(it)
    }
}

fun EndToStartIteration() {
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in arr.size - 1 downTo 0) {
        println(arr[i])
    }
}

// Strangely this is not working
fun startToEndIterationWithVaryingStepSize() {
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var step = 1
    for (i in arr.indices step step) {
        if (i < arr.size) step = i + 1
        println("step $step")
        println(arr[i])
    }
}