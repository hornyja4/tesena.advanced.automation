package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotNewBetPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@text, 'Vyberte')]")
    private MobileElement numbers;

    public EurojackpotNewBetPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(numbers);
    }

    public EurojackpotSelectNumbersPage fillTicket() {
        numbers.click();
        return new EurojackpotSelectNumbersPage(driver);
    }
}
