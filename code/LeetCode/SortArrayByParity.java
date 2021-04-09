
/* https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/ */

public static int[] sortArrayByParity(int[] A) {
        if (A.length < 1 || A.length > 5000) return null;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 || A[i] > 5000) return null;
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                evenCount++;
                continue;
            }
            if (A[j] % 2 == 0) evenCount++;
        }

        oddCount = A.length - evenCount;

        for (int k = 0; k < oddCount; k++) {
            for (int l = 0; l + 1 < A.length; l++) {
                if (A[l] == 0) continue;
                if (A[l] % 2 != 0) {
                    int temp = A[l];
                    A[l] = A[l + 1];
                    A[l + 1] = temp;
                }
            }
        }

        System.out.println("evenCount: " + evenCount);
        System.out.println("oddCount: " + oddCount);
        System.out.println(Arrays.toString(A));

        return A;
    }