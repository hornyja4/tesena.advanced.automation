package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.components.Button;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'buttonMakeABet')]")
    private Button betButton;

    public EurojackpotPage(Driver driver) {
        super(driver);
    }

    public EurojackpotBetPage bet() {
        betButton.click();
        return new EurojackpotBetPage(driver);
    }
}
