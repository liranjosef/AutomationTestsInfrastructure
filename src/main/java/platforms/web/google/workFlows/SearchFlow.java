package platforms.web.google.workFlows;

import platforms.web.google.pageObject.homePage.HomePageActions;
import platforms.web.google.pageObject.searchResultsPage.SearchResultsPageActions;
import platforms.web.google.pageObject.searchResultsPage.SearchResultsPageLocators;

public class SearchFlow {

    public static void doSearchAndEnterTheFirstResult(String pageName){

        HomePageActions.doSearch(pageName);
        SearchResultsPageActions.clickFirstResultLink();
    }
}
