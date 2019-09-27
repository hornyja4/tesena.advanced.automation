package tesena.advanced.automation.objects.lotteries.sportka;

import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.LotteryNewBetPage;

public class SportkaNewBetPage extends LotteryNewBetPage {

    public SportkaNewBetPage(Driver driver) {
        super(driver);
    }

    public SportkaBetNumbersSelectPage selectNumbers() {
        selectNumbers.click();
        return new SportkaBetNumbersSelectPage(driver);
    }
}
