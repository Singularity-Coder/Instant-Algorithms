import java.util.*

// Stack of Boxes
// You have a stack of n boxes, with widths wi, heights hi, and depths di.
// The boxes cannot be rotated and can only be stacked on top of one another
// if each box in the stack is strictly larger than the box above it in
// width, height, and depth. Implement a method to compute the height of the
// tallest possible stack. The height of a stack is the sum of the heights of each box.

fun main() {
    val boxList = arrayOf(Box(6, 4, 4), Box(8, 6, 2), Box(5, 3, 3), Box(7, 8, 3), Box(4, 2, 2), Box(9, 7, 3))
    val boxes = ArrayList<Box>()
    for (b in boxList) {
        boxes.add(b)
    }
    val height = createStack(boxes)
    println(height)
}

fun createStack(boxes: ArrayList<Box>): Int {
    Collections.sort(boxes, BoxComparator())
    val stackMap = IntArray(boxes.size)
    return createStack(boxes, null, 0, stackMap)
}

fun createStack(boxes: ArrayList<Box>, bottom: Box?, offset: Int, stackMap: IntArray): Int {
    if (offset >= boxes.size) {
        return 0
    }

    /* height with this bottom */
    val newBottom = boxes[offset]
    var heightWithBottom = 0
    if (bottom == null || newBottom.canBeAbove(bottom)) {
        if (stackMap[offset] == 0) {
            stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap)
            stackMap[offset] += newBottom.height
        }
        heightWithBottom = stackMap[offset]
    }

    /* without this bottom */
    val heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap)
    return Math.max(heightWithBottom, heightWithoutBottom)
}

class Box(var width: Int, var height: Int, var depth: Int) {
    fun canBeUnder(b: Box): Boolean {
        return width > b.width && height > b.height && depth > b.depth
    }

    fun canBeAbove(b: Box?): Boolean {
        if (b == null) return true
        return width < b.width && height < b.height && depth < b.depth
    }

    override fun toString(): String {
        return "Box($width,$height,$depth)"
    }
}

class BoxComparator : Comparator<Box> {
    override fun compare(x: Box, y: Box): Int {
        return y.height - x.height
    }
}

object Tester {
    fun createRandomBox(): Box {
        val r = Random()
        return Box(r.nextInt(100), r.nextInt(100), r.nextInt(100))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val boxes1 = ArrayList<Box>()
        val boxes2 = ArrayList<Box>()
        val boxes3 = ArrayList<Box>()
        for (i in 0..199) {
            val b = createRandomBox()
            boxes1.add(b)
            boxes2.add(b)
            boxes3.add(b)
        }
        val height1: Int = createStack(boxes1)
        val height2: Int = createStack(boxes2)
        val height3: Int = createStack(boxes3)
        println("$height1, $height2, $height3")
    }
}
