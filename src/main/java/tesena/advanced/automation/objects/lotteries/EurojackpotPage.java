package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'buttonMakeABet')]")
    private MobileElement betButton;

    public EurojackpotPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(betButton);
    }

    public EurojackpotBetPage bet() {
        betButton.click();
        return new EurojackpotBetPage(driver);
    }
}
