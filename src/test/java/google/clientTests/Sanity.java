package google.clientTests;

import org.testng.annotations.Test;
import platforms.web.google.workFlows.SearchFlow;
import google.BaseGoogleTest;
import utilities.web.ExplicitWaits;

import static platforms.web.google.WebInit.web_init;

public class Sanity extends BaseGoogleTest {

    @Test
    public void searchTest(){
        web_init();
        SearchFlow.doSearchAndEnterTheFirstResult("sport5");
        ExplicitWaits.sleepWait(5000);
    }
}
