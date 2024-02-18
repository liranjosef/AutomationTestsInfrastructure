package utilities.web;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> dt = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        return dt.get();
    }

    public static void setDriver(WebDriver driver){
        dt.set(driver);
    }
}
