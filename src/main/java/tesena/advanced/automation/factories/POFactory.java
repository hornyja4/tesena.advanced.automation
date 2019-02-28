package tesena.advanced.automation.factories;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import tesena.advanced.automation.Component;
import tesena.advanced.automation.Driver;
import tesena.advanced.automation.PageObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

@SuppressWarnings("unchecked")
public class POFactory {

    public static void processPageObjectComponents(PageObject pageObject, Driver driver) {
        Class<PageObject> klass = (Class<PageObject>) pageObject.getClass();
        processClassComponents(klass, pageObject, driver);
        while (!(klass = (Class<PageObject>) klass.getSuperclass()).equals(PageObject.class)) {
            processClassComponents(klass, pageObject, driver);
        }
    }

    private static void processClassComponents(Class<PageObject> klazz, PageObject pageObject, Driver driver) {
        for (Field field: klazz.getDeclaredFields()) {
            if (isComponent(field)) {
                Component component = null;
                try {
                    component = field.getType().asSubclass(Component.class).getConstructor(Driver.class).newInstance(driver);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
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

    private static boolean isComponent(Field field) {
        Class fieldType = field.getType();
        while ((fieldType = fieldType.getSuperclass()) != Component.class) {
            if (fieldType == null) {
                return false;
            }
        }
        return true;
    }

    public static void initElements(PageObject object, RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(remoteWebDriver, Duration.ofSeconds(5)), object);
    }
}
