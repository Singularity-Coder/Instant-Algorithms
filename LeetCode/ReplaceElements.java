
/* https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/ */

public static int[] replaceElements(int[] arr) {
        if (arr.length < 1 || arr.length > Math.pow(10, 4)) return arr;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > Math.pow(10, 5)) return arr;
        }

        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (arr[k] > arr[j]) arr[j] = arr[k];
            }
        }

        for (int l = 0; l + 1 < arr.length; l++) {
            arr[l] = arr[l + 1];
        }

        arr[arr.length - 1] = -1;

        System.out.println(Arrays.toString(arr));

        return arr;
    }