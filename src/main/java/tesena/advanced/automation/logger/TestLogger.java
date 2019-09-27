package tesena.advanced.automation.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestLogger {
    private static ThreadLocal<Logger> threadLocal = new ThreadLocal<>();

    public static void init(String testName, String fileName) {
        ThreadContext.put("testName", testName);
        ThreadContext.put("fileName", fileName);
        threadLocal.set(LogManager.getLogger("TestLogger"));
    }

    public static Logger getLogger() {
        return threadLocal.get();
    }
}
