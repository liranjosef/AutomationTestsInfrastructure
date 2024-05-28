package utilities.asserts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTests {

    public static void datesAssert() throws ParseException {
        String date1 = "2024-12-18T12:12:40.111";
        String date2 = "18/12/2024 08:13:30";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date1Parse = sdf1.parse(date1);
        Date date2Parse = sdf2.parse(date2);

        System.out.println(date1Parse.toString());
        System.out.println(date2Parse.toString());

        long duration = date1Parse.getTime() - date2Parse.getTime();
        System.out.println("Duration difference: " + duration/1000/60/60 + " Hours");
    }

    public static void datesAssert(String expectedDate, String responseDate, DateTimeFormatter formatter){

        LocalDateTime expectedTime = LocalDateTime.parse(expectedDate,formatter);
        LocalDateTime responseTime = LocalDateTime.parse(responseDate,formatter);
        Duration duration = Duration.between(responseTime,expectedTime);
        System.out.println("duration = " + duration.getSeconds());
        if (duration.getSeconds() > 1){
            Verifications.verifyFail("gap of " + duration.getSeconds() + " seconds between expectedTime( "+expectedTime+" ) and ResponseTime( "+responseTime+" )");
        }else if (duration.getSeconds() < -1){
            Verifications.verifyFail("gap of " + duration.getSeconds()*-1 + " seconds between expectedTime( "+expectedTime+" ) and ResponseTime( "+responseTime+" )");
        }
    }
}
