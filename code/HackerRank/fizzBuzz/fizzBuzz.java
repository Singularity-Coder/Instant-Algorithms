import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        // Multiple of 3 and 5 meaning if its divisible by 3 and 5
        // Input: n inclusive from 1: 1, 2,...n

        // Output:
        // if element multiple of 3 and 5, print FizzBuzz
        // if element multiple of only 3 and not 5, print Fizz
        // if element multiple of only 5 and not 3, print Buzz
        // If element not multiple of 3 or 5, print itself

        // Expected output for input 15:
        // 1
        // 2
        // Fizz
        // 4
        // Buzz
        // Fizz
        // 7
        // 8
        // Fizz
        // Buzz
        // 11
        // Fizz
        // 13
        // 14
        // FizzBuzz

        if (n < 1 || n > Math.pow(10, 5)) return;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
                continue;
            }
            // Since we are checking for both 5 and 3 above no need to check below again
            if (i % 3 == 0) {
                System.out.println("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                System.out.println("Buzz");
                continue;
            }
            System.out.println(i);
        }
    }
}