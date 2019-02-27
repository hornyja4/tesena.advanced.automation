package tesena.advanced.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static final int TIMEOUT = 20;
    private RemoteWebDriver remoteWebDriver;

    public void waitForElement(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(remoteWebDriver, TIMEOUT);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        try {
            wait.until(input -> expectation.apply(remoteWebDriver));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout exception: Element is not visible after " + TIMEOUT + " seconds.", e);
        }
    }
}
