package utilities.asserts;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static utilities.asserts.SoftAssertManager.getSoftAssert;
import static utilities.asserts.SoftAssertManager.setSoftAssert;

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
    public static void verifyStringContains(String fullText, String text){
        getSoftAssert().assertTrue(fullText.contains(text));
    }
    public static void verifyStringContains(String fullText, String text, String message){
        getSoftAssert().assertTrue(fullText.contains(text),message);
    }
    public static void verifyArrayListsEquals(ArrayList<Object> array1, ArrayList<Object> array2){
        if (!array1.isEmpty() && array1.size() == array2.size()){
            for (int i = 0 ; i< array1.size();){
                if (array2.contains(array1.get(i))){
                    Object objectToDelete = array1.get(i);
                    array1.remove(objectToDelete);
                    array2.remove(objectToDelete);
                }else {
                    i++;
                }
            }if (!array1.isEmpty()){
                Verifications.verifyFail("array1 and array2 not have the same data. the gap between is: array1 = " + array1 + "| array2 = " + array2);
            }
        }else {
            Verifications.verifyFail("array1 and array2 not have the same length: array1 = " + array1.size() + " and array2 = " + array2.size());
        }
    }
    public static void verifyFail(String message){
        getSoftAssert().fail(message);
    }
    public static void verifyAll(){
        //assert and reset verifications
        SoftAssert softAssertToCheck = getSoftAssert();
        setSoftAssert(new SoftAssert());
        softAssertToCheck.assertAll();
    }
}
