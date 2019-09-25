package tesena.advanced.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private AppiumDriver<MobileElement> appiumDriver;

    public void waitForElement(MobileElement element) {
        Wait<WebDriver> wait = new WebDriverWait(appiumDriver, 50);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        wait.until(input -> expectation.apply(appiumDriver));
    }
}
