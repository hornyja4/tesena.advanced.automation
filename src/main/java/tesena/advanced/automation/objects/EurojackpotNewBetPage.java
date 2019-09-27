package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EurojackpotNewBetPage extends PageObject{

    @AndroidFindBy(xpath = "//*[contains(@text, 'Sloupec')]")
    private MobileElement selectNumbers;

    public EurojackpotNewBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(selectNumbers);
    }

    public EurojackpotBetNumbersSelectPage selectNumbers() {
        selectNumbers.click();
        return new EurojackpotBetNumbersSelectPage(driver);
    }
}
