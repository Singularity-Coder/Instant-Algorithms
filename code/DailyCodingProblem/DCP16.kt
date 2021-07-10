/**
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 *
 * */

fun main() {
    record(1L)
    record(2L)
    record(3L)
    record(4L)
    record(5L)
    record(6L)
    record(7L)
    record(8L)
    record(9L)
    record(10L)

    println(getLast(3))
}

val orderLogs = ArrayList<Long>()

fun record(orderId: Long) {
    orderLogs.add(orderId)
}

fun getLast(pos: Int): Long {
    if (pos > orderLogs.size || pos < 0) return -1
    return orderLogs[orderLogs.lastIndex - pos]
}