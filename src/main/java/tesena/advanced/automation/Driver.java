package tesena.advanced.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static final int TIMEOUT = 20;
    private RemoteWebDriver remoteWebDriver;

    public Driver(DesiredCapabilities capabilities) {
        initDriver(capabilities);
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    private void initDriver(DesiredCapabilities capabilities) {
        String server = (String) capabilities.getCapability("server");
        try {
            switch (capabilities.getPlatform()) {
                case LINUX: case XP: case UNIX: case WINDOWS:
                    remoteWebDriver = new RemoteWebDriver
                            (new URL(server), capabilities);
                    break;
                case ANDROID:
                    remoteWebDriver = new AndroidDriver<MobileElement>
                            (new URL(server), capabilities);
                    break;
                case IOS:
                    remoteWebDriver = new IOSDriver<MobileElement>
                            (new URL(server), capabilities);
                    break;
                default:
                    throw new RuntimeException("Unknown driver type " + capabilities.getPlatform());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

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
