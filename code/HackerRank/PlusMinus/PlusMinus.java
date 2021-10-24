import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
    }

    public static void plusMinus(List<Integer> list) {
        int listSize = list.size();
        double positives = 0;
        double negatives = 0;
        double zeros = 0;

        for (Integer integer : list) {
            if (integer > 0) positives++;
            if (integer == 0) zeros++;
            if (integer < 0) negatives++;
        }

        System.out.println(String.format("%.6f", positives/listSize));
        System.out.println(String.format("%.6f", negatives/listSize));
        System.out.println(String.format("%.6f", zeros/listSize));
    }
}