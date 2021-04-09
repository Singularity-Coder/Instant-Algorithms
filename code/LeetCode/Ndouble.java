
/* https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/ */

public static boolean checkIfExist(int[] arr) {
        if (arr.length < 2 || arr.length > 500) return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < -Math.pow(10, 3) || arr[i] > Math.pow(10, 3)) return false;
        }

        Arrays.sort(arr);

        for (int j = 0; j < arr.length; j++) {
            for (int k = 1; k < arr.length; k++) {
                if (j != k && arr[j] == 0 && arr[k] == 0) return true;
                if (arr[j] == arr[k]) continue;
                if (arr[j] == 2 * arr[k]) return true;
            }
        }

        return false;
    }