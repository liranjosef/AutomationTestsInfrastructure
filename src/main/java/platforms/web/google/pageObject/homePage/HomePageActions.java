package platforms.web.google.pageObject.homePage;

import utilities.web.WebActions;

public class HomePageActions {


    public static void doSearch(String pageName){
        WebActions.sendKeys(HomePageLocators.googleSearchBox(),pageName);
        WebActions.clickEnterKeyboard(HomePageLocators.googleSearchBox());
    }
}
