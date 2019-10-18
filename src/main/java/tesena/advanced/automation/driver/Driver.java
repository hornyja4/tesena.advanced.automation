package tesena.advanced.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tesena.advanced.automation.components.Component;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private RemoteWebDriver driver;

    public Driver(DesiredCapabilities capabilities, String server) {
        initDriverMethod(capabilities, server);
    }

    private void initDriverMethod(DesiredCapabilities capabilities, String server) {
        URL serverURL;
        try {
            serverURL = new URL(server);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Server URL has wrong format: " + server);
        }
        switch (capabilities.getPlatform()) {
            case ANDROID:
                driver = new AndroidDriver<>(serverURL, capabilities);
                break;
            case IOS:
                driver = new IOSDriver<>(serverURL, capabilities);
                break;
            case WINDOWS:
            case LINUX:
                switch (capabilities.getBrowserName().toUpperCase()) {
                    case "CHROME":
                        driver = new ChromeDriver();
                        break;
                    case "FIREFOX":
                        driver = new FirefoxDriver();
                        break;
                    case "IE":
                        driver = new InternetExplorerDriver();
                        break;
                    case "SAFARI":
                        driver = new SafariDriver();
                        break;
                    default:
                        throw new RuntimeException("Browser " + capabilities.getBrowserName() + " is not supported.");
                }
            default:
                throw new RuntimeException("Platform " + capabilities.getPlatform() + " is not supported.");
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement findElement(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        ExpectedCondition<WebElement> expectedCondition = driver -> {
            try {
                assert driver != null;
                return driver.findElements(By.xpath(xpath))
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("No element found."));
            } catch (WebDriverException e) {
                return null;
            }
        };
        return wait.until(function -> expectedCondition.apply(driver));
    }

    /*public void waitForElement(MobileElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> expectedCondition = driver -> {
            try {
                return element.isDisplayed();
            } catch (WebDriverException e) {
                return false;
            }
        };
        wait.until(function -> expectedCondition.apply(driver));
    }*/

    public AppiumDriver getAppiumDriver() {
        if (driver instanceof AppiumDriver) {
            return (AppiumDriver) driver;
        }
        throw new RuntimeException("Driver is not Appium.");
    }

    public void scrollToElement(Component component) {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        TouchAction touchAction = new TouchAction(getAppiumDriver());

        int counter = 0;
        while (counter++ < 10) {
            touchAction.longPress(PointOption.point((int)(width * 0.5), (int)(height * 0.8)))
                    .moveTo(PointOption.point((int)(width * 0.5), (int)(height * 0.3)))
                    .release()
                    .perform();
            if (isElementDisplayed(component)) {
                return;
            }
        }
        throw new RuntimeException("Element was not found.");
    }

    private boolean isElementDisplayed(Component component) {
        try {
            return component.isDisplayed();
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

}
