package google;

import base.google.BaseGoogle;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.web.DriverManager;
import java.util.Objects;
import static platforms.sql.SQLInit.closeDBConnection;
import static utilities.readFileData.XMLReading.getXMLData;

public class BaseGoogleTest extends BaseGoogle {

    @BeforeMethod
    public void setupSession(){

        environment = getXMLData(configurationFilePath, "ENVIRONMENT");
        System.out.println("environment = " + environment);
    }

    @AfterMethod
    public void closeSession(){
        if (platformName == null){
            System.out.println("no platform choose - null");
        } else if (Objects.equals(platformName,"web")) {
            DriverManager.getDriver().quit();
        } else if (Objects.equals(platformName, "sql")) {
            closeDBConnection();
        }
    }
}
