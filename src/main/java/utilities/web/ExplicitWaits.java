package utilities.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class ExplicitWaits {

    public static void visibilityOf(WebElement element){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.visibilityOf(element));
    }
    public static void invisibilityOf(WebElement element){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.invisibilityOf(element));
    }
    public static void visibilityAndInvisibility(WebElement element){
        visibilityOf(element);
        invisibilityOf(element);
    }
    public static void visibilityOfAllElements(List<WebElement> elements){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void attributeToBe(WebElement element, String attributeName, String text){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.attributeToBe(element,attributeName,text));
    }
    public static void textToBePresentInElement(WebElement element, String text){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void textNotToBePresentInElement(WebElement element, String text){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.not((ExpectedConditions.textToBePresentInElement(element,text))));
    }
    public static void elementToBeClickable(WebElement element){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void elementToBeNotClickable(WebElement element){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.not((ExpectedConditions.elementToBeClickable(element))));
    }
    public static void urlToBe(String url){
        ExplicitWaitManager.getExplicitWait().until(ExpectedConditions.urlToBe(url));
    }

    public static void sleepWait(long numberOfMilSec){
        try {
            Thread.sleep(numberOfMilSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
