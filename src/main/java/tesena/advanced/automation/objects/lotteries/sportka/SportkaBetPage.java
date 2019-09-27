package tesena.advanced.automation.objects.lotteries.sportka;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tesena.advanced.automation.objects.PageObject;
import tesena.advanced.automation.objects.lotteries.LotteryBetPage;

public class SportkaBetPage extends LotteryBetPage {

    public SportkaBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SportkaNewBetPage fillNewBet() {
        fillNewBet.click();
        return new SportkaNewBetPage(driver);
    }
}
