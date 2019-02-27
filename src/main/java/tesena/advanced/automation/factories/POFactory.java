package tesena.advanced.automation.factories;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import tesena.advanced.automation.PageObject;

import java.time.Duration;

public class POFactory {

    public static void initElements(PageObject object, RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(remoteWebDriver, Duration.ofSeconds(5)), object);
    }
}
