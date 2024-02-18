package utilities.dates;

import lombok.Getter;
import lombok.Setter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter @Setter
public class DateFormat {

    private static String dateFormatDDMMYYYYhhmm;
    private static String dateFormatYYYYMMDDThhmmss;
    private static String dateFormatDDMMYYYYhhmmss;

    public static String createDateFormatDDMMYYYYhhmm(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyyHH:mm");
        Date date = new Date();
        dateFormatDDMMYYYYhhmm = simpleDateFormat.format(date);
        return dateFormatDDMMYYYYhhmm;
    }

    public static String createDateFormatYYYYMMDDThhmmss(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        dateFormatYYYYMMDDThhmmss = simpleDateFormat.format(date);
        return dateFormatYYYYMMDDThhmmss;
    }

    public static String createDateFormatDDMMYYYYhhmmss(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
        Date date = new Date();
        dateFormatDDMMYYYYhhmmss = simpleDateFormat.format(date);
        return dateFormatDDMMYYYYhhmmss;
    }












}
