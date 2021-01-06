
/* https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/ */

public static int thirdMax(int[] nums) {
        if (null == nums) return 0;
        if (nums.length == 0) return 0;

        int max3 = 0;
        final HashSet<Integer> uniqList = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            uniqList.add(nums[j]);
        }

        final List<Integer> list = new ArrayList<>(uniqList);
        System.out.println("list: " + list.toString());

        Collections.sort(list);
        System.out.println("sorted list: " + list.toString());

        if (list.size() == 1) max3 = list.get(list.size() - 1);
        if (list.size() == 2) max3 = list.get(list.size() - 1);
        if (list.size() >= 3) max3 = list.get(list.size() - 3);

        System.out.println("max3: " + max3);

        return max3;
    }