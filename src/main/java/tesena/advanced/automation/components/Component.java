package tesena.advanced.automation.components;

import org.openqa.selenium.*;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.factories.POFactory;

import java.util.List;

public abstract class Component implements WebElement {
    private Driver driver;
    private String xpath;

    public Component(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void click() {
        driver.findElement(xpath).click();
    }

    @Override
    public void submit() {
        driver.findElement(xpath).submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        driver.findElement(xpath).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        driver.findElement(xpath).clear();
    }

    @Override
    public String getTagName() {
        return driver.findElement(xpath).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return driver.findElement(xpath).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return driver.findElement(xpath).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return driver.findElement(xpath).isEnabled();
    }

    @Override
    public String getText() {
        return driver.findElement(xpath).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElement(xpath).findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(xpath).findElement(by);
    }

    public List<WebElement> findElements(String xpath) {
        return driver.findElement(xpath).findElements(By.xpath("." + xpath));
    }

    public WebElement findElement(String xpath) {
        return driver.findElement(xpath).findElement(By.xpath("." + xpath));
    }

    @Override
    public boolean isDisplayed() {
        return driver.isDisplayed(xpath);
    }

    @Override
    public Point getLocation() {
        return driver.findElement(xpath).getLocation();
    }

    @Override
    public Dimension getSize() {
        return driver.findElement(xpath).getSize();
    }

    @Override
    public Rectangle getRect() {
        return driver.findElement(xpath).getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return driver.findElement(xpath).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return driver.findElement(xpath).getScreenshotAs(target);
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public Component scrollDownTo() {
        driver.scrollToElement(xpath);
        return this;
    }
}
