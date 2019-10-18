package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.components.Button;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'buttonFillBet')]")
    private Button fillNewBetButton;

    public EurojackpotBetPage(Driver driver) {
        super(driver);
    }

    public EurojackpotNewBetPage fillNewBet() {
        fillNewBetButton.click();
        return new EurojackpotNewBetPage(driver);
    }
}
