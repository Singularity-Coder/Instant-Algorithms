import java.util.ArrayList

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

fun getPath(maze: Array<BooleanArray>?): ArrayList<Point>? {
    if (maze == null || maze.isEmpty()) return null
    val path = ArrayList<Point>()
    val failedPoints: HashSet<Point> = HashSet()
    return if (getPath(
            maze = maze,
            row = maze.size - 1,
            col = maze[0].size - 1,
            path = path,
            failedPoints = failedPoints
        )) path else null
}

fun getPath(maze: Array<BooleanArray>, row: Int, col: Int, path: ArrayList<Point>, failedPoints: HashSet<Point>): Boolean {
    /* If out of bounds or not available, return.*/
    if (col < 0 || row < 0 || !maze[row][col]) return false
    val p = Point(row, col)

    /* If we've already visited this cell, return. */
    if (failedPoints.contains(p)) return false
    val isAtOrigin = row == 0 && col == 0

    /* If there's a path from the start to my current location, add my location.*/
    if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
        path.add(p)
        return true
    }
    failedPoints.add(p) // Cache result
    return false
}

fun main() {
    val size = 20
    val maze: Array<BooleanArray> = randomBooleanMatrix(size, size, 60)
    printMatrix(maze)
    val path: ArrayList<Point>? = getPath(maze)
    if (path != null) println(path.toString()) else println("No path found.")
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