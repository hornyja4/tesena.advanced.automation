package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class LotteryNumbersSelectPage extends PageObject {

    @AndroidXpath(xpath = "//*[contains(@resource-id, 'ColumnTip') and contains(@resource-id, 'recycler')]")
    private Component firstRow;

    @AndroidXpath(xpath = "//*[contains(@resource-id, 'buttonFinish')]")
    protected Component buttonFinish;

    public LotteryNumbersSelectPage(Driver driver) {
        super(driver);
    }

    public void selectFirstRowNumbers(String... numbers) {
        for (String number : numbers) {
            firstRow.findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
    }
}
