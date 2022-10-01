import java.util.Arrays;

public class Main {

    int[][] arr2d = {
            {1, 4, 7},
            {5, 8, 19},
            {9, 3, 3}
    }

    int[][] arr3d = {
            {
                    {1, 4, 7},
                    {5, 8, 19},
                    {9, 3, 3}
            },
            {
                    {13, 4, 76},
                    {57, 48, 9},
                    {91, 33, 83}
            },
            {
                    {1, 4, 79},
                    {57, 18, 19},
                    {9, 39, 35}
            }
    }

    public static void main(String[] args) {
        doMatrixAddition();
    }

    private static void traverse2DArray() {
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void traverse3DArray() {
        for (int i = 0; i < arr3d.length; i++) {
            for (int j = 0; j < arr3d.length; j++) {
                for (int k = 0; k < arr3d.length; k++) {
                    System.out.println(arr3d[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void doMatrixAddition() {
        // Element in matrix 1 added to element in matrix 2 in their respective positions. Straight forward.
        // 1, 5, 9     2, 3, 1      3, 8, 10
        // 3, 0, 4  +  7, 1, 9  =   10, 1, 13
        int[][] a = {
                {1, 5, 9},
                {3, 0, 4}
        };
        int[][] b = {
                {2, 3, 1},
                {7, 1, 9}
        };

        // Check if both are valid matrices
        for (int k = 0; k + 1 < a.length; k++) {
            if (a[k].length != a[k + 1].length) {
                System.out.println("Invalid a matrix");
                return;
            }
            if (b[k].length != b[k + 1].length) {
                System.out.println("Invalid b matrix");
                return;
            }
        }

        // Creating another matrix to store the sum of two matrices
        int[][] c = new int[2][3];

        // Adding and printing addition of 2 matrices
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void doMatrixSubtraction() {
        // Same as addition. Subtract each element in the respective positon of the first matirx with that of the second matrix and store it in a new matrix
    }

    private static void doMatrixMultiplication() {
        // multiply each element of each row of 1st matrix with each element of the 1st column elements of 2nd matrix to get the fist element result => 1*2 + 5*7 + 9*1 = 46
        // 1, 5, 9     2, 3, 1     46, 62, 91
        // 3, 0, 4  x  7, 1, 9  =  10, 33, 23
        // 6, 3, 8     1, 6, 5     41, 69, 73

        // Creating two matrices
        int[][] a = {
                {1, 5, 9},
                {3, 0, 4},
                {6, 3, 8}
        };
        int[][] b = {
                {2, 3, 1},
                {7, 1, 9},
                {1, 6, 5}
        };

        // Check if both are valid matrices
        for (int k = 0; k + 1 < a.length; k++) {
            if (a[k].length != a[k + 1].length) {
                System.out.println("Invalid a matrix");
                return;
            }
            if (b[k].length != b[k + 1].length) {
                System.out.println("Invalid b matrix");
                return;
            }
        }

        // Creating another matrix to store the multiplication of two matrices
        int[][] c = new int[3][3];  // 3 rows and 3 columns

        // Multiplying and printing multiplication of 2 matrices
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < c.length; k++) {
                    // += because we have to add the elements of the multiplication operation
                    c[i][j] += a[i][k] * b[k][j];
                }   // End of k loop
                System.out.print(c[i][j] + " ");  // Check matrix element
            }   // End of j loop
            System.out.println();
        }
    }

    private static void doMatrixDivision() {
    }
}