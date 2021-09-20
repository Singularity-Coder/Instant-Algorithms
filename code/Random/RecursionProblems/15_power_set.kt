import java.util.ArrayList

// Power Set
// Write a method to return all subsets of a set.

fun main() {
    val list = ArrayList<Int>()
    for (i in 0..2) list.add(i)
    val subsets = getSubsets(list, 0)
    println(subsets.toString())
}

fun getSubsets(set: ArrayList<Int>, index: Int): ArrayList<ArrayList<Int>> {
    val allSubsets: ArrayList<ArrayList<Int>>
    if (set.size == index) { // Base case - add empty set
        allSubsets = ArrayList()
        allSubsets.add(ArrayList())
    } else {
        allSubsets = getSubsets(set, index + 1)
        val item = set[index]
        val moreSubsets = ArrayList<ArrayList<Int>>()
        for (subset in allSubsets) {
            val newSubset = ArrayList<Int>()
            newSubset.addAll(subset)
            newSubset.add(item)
            moreSubsets.add(newSubset)
        }
        allSubsets.addAll(moreSubsets)
    }
    return allSubsets
}