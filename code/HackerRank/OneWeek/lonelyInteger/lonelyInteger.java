import java.util.*;

public class Main {

    // Given an array of integers, where all elements but one occur twice, find the unique element.
    // a = [1, 2, 3, 4, 3, 2, 1]
    // The unique element is 4.

    public static void main(String[] args) {
        lonelyInteger2(Arrays.asList(34, 95, 34, 64, 45, 95, 16, 80, 80, 75, 3, 25, 75, 25, 31, 3, 64, 16, 31));
    }

    // Not Correct
    public static int lonelyInteger(List<Integer> a) {
        // Input: array of ints. Except 1 random element, all other elems occur twice in the array
        // [1, 2, 3, 4, 3, 2, 1] so the element that doesnt occur twice is 4
        // Output: Int

        // Edge Cases:
        // If all elements are same - u can use a hashset and determine if only 1 element exists
        // If there is only 1 element in the list

        // Size of the list will always be odd
        if (a.size() < 1 || a.size() > 100) return 0;
        for (Integer element : a) {
            if (element < 0 || element > 100) return 0;
        }

        if (a.size() == 1) return a.get(0);

        final HashSet<Integer> uniques = new HashSet<>(a);
        System.out.println(uniques);

        // If list size is 1
        if (uniques.size() == 1) return a.get(0);

        Collections.sort(a);
        System.out.println(a);
        int result = 0;

        for (int j = 0; j < a.size(); j += 2) {
            if (j + 1 >= a.size()) break;
            if (!a.get(j).equals(a.get(j + 1))) {
                result = a.get(j);
                break;
            }
        }

        System.out.println(result);
        return result;
    }

    // Can u do it without extra list?
    public static int lonelyInteger2(List<Integer> a) {

        // Constraints
        if (a.size() < 1 || a.size() > 100) return 0;
        for (Integer element : a) {
            if (element < 0 || element > 100) return 0;
        }

        // If list size is 1
        if (a.size() == 1) return a.get(0);

        // Sort in ascending order
        Collections.sort(a);
        System.out.println(a);
        System.out.println(a.size());

        int result = 0;
        final ArrayList<Integer> resultList = new ArrayList<>(a);
        for (int j = 0; j < a.size(); j++) {
            if (j + 1 >= a.size()) break;
            if (a.get(j).equals(a.get(j + 1))) {
                // Remove all elements that have duplicates until the unique one is left
                resultList.remove(a.get(j));
                resultList.remove(a.get(j + 1));
            }
        }

        if (resultList.size() != 0) result = resultList.get(0);

        System.out.println(resultList);
        System.out.println(result);

        return result;
    }

    // Math based solution
    public static int lonelyInteger3(List<Integer> a) {

        // Find sum of all elements
        int sumOfAllElements = 0;
        for (Integer value : a) {
            sumOfAllElements += value;
        }

        // Find sum of all unique elements
        final HashSet<Integer> uniques = new HashSet<>(a);
        final ArrayList<Integer> uniquesList = new ArrayList<>(uniques);
        int sumOfUniques = 0;
        for (int k = 0; k < uniques.size(); k++) {
            sumOfUniques += uniquesList.get(k);
        }

        // Multiplying unique elements time 2 gives the
        // Summing all elements of is just like element times 2 since its given in the problem stat
        System.out.println((sumOfUniques * 2) - sumOfAllElements);

        return (sumOfUniques * 2) - sumOfAllElements;
    }

    // Using Bit manipulation. Constraints: "It is guaranteed that n is an odd number and that there is one unique element."
    public static int lonelyInteger4(List<Integer> a) {
        int result = 0;

        for (int value : a) {
            result ^= value;
        }

        System.out.println(result);

        return result;
    }
}