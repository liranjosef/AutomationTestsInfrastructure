package platforms.web.google;

import base.google.BaseGoogle;
import utilities.web.*;
import static utilities.readFileData.XMLReading.getXMLData;

public class WebInit extends BaseGoogle {

    public static void web_init(){
        platformName = "web";
        System.out.println(platformName);
        browserType = getXMLData(configurationFilePath, "BROWSER_TYPE");
        System.out.println(browserType);
        InitBrowser.initBrowser(browserType);
        DriverManager.getDriver().manage().window().maximize();
        ImplicitWaitManager.setImplicitWait(15);
        ExplicitWaitManager.setExplicitWait(15);
        initClientEnvironmentVariables();
        DriverManager.getDriver().get(fullUrl);

    }

    public static void initClientEnvironmentVariables(){
        if (environment.equalsIgnoreCase("test")){
            environmentBaseUrl = "";
        } else if (environment.equalsIgnoreCase("preProd")) {
            environmentBaseUrl = "";
        } else if (environment.equalsIgnoreCase("prod")) {
            environmentBaseUrl = "";
        }
        fullUrl = environmentBaseUrl + "https://www.google.com/";
    }

}
