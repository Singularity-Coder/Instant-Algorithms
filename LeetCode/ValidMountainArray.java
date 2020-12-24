
/* https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/ */

public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr.length > Math.pow(10, 4)) return false;
        if (arr[0] > arr[1]) return false;
        if (arr[arr.length - 2] < arr[arr.length - 1]) return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > Math.pow(10, 4)) return false;
        }

        int upSlope = 0;
        int downSlope = 0;

        for (int j = 0; j + 1 < arr.length; j++) {
            if (arr[j] < arr[j + 1]) upSlope++;
            if (arr[j] > arr[j + 1]) break;
        }

        for (int j = 0; j + 1 < arr.length; j++) {
            if (arr[j] > arr[j + 1]) downSlope++;
        }

        System.out.println("upSlope: " + upSlope);
        System.out.println("downSlope: " + downSlope);
        System.out.println("arr len: " + arr.length);
        System.out.println(upSlope + downSlope == arr.length - 1);

        return upSlope + downSlope == arr.length - 1;
    }