package tesena.advanced.automation.objects.lotteries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import tesena.advanced.automation.objects.PageObject;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Eurojackpot']")
    @iOSXCUITFindBy(xpath = "//*[@name='Eurojackpot']")
    private MobileElement eurojackpotBanner;

    @AndroidFindBy(xpath = "//*[@content-desc='Sportka']")
    private MobileElement sportkaBanner;

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(eurojackpotBanner);
    }

    public EurojackpotPage eurojackpot() {
        eurojackpotBanner.click();
        return new EurojackpotPage(driver);
    }
}
