package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import tesena.advanced.automation.components.EurojackpotBanner;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Eurojackpot']")
    @iOSXCUITFindBy(xpath = "//*[@name='Eurojackpot']")
    private EurojackpotBanner eurojackpotBanner;

    public HomePage(Driver driver) {
        super(driver);
    }

    public EurojackpotPage eurojackpot() {
        eurojackpotBanner.click();
        return new EurojackpotPage(driver);
    }
}
