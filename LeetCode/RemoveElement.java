
/* https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/ */

public static int removeElement(int[] nums, int val) {
        if (nums.length < 0 || nums.length > 100) return 0;
        if (val < 0 || val > 100) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > 50) return 0;
        }

        int valsToRemove = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                valsToRemove++;
                nums[j] = 0;
            }
        }

        System.out.println("Unsorted nums: " + Arrays.toString(nums));

        final List<Integer> numsList = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            numsList.add(nums[k]);
        }

        Collections.sort(numsList);
        Collections.reverse(numsList);

        for (int l = 0; l < numsList.size(); l++) {
            nums[l] = numsList.get(l);
        }

        System.out.println("Sorted nums: " + Arrays.toString(nums));

        return nums.length - valsToRemove;
    }