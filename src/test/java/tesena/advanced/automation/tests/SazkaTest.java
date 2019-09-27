package tesena.advanced.automation.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tesena.advanced.automation.objects.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SazkaTest {
    private AndroidDriver<MobileElement> androidDriver;

    @Test
    public void test() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        //capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\tools\\AdvancedTraining\\sazka.apk");
        capabilities.setCapability("appPackage", "cz.sazka.loterie");
        capabilities.setCapability("appActivity", "activity.main.SplashScreenActivity");
        capabilities.setCapability("appWaitDuration", 50000);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mobile");
        try {
            androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            HomePage homePage = new HomePage(androidDriver);
            homePage.eurojacpot()
                    .bet()
                    .fillNewBet()
                    .selectNumbers()
                    .selectFirstRowNumbers("1", "2", "3", "4", "5");

            androidDriver.quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scrollToElement(String xpath) {
        Dimension dimension = androidDriver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.longPress(PointOption.point((int) (width * 0.5), (int) (height * 0.8)))
                .moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.3)))
                .release()
                .perform();
    }
}
