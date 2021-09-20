import java.lang.StringBuilder
import java.util.ArrayList

// Eight Queens
// Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
// so that none of them share the same row, column, or diagonal.
// In this case, "diagonal" means all diagonals, not just the two that bisect the board.

var GRID_SIZE = 8

fun main() {
    val results = ArrayList<Array<Int>>()
    val columns = arrayOfNulls<Int>(GRID_SIZE)
    clear(columns)
    placeQueens(0, columns, results)
    printBoards(results)
    println(results.size)
}

/* Check if (row1, column1) is a valid spot for a queen by checking if there
	 * is a queen in the same column or diagonal. We don't need to check it for queens
	 * in the same row because the calling placeQueen only attempts to place one queen at
	 * a time. We know this row is empty.
	 */
fun checkValid(columns: Array<Int>, row1: Int, column1: Int): Boolean {
    for (row2 in 0 until row1) {
        val column2 = columns[row2]
        /* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */

        /* Check if rows have a queen in the same column */if (column1 == column2) {
            return false
        }

        /* Check diagonals: if the distance between the columns equals the distance
			 * between the rows, then they’re in the same diagonal. */
        val columnDistance = Math.abs(column2 - column1)
        val rowDistance = row1 - row2 // row1 > row2, so no need to use absolute value
        if (columnDistance == rowDistance) {
            return false
        }
    }
    return true
}

fun placeQueens(row: Int, columns: Array<Int>, results: ArrayList<Array<Int>>) {
    if (row == GRID_SIZE) results.add(columns.clone())  // Found valid placement
    else {
        for (col in 0 until GRID_SIZE) {
            if (checkValid(columns, row, col)) {
                columns[row] = col // Place queen
                placeQueens(row + 1, columns, results)
            }
        }
    }
}

fun clear(columns: Array<Int?>) {
    for (i in 0 until GRID_SIZE) columns[i] = -1
}

fun printBoard(columns: Array<Int>) {
    drawLine()
    for (i in 0 until GRID_SIZE) {
        print("|")
        for (j in 0 until GRID_SIZE) if (columns[i] == j) print("Q|") else print(" |")
        print("\n")
        drawLine()
    }
    println("")
}

private fun drawLine() {
    val line = StringBuilder()
    for (i in 0 until GRID_SIZE * 2 + 1) line.append('-')
    println(line.toString())
}

fun printBoards(boards: ArrayList<Array<Int>>) {
    for (i in boards.indices) {
        val board = boards[i]
        printBoard(board)
    }
}