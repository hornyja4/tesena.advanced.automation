package tests;

import org.testng.annotations.Test;
import tesena.advanced.automation.MobileTest;
import tesena.advanced.automation.objects.HomePage;

public class LoginTest extends MobileTest {

    @Test
    public void login() {
        HomePage homePage = new HomePage(driver);
        homePage.clickToLoginButton()
                .login("johnz", "johny");
    }

}
