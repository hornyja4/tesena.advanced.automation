package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class LotteryBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonFillBet')]")
    protected MobileElement fillNewBet;

    public LotteryBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(fillNewBet);
    }
}
