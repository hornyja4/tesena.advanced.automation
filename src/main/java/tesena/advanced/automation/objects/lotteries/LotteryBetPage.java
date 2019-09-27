package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class LotteryBetPage extends PageObject {

    @AndroidXpath(xpath = "//*[contains(@resource-id, 'buttonFillBet')]")
    protected Component fillNewBet;

    public LotteryBetPage(Driver driver) {
        super(driver);
    }
}
