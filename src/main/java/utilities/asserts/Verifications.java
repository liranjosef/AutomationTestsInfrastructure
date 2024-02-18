package utilities.asserts;

import static utilities.asserts.SoftAssertManager.getSoftAssert;

public class Verifications {

    public static void verifyStrings(String actual, String expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyStrings(String actual, String expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyInts(int actual, int expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyInts(int actual, int expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyLongs(long actual, long expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyLongs(long actual, long expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyDoubles(double actual, double expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyDoubles(double actual, double expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyBooleans(boolean actual, boolean expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyBooleans(boolean actual, boolean expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyObjects(Object actual, Object expected, String message){
        getSoftAssert().assertEquals(actual, expected, message);
    }
    public static void verifyObjects(Object actual, Object expected){
        getSoftAssert().assertEquals(actual, expected);
    }
    public static void verifyTrue(boolean results, String message){
        getSoftAssert().assertTrue(results, message);
    }
    public static void verifyTrue(boolean results){
        getSoftAssert().assertTrue(results);
    }
    public static void verifyFalse(boolean results, String message){
        getSoftAssert().assertFalse(results, message);
    }
    public static void verifyFalse(boolean results){
        getSoftAssert().assertFalse(results);
    }
    public static void verifyNotNull(Object results, String message){
        getSoftAssert().assertNotNull(results, message);
    }
    public static void verifyNotNull(Object results){
        getSoftAssert().assertNotNull(results);
    }
    public static void verifyNull(Object results, String message){
        getSoftAssert().assertNull(results, message);
    }
    public static void verifyNull(Object results){
        getSoftAssert().assertNull(results);
    }
    public static void verifyFail(String message){
        getSoftAssert().fail(message);
    }
    public static void verifyAll(String message){
        getSoftAssert().assertAll(message);
    }
}
