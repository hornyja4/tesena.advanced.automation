package tesena.advanced.automation;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;

import java.util.List;


public class Component implements WebElement {
    private Driver driver;
    private String xpath;

    public Component(Driver driver) {
        this.driver = driver;
    }

    public String getXpath() {
        return xpath;
    }

    private WebElement findElement() {
        driver.waitForElement(xpath);
        return driver.findElement(xpath);
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public void click() {
        findElement().click();
    }

    @Override
    public void submit() {
        findElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        findElement().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        findElement().clear();
    }

    @Override
    public String getTagName() {
        return findElement().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return findElement().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return findElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    @Override
    public String getText() {
        return findElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return findElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return findElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return findElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return findElement().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return findElement().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return findElement().getScreenshotAs(outputType);
    }
}
