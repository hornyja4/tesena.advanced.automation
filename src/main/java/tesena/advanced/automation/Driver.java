package tesena.advanced.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
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

    public WebElement findElement(String xpath) {
        return remoteWebDriver.findElement(By.xpath(xpath));
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

    public void waitForElement(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(remoteWebDriver, TIMEOUT);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                return findElement(xpath).isDisplayed();
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

    private void swipeVertically(Vertically vertically) {
        Dimension dimension = remoteWebDriver.manage().window().getSize();
        int startX = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.6);
        int endY = (int) (dimension.getHeight() * 0.2);
        scrollAtMobile(startX, startY, endY, vertically);
    }

    private void scrollAtMobile(int startX, int startY, int endY, Vertically vertically) {
        TouchAction touchAction = createTouchAction();
        try {
            switch (vertically) {
                case UP:
                    touchAction
                            .longPress(PointOption.point(startX, endY))
                            .moveTo(PointOption.point(startX, startY))
                            .release()
                            .perform();
                    break;
                case DOWN:
                    touchAction
                            .longPress(PointOption.point(startX, startY))
                            .moveTo(PointOption.point(startX, endY))
                            .release()
                            .perform();
                    break;
            }
        } catch (WebDriverException e) {
            TestLogger.getLogger().error("Error occurred during direction. Probably application is loading...");
        }
    }

    private TouchAction createTouchAction() {
        if (this.remoteWebDriver instanceof AndroidDriver) {
            return new TouchAction((AndroidDriver) remoteWebDriver);
        } else {
            return new TouchAction((IOSDriver) remoteWebDriver);
        }
    }

    public enum Vertically {
        UP, DOWN;
    }
}
