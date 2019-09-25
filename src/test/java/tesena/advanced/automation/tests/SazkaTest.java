package tesena.advanced.automation.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SazkaTest {
    private AndroidDriver<MobileElement> androidDriver;

    @Test
    public void test() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        //capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "");
        //capabilities.setCapability("appPackage", "cz.sazka.loterie");
        //capabilities.setCapability("appActivity", "activity.main.SplashScreenActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mobile");
        try {
            androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            MobileElement eurojackpot = waitForElement("//*[@content-desc='Eurojackpot']");
            eurojackpot.click();
            waitForElement("//*[contains(@resource-id, 'buttonMakeABet')]");
            androidDriver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private MobileElement waitForElement(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(androidDriver, 50);
        ExpectedCondition<MobileElement> expectation = driver -> {
            try {
                assert driver != null;
                return (MobileElement) driver.findElement(By.xpath(xpath));
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return null;
            }
        };
        return wait.until(input -> expectation.apply(androidDriver));
    }
}
