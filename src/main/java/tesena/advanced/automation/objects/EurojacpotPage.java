package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EurojacpotPage extends PageObject{

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonMakeABet')]")
    private MobileElement betButton;

    public EurojacpotPage(AppiumDriver<MobileElement> driver) {
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
