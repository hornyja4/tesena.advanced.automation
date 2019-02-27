package tesena.advanced.automation;

import org.openqa.selenium.WebElement;

public abstract class PageObject {
    private Driver driver;

    public PageObject(Driver driver) {
        this.driver = driver;
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement webElement) {
        driver.waitForElement(webElement);
    }
}
