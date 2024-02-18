package utilities.web;

import java.util.ArrayList;

public class TabSwitch {

    public static void switchToAnotherTab(int tabIndex){
        ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(tabIndex));
    }

}
