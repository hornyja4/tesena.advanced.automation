package tesena.advanced.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(SazkaTestListener.class)
public class SazkaTest {
    protected AndroidDriver<MobileElement> driver;

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
        //capabilities.setCapability("appPackage", appPackage);
        //capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("app", "C:\\Users\\horny\\Desktop\\SmartDriver\\advanced-automation\\src\\main\\resources\\sazka.apk");
        capabilities.setCapability("appWaitDuration", 50000);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, fullReset);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mobile");
        driver = new AndroidDriver<>(new URL(server), capabilities);
    }

    @AfterClass
    public void terminate() {
        if (driver != null) {
            driver.quit();
        }
    }
}
