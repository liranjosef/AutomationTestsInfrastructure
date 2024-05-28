package platforms.api.booker;


import platforms.api.booker.pojo.Booking;
import platforms.api.booker.pojo.BookingDates;
import utilities.dates.DateFormat;
import utilities.random.RandomDataGenerator;

public class BodyGenerator {

    public static Booking getCreateBookingBodyFromPojo(){
        BookingDates bookingDates = new BookingDates(DateFormat.getDateFormatYYYYMMDD(),DateFormat.getDateFormatYYYYMMDD());
        return new Booking(RandomDataGenerator.getFirstName(),RandomDataGenerator.getLastName(),
                RandomDataGenerator.getRandomNumber(100,1000),RandomDataGenerator.getRandomBoolean(),bookingDates,
                RandomDataGenerator.getRandomAlphabets(10));

    }
}
