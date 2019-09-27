package tesena.advanced.automation.objects.lotteries.sportka;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.LotteryNumbersSelectPage;
import tesena.advanced.automation.objects.lotteries.euro.EurojackpotNewBetPage;

public class SportkaBetNumbersSelectPage extends LotteryNumbersSelectPage {

    public SportkaBetNumbersSelectPage(Driver driver) {
        super(driver);
    }

    public SportkaBetNumbersSelectPage selectSportkaFirstRowNumbers(String... numbers) {
        if (numbers.length != 6) {
            throw new RuntimeException("Count of bet numbers must be equal to 5");
        }
        super.selectFirstRowNumbers(numbers);
        return this;
    }

    public SportkaNewBetPage done() {
        buttonFinish.scrollDownTo().click();
        return new SportkaNewBetPage(driver);
    }
}
