
/* https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/ */

public static int[] sortedSquares(int[] nums) {
        if (nums.length > Math.pow(10, 4) || nums.length < 1) return new int[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > Math.pow(10, 4) || nums[i] < -Math.pow(10, 4)) return new int[0];
        }

        int[] sqArr = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            sqArr[j] = (int) Math.pow(nums[j], 2);
        }

        System.out.println("Unsorted nums: " + Arrays.toString(sqArr));

        Arrays.sort(sqArr);

        System.out.println("Sorted nums: " + Arrays.toString(sqArr));

        return sqArr;
    }