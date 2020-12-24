
/* https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/ */

public void duplicateZeros(int[] arr) {
        if (arr.length > 10000 || arr.length < 1) return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 9 || arr[i] < 0) return;
        }

        System.out.println(Arrays.toString(arr));

        final List<Integer> dup0List = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            dup0List.add(arr[j]);
            if (arr[j] == 0) dup0List.add(0);
        }

        System.out.println(dup0List.toString());

        for (int k = 0; k < arr.length; k++) {
            arr[k] = dup0List.get(k);
        }

        System.out.println(Arrays.toString(arr));
    }
