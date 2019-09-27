package tesena.advanced.automation.objects.lotteries.euro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;
import tesena.advanced.automation.objects.lotteries.LotteryNewBetPage;

public class EurojackpotNewBetPage extends LotteryNewBetPage {

    public EurojackpotNewBetPage(Driver driver) {
        super(driver);
    }

    public EurojackpotBetNumbersSelectPage selectNumbers() {
        selectNumbers.click();
        return new EurojackpotBetNumbersSelectPage(driver);
    }
}
