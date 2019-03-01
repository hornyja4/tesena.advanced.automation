package tesena.advanced.automation;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;

@Listeners(MobileListener.class)
public class MobileTest {
    protected Driver driver;

    @BeforeClass
    @Parameters({"platform", "automationName", "udid", "version", "server"})
    public void init(@Optional("ANDROID") String platform, @Optional("UIAutomator2") String automationName, @Optional("") String udid,
                     @Optional("") String version, @Optional("http://localhost:4444/wd/hub") String sever) {
        File app = new File("src\\test\\resources\\sazka.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.valueOf(platform));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //capabilities.setCapability("appPackage", "cz.sazka.loterie");
        //capabilities.setCapability("appActivity", ".activity.main.SplashScreenActivity");
        //capabilities.setCapability("appWaitActivity", ".activity.main.SplashScreenActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("server", sever);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei");
        if (!version.isEmpty()) {
            capabilities.setVersion(version);
        }
        if (!udid.isEmpty()) {
            capabilities.setCapability(MobileCapabilityType.UDID, udid);
        }
        driver = new Driver(capabilities);
        String email = "hornych.h@gmail.com";
    }

}
