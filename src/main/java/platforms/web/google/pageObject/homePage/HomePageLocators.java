package platforms.web.google.pageObject.homePage;

import org.openqa.selenium.WebElement;
import utilities.web.WebElementGenerator;

public class HomePageLocators {

    public static WebElement googleSearchBox(){
        return WebElementGenerator.findElementByXpath("//textarea[@title='חיפוש']");
    }
}
