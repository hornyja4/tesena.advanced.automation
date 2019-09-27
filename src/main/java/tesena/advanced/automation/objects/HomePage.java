package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.objects.lotteries.euro.EurojacpotPage;
import tesena.advanced.automation.objects.lotteries.sportka.SportkaPage;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Eurojackpot']")
    private MobileElement eurojackpotBanner;

    @AndroidFindBy(xpath = "//*[@content-desc='Sportka']")
    private MobileElement sportkaBanner;

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

    public SportkaPage sportka() {
        sportkaBanner.click();
        return new SportkaPage(driver);
    }
}
