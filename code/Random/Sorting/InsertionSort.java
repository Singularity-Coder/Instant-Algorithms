import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 18, 5, 3, 33, 14, 99, 56};
        System.out.println("Before Insertion Sort: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Insertion Sort: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int nextVal = arr[j];   // adjacent element value
            int origPos = j - 1;  // original index position
            while ((origPos > -1) && (arr[origPos] > nextVal)) {
                arr[origPos + 1] = arr[origPos];
                origPos--;
            }
            arr[origPos + 1] = nextVal;
        }
    }
}
