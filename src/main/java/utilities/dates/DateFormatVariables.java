package utilities.dates;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatVariables {

    public static DateTimeFormatter MMMdyyyyHHmmss(){
        return DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss", Locale.ENGLISH);
    }
    public static DateTimeFormatter yyyyMMDDThhmmss(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    }
}
