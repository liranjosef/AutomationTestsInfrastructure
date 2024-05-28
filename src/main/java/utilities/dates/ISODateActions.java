package utilities.dates;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ISODateActions {

    public static Date createISODateFromStringISODate(String isoDate){
        return Date.from(Instant.parse(isoDate));
    }

    public static Date minusDaysOnISODate(String isoDate, long daysToDecrease){
        return Date.from(Instant.parse(isoDate).minus(daysToDecrease, ChronoUnit.DAYS));
    }
}
