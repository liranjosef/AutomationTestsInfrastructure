package utilities.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.storage.ContentClipboard;

import java.util.List;

public class WebActions {

    public static void click(WebElement element){
        ExplicitWaits.visibilityOf(element);
        ExplicitWaits.elementToBeClickable(element);
        element.click();
    }
    public static void doubleClick(WebElement element){
        Actions action = new Actions(DriverManager.getDriver());
        action.doubleClick(element).perform();
    }
    public static void clearText(WebElement element){
        ExplicitWaits.visibilityOf(element);
        element.clear();
    }
    public static void sendKeys(WebElement element, String text){
        ExplicitWaits.visibilityOf(element);
        clearText(element);
        if (!element.getAttribute("value").isEmpty()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        element.sendKeys(text);
    }

    public static void sendKeysAfterClearText(WebElement element, String text){
        ExplicitWaits.visibilityOf(element);
        clearText(element);
        ExplicitWaits.sleepWait(800);
        element.sendKeys(text);

    }
    public static void actionTyping(WebElement element, String text) {
        ExplicitWaits.visibilityOf(element);
        Actions action = new Actions(DriverManager.getDriver());
        action.sendKeys(element, text).perform();
    }
    public static void mouseOver(WebElement element) {
        ExplicitWaits.visibilityOf(element);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).build().perform();
    }
    public static void rightClick(WebElement element) {
        ExplicitWaits.visibilityOf(element);
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(element).build().perform();
    }

    public static void clearAndCopyPastTextToElement(WebElement element, String text){
        clearText(element);
        click(element);
        ContentClipboard.setStringClipboard(text);
        clickCtrlAndVKeyboard();
    }
    public static void copyPastTextToElement(WebElement element, String text){
        click(element);
        ContentClipboard.setStringClipboard(text);
        clickCtrlAndVKeyboard();
    }

    /**מאונך*/
    public static void verticallyScrollingRegularScrollPage(int pixelCount){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,"+pixelCount+")");
    }
    /**מאוזן*/
    public static void horizontallyScrollingRegularScrollPage(int pixelCount){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy("+pixelCount+",0)");
    }

    /**@param numberOfPixels positive number to right side | negative number to left side*/
    public static void scrollLeftOrRight(String scrollCssSelector, String numberOfPixels){
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("document.querySelector(\""+scrollCssSelector+"\").scrollLeft="+numberOfPixels);
    }
    public static void printAllElementsList(List<WebElement> webElementsList){
        for (WebElement element : webElementsList){
            System.out.println(element.getText());
        }
    }

    //Keyboard Actions
    public static void clickEnterKeyboard(WebElement element){
        ExplicitWaits.visibilityOf(element);
        element.sendKeys(Keys.ENTER);
    }
    public static void clickALTAndKKeyboard(){
        Actions action = new Actions(DriverManager.getDriver());
        action.keyDown(Keys.ALT).sendKeys("k").build().perform();
    }
    public static void clickESCKeyboard(){
        Actions action = new Actions(DriverManager.getDriver());
        action.keyDown(Keys.ESCAPE).build().perform();
    }
    public static void clickCtrlAndVKeyboard(){
        Actions action = new Actions(DriverManager.getDriver());
        action.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
    }

    //Navigation Actions
    public static void backNavigation(){
        DriverManager.getDriver().navigate().back();
    }
    public static void forwardNavigation(){
        DriverManager.getDriver().navigate().forward();
    }
    public static void refreshNavigation(){
        DriverManager.getDriver().navigate().refresh();
    }




    //Actions with returns
    public static boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public static boolean isWebElementsListEmpty(List<WebElement> webElementsList){
        return webElementsList.isEmpty();
    }
    public static boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    public static boolean isEachElementIsEnabled(List<WebElement> webElementsList){
        boolean isEnabled = true;
        for (int i = 0 ; i< webElementsList.size() ; i++){
            if(!isElementEnabled(webElementsList.get(i))){
                isEnabled = false;
                System.out.println("element number " + i+1 + " is disabled");
            }
        }
        return isEnabled;
    }
    public static boolean isEachElementIsDisabled(List<WebElement> webElementsList){
        boolean isDisabled = true;
        for (int i = 0 ; i< webElementsList.size() ; i++){
            if(isElementEnabled(webElementsList.get(i))){
                isDisabled = false;
                System.out.println("element number " + i+1 + " is enabled");
            }
        }
        return isDisabled;
    }
    public static boolean isTextAppearsOnAttribute(WebElement element, String attributeName, String text){
        return element.getAttribute(attributeName).contains(text);
    }
    public static boolean isAttributeTextEqualsText(WebElement element, String attributeName, String text){
        return element.getAttribute(attributeName).equals(text);
    }




}
