package tesena.advanced.automation.objects.lotteries.euro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.LotteryDetailPage;

public class EurojacpotPage extends LotteryDetailPage {

    public EurojacpotPage(Driver driver) {
        super(driver);
    }

    public EurojackpotBetPage bet() {
        betButton.click();
        return new EurojackpotBetPage(driver);
    }
}
