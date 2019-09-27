package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class LotteryNewBetPage extends PageObject {

    @AndroidXpath(xpath = "//*[contains(@text, 'Sloupec')]")
    protected Component selectNumbers;

    public LotteryNewBetPage(Driver driver) {
        super(driver);
    }
}
