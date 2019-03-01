package tesena.advanced.automation.factories;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DataFactory {
    private static File dataFolder = new File("src\\test\\resources");

    public static String getBundleProperty(String key) {
        return Normalizer.normalize(processBundle(key), Normalizer.Form.NFC);
    }

    private static String processBundle(String value) {
        try {
            URL[] urls = new URL[]{dataFolder.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            return new String(ResourceBundle.getBundle("language", Locale.getDefault(), loader).getString(value).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (MissingResourceException exception) {
            return value;
        }
        return value;
    }

}
