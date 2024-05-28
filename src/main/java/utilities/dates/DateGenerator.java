package utilities.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
