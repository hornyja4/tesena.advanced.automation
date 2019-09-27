package tesena.advanced.automation.objects.lotteries.euro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.PageObject;
import tesena.advanced.automation.objects.lotteries.LotteryBetPage;

public class EurojackpotBetPage extends LotteryBetPage {

    public EurojackpotBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public EurojackpotNewBetPage fillNewBet() {
        fillNewBet.click();
        return new EurojackpotNewBetPage(driver);
    }
}
