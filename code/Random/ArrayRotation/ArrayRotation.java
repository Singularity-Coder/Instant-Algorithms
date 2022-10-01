import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        leftRotate3(arr, 3);
    }

    private static void shiftElementsToLeftOnce(int[] arr) {
        System.out.println(Arrays.toString(arr));

        // In 1 iteration 1 element gets shifted
        // While shifting once left or right, u lost 1 element
        // U can store the lost element in a var and place it anywhere after the iteration
        // U can shift multiple elements by performing multiple iterations
        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            arr[i] = arr[i + 1];
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void shiftElementsToRightOnce(int[] arr) {
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int last = arr[arr.length - 1];
            System.out.println("pos: " + i + " val: " + arr[i]);
            arr[i] = arr[i - 1];
        }

        System.out.println(Arrays.toString(arr));
    }

    // https://www.geeksforgeeks.org/array-rotation/
    // After rotating d positions to the left, the first d elements become the last d elements of the array
    // rotate the array elements to the left by d positions.
    // arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
    // Output: 3 4 5 6 7 1 2
    // Try in-place
    private static void leftRotate1(int[] arr, int rotatePos) {
        // arr:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println("arr:" + Arrays.toString(arr));

        int[] arrWithoutRotatedElemns = new int[arr.length];
        for (int i = rotatePos; i < arr.length; i++) {
            arrWithoutRotatedElemns[i - rotatePos] = arr[i];
        }

        // arrWithoutRotatedElemns:[4, 5, 6, 7, 8, 9, 10, 0, 0, 0]
        System.out.println("arrWithoutRotatedElemns:" + Arrays.toString(arrWithoutRotatedElemns));

        for (int j = 0; j < rotatePos; j++) {
            arrWithoutRotatedElemns[arr.length - rotatePos + j] = arr[j];
        }

        // arrWithoutRotatedElemns:[4, 5, 6, 7, 8, 9, 10, 1, 2, 3]
        System.out.println("arrWithoutRotatedElemns:" + Arrays.toString(arrWithoutRotatedElemns));
    }

    private static void leftRotate2(int[] arr, int rotation) {
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("rotation: " + rotation);

        int[] tempArr = new int[arr.length]; // Store rotated array
        int extPointer = 0; // Extra pointer to keep track of current index of tempArr[]

        // 1. store the unrotated elements in tempArr[]
        for (int i = rotation; i < arr.length; i++) {
            tempArr[extPointer] = arr[i];
            extPointer++;
        }

        System.out.println("tempArr: " + Arrays.toString(tempArr));
        System.out.println("extPointer: " + extPointer);

        // 2. Store the rotated elements at the end since left rotation in tempArr[]
        for (int j = 0; j < rotation; j++) {
            tempArr[extPointer] = arr[j];
            extPointer++;
        }

        System.out.println("tempArr: " + Arrays.toString(tempArr));
        System.out.println("extPointer: " + extPointer);

        // 3. Assign the rotated tempArr to original arr to get rotated array
        for (int k = 0; k < arr.length; k++) {
            arr[k] = tempArr[k];
        }

        System.out.println("arr: " + Arrays.toString(arr));
    }

    // 1. Shift the elements by 1 to the end of the arr from the start
    // 2. Repeat that shifting as many times as the rotation required
    private static void leftRotate3(int[] arr, int rot) {
        System.out.println(Arrays.toString(arr));

        int repeatCount = 1;
        // REPEAT SHIFTING "rot" NUMBER OF TIMES
        while (repeatCount <= rot) {
            int first = arr[0];
            // SHIFT ELEMENTS ONCE TO LEFT
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.println("pos: " + i + " val: " + arr[i]);
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = first;
            repeatCount++;
        }

        System.out.println(Arrays.toString(arr));
    }

    // NOT CLEAR ******************************************************
    // Juggling Algorithm
    // Divide arr into sets equal to GCD(arr.length, rotation). This is done to find the largest individual blocks something can be divided into
    // Rotate each set by 1 position to left
    private static void leftRotate4(int[] arr, int rot) {
        System.out.println(Arrays.toString(arr));

        /* To handle if rot >= n */
        rot = rot % arr.length;

        int i = 0;
        int j = 0;
        int k = 0;
        int temp = 0;

        int gcd = gcd(rot, arr.length);

        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;

            while (true) {
                k = j + rot;
                if (k >= arr.length) {
                    k = k - arr.length;
                }
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }

            arr[j] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    // GCD: Highest common factor.
    // Factor is any number that divides the original evenly without leaving a reminder
    // In this case we are checking if dividend % divisor leaves any remainder. If this does then do the action again else break
    private static int gcd(int dividend, int divisor) {
        // Base case: Break recursion if reminder is 0 else continue
        if (divisor == 0) {
            return dividend;
        } else {
            System.out.println("remainder: " + dividend % divisor);
            return gcd(divisor, dividend % divisor);
        }
    }
}