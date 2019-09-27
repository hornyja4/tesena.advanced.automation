package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class LotteryNewBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@text, 'Sloupec')]")
    protected MobileElement selectNumbers;

    public LotteryNewBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(selectNumbers);
    }
}
