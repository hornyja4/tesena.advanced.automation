package tesena.advanced.automation.objects.lotteries.sportka;

import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.LotteryBetPage;

public class SportkaBetPage extends LotteryBetPage {

    public SportkaBetPage(Driver driver) {
        super(driver);
    }

    public SportkaNewBetPage fillNewBet() {
        fillNewBet.click();
        return new SportkaNewBetPage(driver);
    }
}
