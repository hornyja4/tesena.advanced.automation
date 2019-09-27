package tesena.advanced.automation.objects.lotteries.sportka;

import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.LotteryDetailPage;

public class SportkaPage extends LotteryDetailPage {

    public SportkaPage(Driver driver) {
        super(driver);
    }

    public SportkaBetPage bet() {
        betButton.click();
        return new SportkaBetPage(driver);
    }
}
