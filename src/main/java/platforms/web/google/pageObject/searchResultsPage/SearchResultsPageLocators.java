package platforms.web.google.pageObject.searchResultsPage;

import org.openqa.selenium.WebElement;
import utilities.web.WebElementGenerator;

public class SearchResultsPageLocators {

    public static WebElement firstSearchResultLink(){
        return WebElementGenerator.findElementByXpath("((//div[@class='MjjYud'])[1]//a)[1]");
    }
}
