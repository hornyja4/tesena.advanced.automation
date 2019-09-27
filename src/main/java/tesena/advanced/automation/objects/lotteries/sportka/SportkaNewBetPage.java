package tesena.advanced.automation.objects.lotteries.sportka;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tesena.advanced.automation.objects.lotteries.LotteryNewBetPage;
import tesena.advanced.automation.objects.lotteries.euro.EurojackpotBetNumbersSelectPage;

public class SportkaNewBetPage extends LotteryNewBetPage {

    public SportkaNewBetPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SportkaBetNumbersSelectPage selectNumbers() {
        selectNumbers.click();
        return new SportkaBetNumbersSelectPage(driver);
    }
}
