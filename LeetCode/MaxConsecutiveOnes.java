
/* https://leetcode.com/discuss/explore/fun-with-arrays/955585/Max-Consecutive-Ones-in-Java */

public static int findMaxConsecutiveOnes(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 1 || nums[j] < 0) return 0;
        }

        if (nums.length > 10000) return 0;

        int max = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (max > currMax) currMax = max;
                max = 0;
                continue;
            }

            if (nums[i] == 1) max++;
        }
        
        if (max > currMax) currMax = max;
        
        System.out.println("current max: " + currMax);
        System.out.println("max: " + max);
        
        return currMax;
    }
