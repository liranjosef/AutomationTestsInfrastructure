package utilities.dates;

import lombok.Getter;
import lombok.Setter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter @Setter
public class DateFormat {

    public static Date createISODate(String isoDate){
        return Date.from(Instant.parse(isoDate));
    }

    public static String getDateFormatDDMMYYYYhhmm(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyyHH:mm");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getDateFormatYYYYMMDDThhmmss(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getDateFormatDDMMYYYYhhmmss(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getDateFormatYYYYMMDD(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }












}
