package tesena.advanced.automation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MobileListener implements ITestListener {
    private Calendar calendar = Calendar.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getRealClass().getSimpleName();
        StringBuilder builder = new StringBuilder();
        builder.append("test_report")
                .append(File.separator)
                .append(new SimpleDateFormat("YYYY").format(calendar.getTime()))
                .append(File.separator)
                .append(new SimpleDateFormat("MMMMM").format(calendar.getTime()))
                .append(File.separator)
                .append(new SimpleDateFormat("DDHHmm").format(calendar.getTime()))
                .append(File.separator)
                .append(testName)
                .append(".log");
        TestLogger.initLogger(testName, builder.toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
