package tesena.advanced.automation.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.PageObject;

public class HomePage extends PageObject {

    @iOSXCUITFindBy(xpath = "//a[]")
    @AndroidFindBy(xpath = "//a[]")
    private MobileElement header;

    @AndroidFindBy(xpath = "//button[@id='login']")
    private MobileElement loginButton;

    public HomePage(Driver driver) {
        super(driver);
    }

    @Override
    public void synchronize() {
        waitForElement(header);
        waitForElement(loginButton);
    }

    public LoginPage clickToLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
