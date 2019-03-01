package tesena.advanced.automation.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.PageObject;
import tesena.advanced.automation.components.Input;
import tesena.advanced.automation.components.LoginButton;

public class LoginPage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'editUsername')]")
    private Input username;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'editPassword')]")
    private Input password;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'buttonLogin')]")
    private LoginButton loginButton;

    public LoginPage(Driver driver) {
        super(driver);
    }

    public HomePage login(String username, String passwprd) {
        this.username.sendKeys(username);
        this.password.sendKeys(passwprd);
        return new HomePage(driver);
    }
}
