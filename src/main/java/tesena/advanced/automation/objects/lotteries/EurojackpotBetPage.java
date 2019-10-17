package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'buttonFillBet')]")
    private MobileElement fillNewBetButton;

    public EurojackpotBetPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(fillNewBetButton);
    }

    public EurojackpotNewBetPage fillNewBet() {
        fillNewBetButton.click();
        return new EurojackpotNewBetPage(driver);
    }
}
