package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import tesena.advanced.automation.objects.PageObject;

public class LotteryNumbersSelectPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'ColumnTip') and contains(@resource-id, 'recycler')]")
    private MobileElement firstRow;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonFinish')]")
    protected MobileElement buttonFinish;

    public LotteryNumbersSelectPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(firstRow);
    }

    public void selectFirstRowNumbers(String... numbers) {
        for (String number: numbers) {
            firstRow.findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
    }
}
