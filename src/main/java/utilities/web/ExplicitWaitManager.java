package utilities.web;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {

    private static WebDriverWait explicitWait;
    public static int explicitWaitCurrentTime;

    public static WebDriverWait getExplicitWait() {
        return explicitWait;
    }

    public static int getExplicitWaitCurrentTime(){
        return explicitWaitCurrentTime;
    }

    public static void setExplicitWait(int seconds) {
        explicitWaitCurrentTime = seconds;
        explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
    }
}
