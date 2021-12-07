import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Given five positive integers, find the minimum and maximum values
// that can be calculated by summing exactly four of the five integers.
// Then print the respective minimum and maximum values
// as a single line of two space-separated long integers.

// Example
// The minimum sum is 1+3+5+7=16 and the maximum sum is 3+5+6+7+9=24. The function prints: 16 24

// Input: 1 2 3 4 5
// Output: 10 14

// Hints: Beware of integer overflow! Use 64-bit Integer.

public class Main {
    public static void main(String[] args) {
        miniMaxSum3(Arrays.asList(1, 2, 3, 4, 5));
    }

    public static void miniMaxSum(List<Integer> arr) {
        // input - list of 5 +ve ints
        // min max values by adding 4 of 5 ints
        // output - 2 longs with a space

        // Constraints: 1 <= arr.get(i) <= 10^4
        for (Integer integer : arr) {
            if (integer < 1 || integer > Math.pow(10, 9)) return;
        }

        final ArrayList<Long> fourIntSumList = new ArrayList<>();   // If u use int it will overflow for large additions
        long fourIntSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            fourIntSum = 0; // Reset for every sum value
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) continue;
                fourIntSum += arr.get(j);
            }
            fourIntSumList.add(fourIntSum);
        }

        // Sort sums in ascending order
        Collections.sort(fourIntSumList);
        System.out.println(fourIntSumList.get(0) + " " + fourIntSumList.get(arr.size() - 1));
    }

    public static void miniMaxSum2(List<Integer> arr) {
        long min = arr.get(0);   // t = O(1)
        long max = arr.get(0);   // t = O(1)

        long minSum = 0;    // t = O(1)
        long maxSum = 0;    // t = O(1)

        // Assign min and max values first
        for (Integer num : arr) {
            if (num <= min) min = num;
            if (num >= max) max = num;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);

        // If both min and max are equal then just multiply min or max value times the size of the list
        if (min == max) minSum = maxSum = min * (arr.size() - 1);

        // We have to find max and min sum of values.
        // So if the list doesnt contain the min value then list contains only max values. So calc max sum.
        // Else if the list doesnt contain max value then list contains only min values. So calc min sum.
        for (Integer num2 : arr) {
            if (num2 != max) minSum += num2;
            if (num2 != min) maxSum += num2;
        }

        System.out.println(minSum + " " + maxSum);
    }

    public static void miniMaxSum3(List<Integer> arr) {
        long min = arr.get(0);
        long max = arr.get(0);
        long sum = 0;

        for (Integer num : arr) {
            // Find the sum of all elements first
            sum += num;

            // Find min value
            if (num < min) min = num;

            // Find max value
            if (num > max) max = num;
        }

        // This handles If both min and max are same
        // Min sum is nothing but: total sum - max value
        // Max sum is nothing but: total sum - min value
        System.out.println((sum - max) + " " + (sum - min));
    }

    public static void miniMaxSum4(List<Integer> arr) {
        // Sort elements in ascending order
        Collections.sort(arr);

        long sum = 0L;

        // Get min value from sorted list
        long min = arr.get(0);

        // Get max value from sorted list
        long max = arr.get(arr.size() - 1);

        // Add all elements in list
        for (Integer integer : arr) {
            sum += integer;
        }

        // This handles If both min and max are same
        // Min sum is nothing but: total sum - max value
        // Max sum is nothing but: total sum - min value
        System.out.print((sum - max) + " " + (sum - min));
    }
}