package tesena.advanced.automation.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
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

    protected MobileElement scrollToElement(MobileElement element) {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        TouchAction touchAction = new TouchAction(driver);

        int counter = 0;
        while (!isDisplayed(element) && counter++ < 5) {
            touchAction.longPress(PointOption.point((int) (width * 0.5), (int) (height * 0.8)))
                    .moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.3)))
                    .release()
                    .perform();
        }
        if (!isDisplayed(element)) {
            throw new RuntimeException(element + " is not visible after 5 scrolls.");
        }
        return element;
    }

    private boolean isDisplayed(MobileElement mobileElement) {
        try {
            return mobileElement.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }
}
