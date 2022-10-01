import java.util.Arrays;

// 1. Bubble sort a.k.a Sinking Sort
// 2. Traverse Array from 1st to last element
// 3. Compare current element with next element
// 4. if current element > next element -> swap each other's position
// 5. Step 4 is repeated until whole list is sorted. Ascending or descending depends on condition.
// 6. Very slow algorithm especially for large unsorted lists

// Worst (t) = O(n^2)
// Avg (t) = O(n^2)
// Best (t) = O(n)
// Space (s) = O(1)

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 40, 4030, 55, 6, 5, 5};
        System.out.println("Before Bubble Sort: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Bubble Sort: " + Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
