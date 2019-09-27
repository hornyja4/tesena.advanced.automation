package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EurojackpotBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonFillBet')]")
    private MobileElement fillNewBet;

    public EurojackpotBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(fillNewBet);
    }

    public EurojackpotNewBetPage fillNewBet() {
        fillNewBet.click();
        return new EurojackpotNewBetPage(driver);
    }
}
