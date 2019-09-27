package tesena.advanced.automation.factories;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.annotations.IOSXpath;
import tesena.advanced.automation.annotations.VerifyText;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class POFactory {

    public static void initPageComponents(Component component, Driver driver) {
        Class pageObjectClass = component.getClass();
        processClassFields(pageObjectClass, component, driver);
        while (!(pageObjectClass = pageObjectClass.getSuperclass()).equals(Component.class)) {
            processClassFields(pageObjectClass, component, driver);
        }
    }

    public static void initPageComponents(PageObject pageObject, Driver driver) {
        Class<? extends PageObject> pageObjectClass = pageObject.getClass();
        processClassFields(pageObjectClass, pageObject, driver);
        while (!(pageObjectClass = (Class<? extends PageObject>) pageObjectClass.getSuperclass()).equals(PageObject.class)) {
            processClassFields(pageObjectClass, pageObject, driver);
        }
    }

    private static void processClassFields(Class objectClass, Object pageObject, Driver driver) {
        for (Field field: objectClass.getDeclaredFields()) {
            if (Component.class.isAssignableFrom(field.getType())) {
                Component component;
                try {
                    component = field.getType().asSubclass(Component.class).getConstructor(Driver.class).newInstance(driver);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not create an instance of component." + e.getMessage());
                }
                if (driver.isAndroid()) {
                    AndroidXpath androidXpath;
                    if ((androidXpath = field.getDeclaredAnnotation(AndroidXpath.class)) != null) {
                        component.setXpath(androidXpath.xpath());
                    }
                } else if (driver.isIOS()) {
                    IOSXpath iosXpath;
                    if ((iosXpath = field.getDeclaredAnnotation(IOSXpath.class)) != null) {
                        component.setXpath(iosXpath.xpath());
                    }
                } else {
                    throw new RuntimeException("Driver must be an instance of Android or IOS");
                }
                VerifyText verifyText;
                if ((verifyText = field.getDeclaredAnnotation(VerifyText.class)) != null) {
                    Assert.assertEquals(component.getText(), verifyText.text());
                }
                field.setAccessible(true);
                try {
                    field.set(pageObject, component);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void initElements(PageObject object, AppiumDriver<MobileElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(1)), object);
    }
}
