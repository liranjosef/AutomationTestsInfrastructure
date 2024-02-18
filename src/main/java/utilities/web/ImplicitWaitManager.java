package utilities.web;

import java.time.Duration;

public class ImplicitWaitManager {

    public static int implicitWaitCurrentTime;
    public static void setImplicitWait(int seconds){
        implicitWaitCurrentTime = seconds;
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
