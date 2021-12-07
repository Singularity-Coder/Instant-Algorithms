
// Given an array of integers, calculate the ratios of its elements
// that are positive, negative, and zero. Print the decimal value of
// each fraction on a new line with 6 places after the decimal.

// Note: This challenge introduces precision problems.
// The test cases are scaled to six decimal places,
// though answers with absolute error of up to 10^-4 are acceptable.

// Input:
// Ex: arr = [1, 1, 0, -1, -1]
// There are n = 5 elements, two positive, two negative and one zero.
// Their ratios are 2/5 = 0.400000, 2/5 = 0.400000  and 1/5 = 0.200000. Results are printed as:

// Output:
// 0.400000
// 0.400000
// 0.200000

// Print:
// Print the ratios of positive, negative and zero values in the array.
// Each value should be printed on a separate line with 6 digits after the decimal.
// The function should not return a value.

// Output Format:
// Print the following 3 lines, each to 6 decimals:
// proportion of positive values
// proportion of negative values
// proportion of zeros

// https://java2blog.com/format-double-to-2-decimal-places-java/
// To format a double to x decimal places
// String.format("%.6f", 8.2343434343) formats to 6 decimal places => 8.234343

// System.out.printf("Double upto 6 decimal places: %.6f", 8.2343434343) => 8.234343

// Formatter formatter = new Formatter()
// formatter.format("%.2f", 8.2343434343)
// System.out.println("Double upto 6 decimal places: " + formatter.toString())

// BigDecimal bd = new BigDecimal(8.2343434343).setScale(6, RoundingMode.DOWN)
// System.out.println("Double upto 6 decimal places: " + bd.doubleValue())

// DecimalFormat df = new DecimalFormat("#.######")
// df.setRoundingMode(RoundingMode.DOWN)
// System.out.println("Double upto 6 decimal places with RoundingMode.DOWN: " + df.format(8.2343434343))

// NumberFormat nf = NumberFormat.getInstance()
// nf.setMaximumFractionDigits(6)
// System.out.println("Double d1 upto 6 decimal places: " + nf.format(8.2343434343))

fun main() {
    plusMinus(listOf(-4, 3, -9, 0, 4, 1))
}

fun plusMinus(list: List<Int>) {
    // Constraints
    if (list.size < 0 || list.size > 100) return

    var positives = 0.0
    var negatives = 0.0
    var zeros = 0.0

    list.forEach { it: Int ->
        if (it > 0) positives++
        if (it == 0) zeros++
        if (it < 0) negatives++
    }

    // Format value to 6 decimal places
    println(String.format("%.6f", positives / list.size))
    println(String.format("%.6f", negatives / list.size))
    println(String.format("%.6f", zeros / list.size))
}

