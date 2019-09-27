package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.components.LotteryBanner;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.lotteries.euro.EurojacpotPage;
import tesena.advanced.automation.objects.lotteries.sportka.SportkaPage;

public class HomePage extends PageObject {

    @AndroidXpath(xpath = "//*[@content-desc='Eurojackpot']")
    private LotteryBanner eurojackpotBanner;

    @AndroidXpath(xpath = "//*[@content-desc='Sportka']")
    private LotteryBanner sportkaBanner;

    public HomePage(Driver driver) {
        super(driver);
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
