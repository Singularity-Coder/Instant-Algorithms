import java.util.Arrays;
import java.util.List;

// Given a square matrix, calculate the absolute difference between the sums of its diagonals.

// Square Matrix
// 1 2 3
// 4 5 6
// 9 8 9

// left to right diagonal 1 + 5 + 9 = 15
// right to left diagonal 3 + 5 + 9 = 17
// Their absolute difference = | 15 - 17 | = | - 2 | = 2


// Absolute value of say -x is nothing but |-x| = x which is always positive.
// Absolute difference btw 5 and 7 is nothing but |5 - 7| = |-2| = 2
public class Main {

    public static void main(String[] args) {
        diagonalDifference(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(9, 8, 9)
                )
        );
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        // Edge Cases
        // If 0 elements
        // If 1 element
        // If all elements same
        if (arr.size() == 0) return 0;

        // Constraints
        for (List<Integer> i : arr) {
            for (Integer j : i) {
                if (j <= -100 || j >= 100) return 0;
            }
        }

        int sumLeftRightDiagonal = 0;
        int sumRightLeftDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.size() - (i + 1)) < 0) break;
            sumLeftRightDiagonal += arr.get(i).get(i);
            sumRightLeftDiagonal += arr.get(i).get(arr.size() - (i + 1));   // get first array's last element
        }

        System.out.println(sumLeftRightDiagonal);
        System.out.println(sumRightLeftDiagonal);

        int result = Math.abs(sumLeftRightDiagonal - sumRightLeftDiagonal);
        System.out.println(result);

        return result;
    }
}