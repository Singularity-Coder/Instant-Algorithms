// Robot In A Grid
// Robot in a Grid: Imagine a robot sitting on the upper left corner of grid
// with r rows and c columns. The robot can only move in two directions, right and down,
// but certain cells are "off limits" such that the robot cannot step on them.
// Design an algorithm to find a path for the robot from the top left to the bottom right.

// 1   2   3
// 4   5   6
// 7   8   9

// Robot is at 1
// Robot can only move riht or done. So eiter 2 or 4 to begin with.

fun main() {
    val size = 5
    val maze: Array<BooleanArray> = randomBooleanMatrix(M = size, N = size, percentTrue = 70)
    printMatrix(maze)
    val path = getPath(maze)
    if (path != null) println(path.toString()) else println("No path found.")
}

fun getPath(maze: Array<BooleanArray>?): ArrayList<Point>? {
    if (maze == null || maze.isEmpty()) return null
    val path = ArrayList<Point>()
    return if (getPath(maze, maze.size - 1, maze[0].size - 1, path)) path else null
}

fun getPath(maze: Array<BooleanArray>, row: Int, col: Int, path: ArrayList<Point>): Boolean {
    // If out of bounds or not available, return.
    if (col < 0 || row < 0 || !maze[row][col]) return false
    val isAtOrigin = row == 0 && col == 0

    // If there's a path from the start to my current location, add my location.
    if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
        val p = Point(row, col)
        path.add(p)
        return true
    }
    return false
}

class Point(var row: Int, var column: Int) {
    override fun toString(): String = "($row, $column)"
    override fun hashCode(): Int = this.toString().hashCode()
    override fun equals(o: Any?): Boolean = o is Point && o.row == row && o.column == column
}

fun randomBooleanMatrix(M: Int, N: Int, percentTrue: Int): Array<BooleanArray> {
    val matrix = Array(M) { BooleanArray(N) }
    for (i in 0 until M) {
        for (j in 0 until N) {
            matrix[i][j] = randomBoolean(percentTrue)
        }
    }
    return matrix
}

fun randomBoolean(percentTrue: Int): Boolean = randomIntInRange(1, 100) <= percentTrue

fun randomIntInRange(min: Int, max: Int): Int = randomInt(max + 1 - min) + min

fun randomInt(n: Int): Int = (Math.random() * n).toInt()

fun printMatrix(matrix: Array<BooleanArray>) {
    for (i in matrix.indices) {
        for (j in 0 until matrix[i].size) {
            if (matrix[i][j]) {
                print("1")
            } else {
                print("0")
            }
        }
        println()
    }
}