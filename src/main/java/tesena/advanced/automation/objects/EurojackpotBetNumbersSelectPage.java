package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class EurojackpotBetNumbersSelectPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'recyclerPrimaryColumnTip')]")
    private MobileElement firstRow;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'recyclerAuxColumnTip')]")
    private MobileElement secondRow;

    public EurojackpotBetNumbersSelectPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(firstRow);
    }

    public EurojackpotBetNumbersSelectPage selectFirstRowNumbers(String... numbers) {
        if (numbers.length != 5) {
            throw new RuntimeException("Count of bet numbers must be equal to 5");
        }
        for (String number: numbers) {
            firstRow.findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
        return this;
    }

    public EurojackpotBetNumbersSelectPage selectSecondRowNumbers(String... numbers) {
        if (numbers.length != 2) {
            throw new RuntimeException("Count of bet numbers must be equal to 2");
        }
        return this;
    }
}
