package tesena.advanced.automation.objects.lotteries.euro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import tesena.advanced.automation.objects.PageObject;
import tesena.advanced.automation.objects.lotteries.LotteryNumbersSelectPage;

public class EurojackpotBetNumbersSelectPage extends LotteryNumbersSelectPage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'recyclerAuxColumnTip')]")
    private MobileElement secondRow;

    public EurojackpotBetNumbersSelectPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public EurojackpotBetNumbersSelectPage selectEuroFirstRowNumbers(String... numbers) {
        if (numbers.length != 5) {
            throw new RuntimeException("Count of bet numbers must be equal to 5");
        }
        super.selectFirstRowNumbers(numbers);
        return this;
    }

    public EurojackpotBetNumbersSelectPage selectSecondRowNumbers(String... numbers) {
        if (numbers.length != 2) {
            throw new RuntimeException("Count of bet numbers must be equal to 2");
        }
        scrollToElement(buttonFinish);
        for (String number: numbers) {
            secondRow.findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
        return this;
    }

    public EurojackpotNewBetPage done() {
        scrollToElement(buttonFinish).click();
        return new EurojackpotNewBetPage(driver);
    }
}
