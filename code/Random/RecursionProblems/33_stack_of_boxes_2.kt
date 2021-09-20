import java.util.*

// Stack of Boxes
// You have a stack of n boxes, with widths wi, heights hi, and depths di.
// The boxes cannot be rotated and can only be stacked on top of one another
// if each box in the stack is strictly larger than the box above it in
// width, height, and depth. Implement a method to compute the height of the
// tallest possible stack. The height of a stack is the sum of the heights of each box.

fun createStack(boxes: ArrayList<Box>): Int {
    Collections.sort(boxes, BoxComparator())
    var maxHeight = 0
    val stackMap = IntArray(boxes.size)
    for (i in boxes.indices) {
        val height = createStack(boxes, i, stackMap)
        maxHeight = Math.max(maxHeight, height)
    }
    return maxHeight
}

fun createStack(boxes: ArrayList<Box>, bottomIndex: Int, stackMap: IntArray): Int {
    if (bottomIndex < boxes.size && stackMap[bottomIndex] > 0) {
        return stackMap[bottomIndex]
    }
    val bottom = boxes[bottomIndex]
    var maxHeight = 0
    for (i in bottomIndex + 1 until boxes.size) {
        if (boxes[i].canBeAbove(bottom)) {
            val height = createStack(boxes, i, stackMap)
            maxHeight = Math.max(height, maxHeight)
        }
    }
    maxHeight += bottom.height
    stackMap[bottomIndex] = maxHeight
    return maxHeight
}

fun main() {
    val boxList = arrayOf(Box(6, 4, 4), Box(8, 6, 2), Box(5, 3, 3), Box(7, 8, 3), Box(4, 2, 2), Box(9, 7, 3))
    val boxes = ArrayList<Box>()
    for (b in boxList) {
        boxes.add(b)
    }
    val height = createStack(boxes)
    println(height)
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
