package utilities.asserts;

import org.testng.asserts.SoftAssert;

public class SoftAssertManager {

    private static SoftAssert softAssert = new SoftAssert();


    public static SoftAssert getSoftAssert() {
        return softAssert;
    }

    public static void setSoftAssert(SoftAssert softAssert) {
        SoftAssertManager.softAssert = softAssert;
    }
}
