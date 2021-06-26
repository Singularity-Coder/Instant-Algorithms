import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 *
 * */

fun main() {
    autoComplete(query = "de", dataSet = arrayOf("dog", "deer", "deal"))
}

fun autoComplete(query: String, dataSet: Array<String>): Array<String> {
    if (dataSet.isEmpty()) return emptyArray()
    val list = ArrayList<String>()
    for (str in dataSet) {
        if (str.length < 2) continue
        if (str.subSequence(0, 2) == query) list.add(str)
    }
    println(list.toTypedArray().contentToString())
    return list.toTypedArray()
}