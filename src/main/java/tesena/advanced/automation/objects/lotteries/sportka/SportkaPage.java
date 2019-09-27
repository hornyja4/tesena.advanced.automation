package tesena.advanced.automation.objects.lotteries.sportka;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tesena.advanced.automation.objects.lotteries.LotteryDetailPage;

public class SportkaPage extends LotteryDetailPage {

    public SportkaPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SportkaBetPage bet() {
        betButton.click();
        return new SportkaBetPage(driver);
    }
}
