// Paint Fill
// Implement the "paint fill" function that one might see on many image editing programs.
// That is, given a screen (represented by a two-dimensional array of colors),
// a point, and a new color, fill in the surrounding area until the color changes
// from the original color.

fun main() {
    val N = 10
    val screen = Array(N) { arrayOfNulls<Color>(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            screen[i][j] = Color.Black
        }
    }
    for (i in 0..99) {
        screen[randomInt(N)][randomInt(N)] = Color.Green
    }
    PrintScreen(screen)
    PaintFill(screen, 2, 2, Color.White)
    println()
    PrintScreen(screen)
}

enum class Color {
    Black, White, Red, Yellow, Green
}

fun PrintColor(c: Color?): String? {
    when (c) {
        Color.Black -> return "B"
        Color.White -> return "W"
        Color.Red -> return "R"
        Color.Yellow -> return "Y"
        Color.Green -> return "G"
    }
    return "X"
}

fun PrintScreen(screen: Array<Array<Color?>>) {
    for (r in screen.indices) {
        for (c in 0 until screen[0].size) {
            print(PrintColor(screen[r][c]))
        }
        println()
    }
}

fun randomInt(n: Int): Int {
    return (Math.random() * n).toInt()
}

fun PaintFill(screen: Array<Array<Color?>>, r: Int, c: Int, ocolor: Color?, ncolor: Color?): Boolean {
    if (r < 0 || r >= screen.size || c < 0 || c >= screen[0].size) {
        return false
    }
    if (screen[r][c] == ocolor) {
        screen[r][c] = ncolor
        PaintFill(screen, r - 1, c, ocolor, ncolor) // up
        PaintFill(screen, r + 1, c, ocolor, ncolor) // down
        PaintFill(screen, r, c - 1, ocolor, ncolor) // left
        PaintFill(screen, r, c + 1, ocolor, ncolor) // right
    }
    return true
}

fun PaintFill(screen: Array<Array<Color?>>, r: Int, c: Int, ncolor: Color): Boolean {
    return if (screen[r][c] == ncolor) false else PaintFill(screen, r, c, screen[r][c], ncolor)
}