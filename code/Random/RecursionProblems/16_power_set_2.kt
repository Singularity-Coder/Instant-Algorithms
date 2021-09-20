import java.util.ArrayList

// Power Set
// Write a method to return all subsets of a set.

fun convertIntToSet(x: Int, set: ArrayList<Int>): ArrayList<Int> {
    val subset = ArrayList<Int>()
    var index = 0
    var k = x
    while (k > 0) {
        if (k and 1 == 1) subset.add(set[index])
        index++
        k = k shr 1
    }
    return subset
}

fun getSubsets(set: ArrayList<Int>): ArrayList<ArrayList<Int>> {
    val allSubsets = ArrayList<ArrayList<Int>>()
    val max = 1 shl set.size /* Compute 2^n */
    for (k in 0 until max) {
        val subset = convertIntToSet(k, set)
        allSubsets.add(subset)
    }
    return allSubsets
}

fun main() {
    val list = ArrayList<Int>()
    for (i in 0..2) list.add(i)
    val subsets2 = getSubsets(list)
    println(subsets2.toString())
}