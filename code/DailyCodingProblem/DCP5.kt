
/**
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 *
 * Given this implementation of cons:
 *
 * def cons(a, b):
 * def pair(f):
 * return f(a, b)
 * return pair
 *
 * Implement car and cdr.
 * */

// This is a weird question

fun main() {
    println(car(constructPair(3, 7)))
    println(cdr(constructPair(3, 7)))
}

fun constructPair(val1: Any, val2: Any): Pair<Any, Any> = Pair(first = val1, second = val2)

fun car(pair: Pair<Any, Any>): Any = pair.first
fun cdr(pair: Pair<Any, Any>): Any = pair.second