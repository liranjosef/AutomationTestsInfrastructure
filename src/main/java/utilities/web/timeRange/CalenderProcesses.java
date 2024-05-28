package utilities.web.timeRange;

import org.openqa.selenium.WebElement;
import utilities.dates.DateConvert;
import utilities.web.ExplicitWaits;
import utilities.web.WebActions;

import static utilities.web.WebElementGenerator.findElementByXpath;
import static utilities.web.WebElementGenerator.findElementsByXpath;

public class CalenderProcesses {

    public static void chooseDateFromCalender(int yearInput, int monthInput, int dayInput, String yearPickerButtonXpath, String yearsListXpath,
                                              String monthsListXpath, String daysListXpath, String previousButtonXpath, String nextButtonXpath)
            throws InterruptedException {

        Thread.sleep(1000);
        ExplicitWaits.visibilityOf(findElementByXpath(yearPickerButtonXpath));
        WebActions.click(findElementByXpath(yearPickerButtonXpath));
        WebActions.click(findElementByXpath(yearPickerButtonXpath));
        ExplicitWaits.visibilityOf(findElementByXpath(yearsListXpath));
        int smallestYear = Integer.parseInt(findElementsByXpath(yearsListXpath).get(0).getText());
        int highestYear = Integer.parseInt(findElementsByXpath(yearsListXpath).get(findElementsByXpath(yearsListXpath).size()-1).getText());
        while (yearInput < smallestYear){
            WebActions.click(findElementByXpath(previousButtonXpath));
            ExplicitWaits.visibilityOf(findElementByXpath(yearsListXpath));
            smallestYear = Integer.parseInt(findElementsByXpath(yearsListXpath).get(0).getText());
        }
        while (yearInput > highestYear){
            WebActions.click(findElementByXpath(nextButtonXpath));
            ExplicitWaits.visibilityOf(findElementByXpath(yearsListXpath));
            highestYear = Integer.parseInt(findElementsByXpath(yearsListXpath).get(findElementsByXpath(yearsListXpath).size()-1).getText());
        }
        for (WebElement year : findElementsByXpath(yearsListXpath)){
            int yearInt = Integer.parseInt(year.getText());
            if (yearInt == yearInput){
                WebActions.click(year);
                ExplicitWaits.visibilityOf(findElementByXpath(monthsListXpath));
                for (WebElement month : findElementsByXpath(monthsListXpath)){
                    if (month.getText().trim().contains(DateConvert.convertMonthNumberToText(monthInput))){
                        WebActions.click(month);
                        ExplicitWaits.visibilityOf(findElementByXpath(daysListXpath));
                        for (WebElement day : findElementsByXpath(daysListXpath)){
                            if (Integer.parseInt(day.getText().trim()) == dayInput){
                                WebActions.click(day);
                                return;
                            }
                        }
                    }
                }
            }
        }


    }
}
