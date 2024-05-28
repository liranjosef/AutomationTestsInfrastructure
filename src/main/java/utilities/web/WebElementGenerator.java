package utilities.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.web.DriverManager.getDriver;

public class WebElementGenerator {

    public static WebElement findElementByXpath(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }
    public static List<WebElement> findElementsByXpath(String xpath){
        return getDriver().findElements(By.xpath(xpath));
    }
}

