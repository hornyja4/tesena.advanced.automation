package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import tesena.advanced.automation.components.Button;
import tesena.advanced.automation.components.DrawNumbers;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class EurojackpotSelectNumbersPage extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'recyclerPrimaryColumnTip')]")
    private DrawNumbers firstColumns;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'buttonFinish')]")
    private Button finishButton;

    public EurojackpotSelectNumbersPage(Driver driver) {
        super(driver);
    }

    public EurojackpotSelectNumbersPage selectFirstColumnNumbers(String... numbers) {
        if (numbers.length != 5) {
            throw new RuntimeException("Length of array must be 5.");
        }
        firstColumns.selectFirstColumnNumbers(numbers);
        finishButton.scrollToComponent();
        return this;
    }
}
