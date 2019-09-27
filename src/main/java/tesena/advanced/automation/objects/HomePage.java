package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Eurojackpot']")
    private MobileElement eurojackpotBanner;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(eurojackpotBanner);
    }

    public EurojacpotPage eurojacpot() {
        eurojackpotBanner.click();
        return new EurojacpotPage(driver);
    }
}
