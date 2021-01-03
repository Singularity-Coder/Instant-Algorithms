
/* https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/ */

public static void moveZeroes(int[] nums) {
        if (null == nums) return;
        if (nums.length == 0) return;

        int zerosCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zerosCount++;
        }

        for (int j = 0; j < zerosCount; j++) {
            for (int k = 0; k + 1 < nums.length; k++) {
                if (nums[k] == 0) {
                    nums[k] = nums[k + 1];
                    nums[k + 1] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }