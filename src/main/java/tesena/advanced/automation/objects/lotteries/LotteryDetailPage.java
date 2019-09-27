package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class LotteryDetailPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonMakeABet')]")
    protected MobileElement betButton;

    public LotteryDetailPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(betButton);
    }
}
