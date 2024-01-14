package in.rauf.utils;

public class NumberUtils {

    private NumberUtils() {
    }

    public static Long parse(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
