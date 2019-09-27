package tesena.advanced.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Sazka {
    protected AppiumDriver<MobileElement> driver;

    @BeforeClass
    @Parameters({"appPackage", "appActivity", "noReset", "fullReset", "server"})
    public void initDriver(
            @Optional("cz.sazka.loterie") String appPackage,
            @Optional("activity.main.SplashScreenActivity") String appActivity,
            @Optional("true") boolean noReset,
            @Optional("false") boolean fullReset,
            @Optional("http://localhost:4723/wd/hub") String server
    ) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("appWaitDuration", 50000);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, fullReset);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mobile");
        this.driver = new AndroidDriver<>(new URL(server), capabilities);
    }

    @AfterClass
    public void terminate() {
        if (driver != null) {
            driver.quit();
        }
    }
}
