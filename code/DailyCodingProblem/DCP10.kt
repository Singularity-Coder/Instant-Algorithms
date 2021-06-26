import java.util.TimerTask
import java.util.Timer

/**
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 * */

fun main() = scheduleJob2(f = { printMeAfterSomeTime() }, n = 5000)

fun printMeAfterSomeTime() {
    println("Hello World")
}

fun scheduleJob1(f: () -> Unit, n: Int) {
    Thread.sleep(n.toLong())
    f.invoke()
}

fun scheduleJob2(f: () -> Unit, n: Int) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() = f.invoke()
        },
        n.toLong()
    )
}
