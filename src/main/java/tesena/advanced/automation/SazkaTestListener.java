package tesena.advanced.automation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tesena.advanced.automation.logger.TestLogger;

import java.io.File;

public class SazkaTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getRealClass().getSimpleName();
        String fileName = "reports" + File.separator + testName + ".log";
        TestLogger.init(testName, fileName);
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
