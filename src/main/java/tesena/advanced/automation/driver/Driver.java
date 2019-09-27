package tesena.advanced.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private AppiumDriver<WebElement> driver;

    public Driver(DesiredCapabilities capabilities, String server) {
        init(capabilities, server);
    }

    private void init(DesiredCapabilities capabilities, String server) {
        URL serverURL;
        try {
            serverURL = new URL(server);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Server url '" + server + "' has wrong format." + e.getLocalizedMessage());
        }
        switch (capabilities.getPlatform()) {
            case ANDROID:
                this.driver = new AndroidDriver<>(serverURL, capabilities);
                break;
            case IOS:
                this.driver = new IOSDriver<>(serverURL, capabilities);
                break;
            default:
                throw new RuntimeException("Platform '" + capabilities.getPlatform() + "' is not supported.");
        }
    }

    public WebElement findElement(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 50);
        ExpectedCondition<WebElement> expectation = driver -> {
            try {
                assert driver != null;
                return driver.findElements(By.xpath(xpath))
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .get();
            } catch (NoSuchElementException | StaleElementReferenceException | java.util.NoSuchElementException e) {
                return null;
            }
        };
        return wait.until(input -> expectation.apply(driver));
    }

    public void scrollToElement(String xpath) {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        TouchAction touchAction = new TouchAction(driver);

        int counter = 0;
        while (!isDisplayed(xpath) && counter++ < 5) {
            touchAction.longPress(PointOption.point((int) (width * 0.5), (int) (height * 0.8)))
                    .moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.3)))
                    .release()
                    .perform();
        }
        if (!isDisplayed(xpath)) {
            throw new RuntimeException("Element with xpath '" + xpath + "' is not visible after 5 scrolls.");
        }
    }

    public WebElement findElementWithoutWait(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public boolean isDisplayed(String xpath) {
        try {
            return findElementWithoutWait(xpath).isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    public boolean isIOS() {
        return driver instanceof IOSDriver;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
