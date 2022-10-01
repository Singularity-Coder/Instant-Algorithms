import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11, 200, 3, 45, 5, 69, 7};
        findMinElementIn(arr);
    }

    // 1. Define an intial value as min from array
    // Iterate over all array items and check if the current min > found min and it is then reassign the new min
    private static void findMinElementIn(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        System.out.println(min);
    }
}