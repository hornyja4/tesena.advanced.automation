package tesena.advanced.automation.components;

import org.openqa.selenium.*;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.factories.POFactory;

import java.util.List;

public abstract class Component implements WebElement {
    private String xpath;
    private Driver driver;
    private Component parentComponent;

    public Component(Driver driver) {
        this.driver = driver;
        POFactory.initComponents(this.getClass(), this, driver);
    }

    public String getXpath() {
        if (parentComponent != null) {
            return parentComponent.getXpath() + xpath;
        }
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public void setParentComponent(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    @Override
    public void click() {
        driver.findElement(getXpath()).click();
    }

    @Override
    public void submit() {
        driver.findElement(getXpath()).submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        driver.findElement(getXpath()).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        driver.findElement(getXpath()).clear();
    }

    @Override
    public String getTagName() {
        return driver.findElement(getXpath()).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return driver.findElement(getXpath()).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return driver.findElement(getXpath()).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return driver.findElement(getXpath()).isEnabled();
    }

    @Override
    public String getText() {
        return driver.findElement(getXpath()).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElement(getXpath()).findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(getXpath()).findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return driver.findElement(getXpath()).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return driver.findElement(getXpath()).getLocation();
    }

    @Override
    public Dimension getSize() {
        return driver.findElement(getXpath()).getSize();
    }

    @Override
    public Rectangle getRect() {
        return driver.findElement(getXpath()).getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return driver.findElement(getXpath()).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return driver.findElement(getXpath()).getScreenshotAs(target);
    }

    public Component scrollToComponent() {
        driver.scrollToElement(this);
        return this;
    }
}
