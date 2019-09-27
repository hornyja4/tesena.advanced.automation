package tesena.advanced.automation.objects;

import org.apache.logging.log4j.Logger;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.factories.POFactory;
import tesena.advanced.automation.logger.TestLogger;

public abstract class PageObject {
    protected Driver driver;
    protected Logger logger = TestLogger.getLogger();

    public PageObject(Driver driver) {
        this.driver = driver;
        POFactory.initPageComponents(this, driver);
    }
}
