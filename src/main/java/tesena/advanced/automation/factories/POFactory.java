package tesena.advanced.automation.factories;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import tesena.advanced.automation.objects.PageObject;

import java.time.Duration;

public class POFactory {

    public static void initElements(PageObject object, AppiumDriver<MobileElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), object);
    }
}
