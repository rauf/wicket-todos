package in.rauf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    private DateUtils() {
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }
}
