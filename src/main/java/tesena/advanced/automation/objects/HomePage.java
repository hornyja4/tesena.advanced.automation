package tesena.advanced.automation.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.PageObject;
import tesena.advanced.automation.components.LoginButton;

public class HomePage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='cz.sazka.loterie:id/login']")
    private LoginButton loginButton;

    public HomePage(Driver driver) {
        super(driver);
    }

    public LoginPage clickToLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
