package utilities.web.timeRange;

import utilities.web.ExplicitWaits;
import utilities.web.WebActions;

import static utilities.web.WebElementGenerator.findElementByXpath;

public class TimePickerProcesses {

    public static void chooseHourMinute(String hh, String mm, String hourTextXpath, String minuteTextXpath, String incrementHourButtonXpath,
                                        String incrementMinuteButtonXpath){

        for (int i = 0; i<24; i++){
            ExplicitWaits.visibilityOf(findElementByXpath(hourTextXpath));
            if (findElementByXpath(hourTextXpath).getText().equals(hh)){
                break;
            }
            ExplicitWaits.visibilityOf(findElementByXpath(incrementHourButtonXpath));
            WebActions.click(findElementByXpath(incrementHourButtonXpath));
        }
        for (int i = 0; i<60; i++){
            ExplicitWaits.visibilityOf(findElementByXpath(minuteTextXpath));
            if (findElementByXpath(minuteTextXpath).getText().equals(mm)){
                break;
            }
            ExplicitWaits.visibilityOf(findElementByXpath(incrementMinuteButtonXpath));
            WebActions.click(findElementByXpath(incrementMinuteButtonXpath));
        }

    }
}
