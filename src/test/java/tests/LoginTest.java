package tests;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.MobileTest;
import tesena.advanced.automation.objects.HomePage;

public class LoginTest extends MobileTest {

    @Test
    public void login() {
        HomePage homePage = new HomePage(driver);
        homePage.clickToLoginButton()
                .login("johny", "123456");
    }

}
