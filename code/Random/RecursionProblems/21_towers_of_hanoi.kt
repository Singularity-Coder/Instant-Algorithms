import java.util.*

// Towers of Hanoi
// In the classic problem of the Towers of Hanoi, you have 3 towers
// and N disks of different sizes which can slide onto any tower.
// The puzzle starts with disks sorted in ascending order of size from top to bottom
// (i.e., each disk sits on top of an even larger one).You have the following constraints:
// (1) Only one disk can be moved at a time.
// (2) A disk is slid off the top of one tower onto another tower.
// (3) A disk cannot be placed on top of a smaller disk.
// Write a program to move the disks from the first tower to the last using stacks.

fun main() {
    val source = Tower()
    val destination = Tower()
    val buffer = Tower()
    source.name = "s"
    destination.name = "d"
    buffer.name = "b"

    /* Load up tower */
    val numberOfDisks = 5
    for (disk in numberOfDisks - 1 downTo 0) {
        source.add(disk)
    }
    source.print()
    source.moveDisks(numberOfDisks, destination, buffer)
    destination.print()
}

class Tower {
    private val disks = Stack<Int>()
    var name: String? = null
    fun add(d: Int) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            println("Error placing disk $d")
        } else {
            disks.push(d)
        }
    }

    private fun moveTopTo(t: Tower) {
        val top = disks.pop()
        t.add(top)
    }

    fun print() {
        println("Contents of Tower $name: $disks")
    }

    fun moveDisks(quantity: Int, destination: Tower, buffer: Tower) {
        if (quantity <= 0) return
        moveDisks(quantity - 1, buffer, destination)
        println("Move " + disks.peek() + " from " + name + " to " + destination.name)
        moveTopTo(destination)
        buffer.moveDisks(quantity - 1, destination, this)
    }
}