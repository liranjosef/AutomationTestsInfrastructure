package utilities.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitBrowser {

    public static WebDriver driver;

    public static void initBrowser(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                        "\\src\\main\\resources\\chromedriver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                DriverManager.setDriver(driver);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                DriverManager.setDriver(driver);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                DriverManager.setDriver(driver);
                break;
            default:
                System.out.println("Invalid browser was provided: " + browser);
        }

    }
}
