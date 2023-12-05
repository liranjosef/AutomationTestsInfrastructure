package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class GoogleSearch {

    public static WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();



    @BeforeTest
    public void initTest(){

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Automation\\AutomationTestsInfrastructure\\src\\test\\resources\\reports");
        extent.attachReporter(sparkReporter);

    }

    @Test(priority = 1)
    public void searchEbay() {
        test = extent.createTest("ebay search", "open google and search ebay");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label=\"חיפוש\"]")));
        driver.findElement(By.xpath("//textarea[@aria-label=\"חיפוש\"]")).sendKeys("ebay");
    }

    @Test(priority = 2)
    public void searchSport5() {
        test = extent.createTest("sport5 search", "open google and search sport5");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label=\"חיפוש\"]")));
        driver.findElement(By.xpath("//textarea[@aria-label=\"חיפוש\"]")).sendKeys("sport5");
    }

    @Test(priority = 3)
    public void searchGoogle() {

        test = extent.createTest("google search", "open google and search google");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label=\"חיפוש\"]")));
        driver.findElement(By.xpath("//textarea[@aria-label=\"חיפוש\"]")).sendKeys("google");
    }

    @AfterTest
    public void closeSession(){
        extent.flush();
    }


    @AfterMethod
    public void closeSessio(){
        driver.close();
    }
}
