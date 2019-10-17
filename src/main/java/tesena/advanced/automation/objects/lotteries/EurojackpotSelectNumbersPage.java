package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotSelectNumbersPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'recyclerPrimaryColumnTip')]")
    private MobileElement firstColumns;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonFinish')]")
    private MobileElement finishButton;

    public EurojackpotSelectNumbersPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(firstColumns);
    }

    public EurojackpotSelectNumbersPage selectFirstColumnNumbers(String... numbers) {
        if (numbers.length != 5) {
            throw new RuntimeException("Length of array must be 5.");
        }
        for (String number: numbers) {
            firstColumns.findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
        scrollToElement(finishButton);
        return this;
    }
}
