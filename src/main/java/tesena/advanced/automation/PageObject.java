package tesena.advanced.automation;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import tesena.advanced.automation.factories.POFactory;

public abstract class PageObject {
    protected Logger logger = TestLogger.getLogger();
    protected Driver driver;

    public PageObject(Driver driver) {
        this.driver = driver;
        POFactory.initElements(this, driver.getRemoteWebDriver());
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement webElement) {
        driver.waitForElement(webElement);
    }
}
