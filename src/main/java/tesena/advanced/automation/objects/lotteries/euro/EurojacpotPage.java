package tesena.advanced.automation.objects.lotteries.euro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tesena.advanced.automation.objects.lotteries.LotteryDetailPage;

public class EurojacpotPage extends LotteryDetailPage {

    public EurojacpotPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public EurojackpotBetPage bet() {
        betButton.click();
        return new EurojackpotBetPage(driver);
    }
}
