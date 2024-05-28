package platforms.web.google.pageObject.searchResultsPage;

import utilities.web.WebActions;

public class SearchResultsPageActions {

    public static void clickFirstResultLink(){

        WebActions.click(SearchResultsPageLocators.firstSearchResultLink());
    }
}
