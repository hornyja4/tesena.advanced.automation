package tesena.advanced.automation.factories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tesena.advanced.automation.components.Component;
import tesena.advanced.automation.driver.Driver;
import tesena.advanced.automation.objects.PageObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class POFactory {

    public static void initPageComponents(Class klass, Object object, Driver driver) {
        processFields(klass, object, driver);
        Class pageObjectClass;
        while (!(pageObjectClass = klass.getSuperclass()).equals(PageObject.class)) {
            processFields(pageObjectClass, object, driver);
        }
    }

    public static void initComponents(Class klass, Object object, Driver driver) {
        processFields(klass, object, driver);
        Class pageObjectClass;
        while (!(pageObjectClass = klass.getSuperclass()).equals(Component.class)) {
            processFields(pageObjectClass, object, driver);
        }
    }

    private static void processFields(Class klass, Object object, Driver driver) {
        for (Field field : klass.getDeclaredFields()) {
            if (Component.class.isAssignableFrom(field.getType())) {
                Component component;
                try {
                    component = field.getType().asSubclass(Component.class).getConstructor(Driver.class).newInstance(driver);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
                if (driver.isAndroid()) {
                    AndroidFindBy androidFindBy;
                    if ((androidFindBy = field.getDeclaredAnnotation(AndroidFindBy.class)) != null) {
                        component.setXpath(androidFindBy.xpath());
                    }
                } else if (driver.isIOS()) {
                    iOSXCUITFindBy iOSXCUITFindBy;
                    if ((iOSXCUITFindBy = field.getDeclaredAnnotation(iOSXCUITFindBy.class)) != null) {
                        component.setXpath(iOSXCUITFindBy.xpath());
                    }
                } else {
                    FindBy findBy;
                    if ((findBy = field.getDeclaredAnnotation(FindBy.class)) != null) {
                        component.setXpath(findBy.xpath());
                    }
                }
                field.setAccessible(true);
                try {
                    field.set(object, component);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void initElements(PageObject object, RemoteWebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(1)), object);
    }
}
