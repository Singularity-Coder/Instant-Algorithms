import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        findMedian(Arrays.asList(5, 3, 1, 2, 4));
    }

    public static int findMedian(List<Integer> arr) {
        // Median of a list is middle element after sorting. So left and right side of the midian nums are same size. So its an odd num of elements
        // Input: 5, 3, 1, 2, 4
        // Sorted Input: 1, 2, 3, 4, 5
        // Output: Middle element or Median is 3 which is an int

        // Constraints
        // size of array is odd
        if (arr.size() < 1 || arr.size() > Math.pow(10, 4)) return 0;
        if (arr.size() % 2 == 0) return 0;

        Collections.sort(arr);

        int middleElementIndex = (arr.size() / 2);  // Divding odd num with int takes the ceil of the value. So diving 5/2 gives 3 instead of floor value 2
        return arr.get(middleElementIndex);
    }
}