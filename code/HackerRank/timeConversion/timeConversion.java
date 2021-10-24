import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    // Input: 09:45:00PM
    // Output: 21:45:00
    // If AM then return same string else do the conversion

    // Edge cases:
    // 12:01:00PM = 12:01:00, Afternoon
    // 12:01:00AM = 00:01:00, Morning

    public static void main(String[] args) {
        timeConversion2("12:01:00PM");
    }

    public static String timeConversion(String s) {
        final String[] timeArray = s.split(":");
        final String hours = timeArray[0];
        final String minutes = timeArray[1];
        final String seconds = timeArray[2].substring(0, 2);
        final Boolean isAM = timeArray[2].endsWith("AM");
        final Integer remainingHrs = 12 + Integer.parseInt(hours);
        final String result = remainingHrs + ":" + minutes + ":" + seconds;
        System.out.println(Arrays.toString(timeArray));
        System.out.println(isAM);
        System.out.println(result);
        if (isAM) return s.replace("AM", "");   // If AM then trim AM from input and return it
        else return result; // else return the 24 hr format converted result
    }

    public static String timeConversion2(String s) {
        final String hours = s.substring(0, 2);
        final boolean isAM = s.endsWith("AM");
        final int convertedHrs = 12 + Integer.parseInt(hours);

        System.out.println(hours);
        System.out.println(isAM);

        if (isAM) {
            // Edge Case
            if (hours.startsWith("12")) {
                System.out.println(s.replaceFirst("12", "00").replace("AM", ""));
                return s.replaceFirst("12", "00").replace("AM", "");
            }
            System.out.println(s.replace("AM", ""));
            return s.replace("AM", "");   // If AM then trim AM from input and return it
        } else {
            // Edge Case
            if (hours.startsWith("12")) {
                System.out.println(s.replace("PM", ""));
                return s.replace("PM", "");
            }
            System.out.println(s.replaceFirst(hours, Integer.toString(convertedHrs)).replace("PM", ""));
            return s.replaceFirst(hours, Integer.toString(convertedHrs)).replace("PM", ""); // else return the 24 hr format converted result
        }
    }

    public static String timeConversion3(String s) {
        Integer hour = Integer.valueOf(s.substring(0, 2));
        String converted = "";
        char t = s.charAt(8);

        if (t == 'P' && hour != 12) {
            hour += 12;
            return converted = hour.toString() + s.substring(2, 8);
        } else if (t == 'A' && hour == 12) {
            return converted = "00" + s.substring(2, 8);
        } else return converted = s.substring(0, 8);
    }

    public static String timeConversion4(String s) {
        final DateFormat twelveHrFormat = new SimpleDateFormat("hh:mm:ssa");
        final DateFormat twentyFourHrFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return twentyFourHrFormat.format(twelveHrFormat.parse(s));
        } catch (ParseException e) {
            return s;
        }
    }
}