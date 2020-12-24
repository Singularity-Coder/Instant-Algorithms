
/* https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/ */

public static int removeDuplicates(int[] nums) {
        if (nums.length < 0 || nums.length > (3 * Math.pow(10, 4))) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -Math.pow(10, 4) || nums[i] > Math.pow(10, 4)) return 0;
        }

        System.out.println(Arrays.toString(nums));

        int dupsToRemove = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] == nums[j + 1]) {
                dupsToRemove++;
                nums[j] = 0;
            }
        }

        System.out.println("Dups to remove: " + dupsToRemove);
        System.out.println("Unsorted nums: " + Arrays.toString(nums));

        Arrays.sort(nums);

        System.out.println("Sorted nums: " + Arrays.toString(nums));

        if (dupsToRemove == 0) return nums.length - dupsToRemove;

        for (int m = 0; m < nums.length - dupsToRemove; m++) {
            if (nums[m] != 0) continue;
            nums[m] = nums[m + dupsToRemove];
            nums[m + dupsToRemove] = 0;
        }

        System.out.println("Sorted nums: " + Arrays.toString(nums));

        return nums.length - dupsToRemove;
    }