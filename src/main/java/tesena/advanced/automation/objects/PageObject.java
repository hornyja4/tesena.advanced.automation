package tesena.advanced.automation.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tesena.advanced.automation.factories.POFactory;

public abstract class PageObject {
    protected AndroidDriver<MobileElement> driver;

    public PageObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        POFactory.initElements(this, driver);
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(MobileElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> expectedCondition = driver -> {
            try {
                return element.isDisplayed();
            } catch (WebDriverException e) {
                return false;
            }
        };
        wait.until(function -> expectedCondition.apply(driver));
    }

    protected void scrollToElement(MobileElement element) {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        TouchAction touchAction = new TouchAction(driver);

        int counter = 0;
        while (counter++ < 10) {
            touchAction.longPress(PointOption.point((int)(width * 0.5), (int)(height * 0.8)))
                    .moveTo(PointOption.point((int)(width * 0.5), (int)(height * 0.3)))
                    .release()
                    .perform();
            if (isElementDisplayed(element)) {
                return;
            }
        }
        throw new RuntimeException("Element was not found.");
    }

    private boolean isElementDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }
}
