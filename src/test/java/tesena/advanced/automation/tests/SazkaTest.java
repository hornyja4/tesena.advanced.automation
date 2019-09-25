package tesena.advanced.automation.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SazkaTest {

    @Test
    public void test() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "sazka.apk");
        capabilities.setCapability("appPackage", "cz.sazka.loterie");
        capabilities.setCapability("appActivity", "activity.main.SplashScreenActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mobile");
        try {
            AndroidDriver<MobileElement> androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            androidDriver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
