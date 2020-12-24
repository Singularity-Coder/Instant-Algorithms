
/* https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/ */

public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length != m + n) return;
        if (nums2.length != n) return;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < -Math.pow(10, 9) || nums1[i] > Math.pow(10, 9)) return;
        }

        System.out.println(Arrays.toString(nums1));

        for (int j = m; j < nums1.length; j++) {
            nums1[j] = nums2[j - m];
        }

        System.out.println("Unsorted nums: " + Arrays.toString(nums1));

        Arrays.sort(nums1);

        System.out.println("Sorted nums: " + Arrays.toString(nums1));
    }