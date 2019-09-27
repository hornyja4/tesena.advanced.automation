package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tesena.advanced.automation.factories.POFactory;

public abstract class PageObject {
    protected AppiumDriver<MobileElement> driver;

    public PageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        POFactory.initElements(this, driver);
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(MobileElement mobileElement) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 50);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                assert driver != null;
                return mobileElement.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        wait.until(input -> expectation.apply(driver));
    }
}
