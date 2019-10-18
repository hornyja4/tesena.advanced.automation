package tesena.advanced.automation.objects;

import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.factories.POFactory;

public abstract class PageObject {
    protected Driver driver;

    public PageObject(Driver driver) {
        this.driver = driver;
        POFactory.initPageComponents(this.getClass(), this, driver);
    }
}
