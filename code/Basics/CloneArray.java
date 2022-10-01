import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        cloneArray();
    }

    // when you clone a 1D array u copy the values. So changing clone does not change the original
    public static void cloneArray() {
        int[] original = {1, 2, 3, 4, 5};
        int[] clone = original.clone(); // This creates new memory references and does not impact the original
        clone[1] = 15;

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(clone));
    }

    // when u clone 2D array u copy the reference. So change made in clone changes original as well
    public static void clone2dArray() {
        int[][] original = {{19}, {25, 26, 2, 28, 29}, {33, 3}};
        System.out.println("Original array: " + Arrays.toString(original));
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                System.out.print(original[i][j] + " ");
            }
        }

        System.out.println();

        int[][] clone = original.clone();
        System.out.println("Clone array: " + Arrays.toString(clone));
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone[i].length; j++) {
                System.out.print(clone[i][j] + " ");
            }
        }

        clone[1][1] = 1020; // Since 2d array clone copys the references, modifying clone will modify the original as well.

        System.out.println();
        System.out.println(Arrays.toString(original[1]));
        System.out.println(Arrays.toString(clone[1]));
    }
}