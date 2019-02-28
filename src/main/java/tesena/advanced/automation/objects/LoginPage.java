package tesena.advanced.automation.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.PageObject;
import tesena.advanced.automation.TestLogger;

public class LoginPage extends PageObject {

    @AndroidFindBy(xpath = "")
    private MobileElement username;

    @AndroidFindBy(xpath = "")
    private MobileElement password;

    @AndroidFindBy(xpath = "")
    private MobileElement loginButton;

    public LoginPage(Driver driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(username);
    }

    public HomePage login(String username, String passwprd) {
        logger.info("login()");
        this.username.sendKeys(username);
        this.password.sendKeys(passwprd);
        this.loginButton.click();
        return new HomePage(driver);
    }
}
