package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private long startTime;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting TestNG test");
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
        System.out.println("Test execution finished in " + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName().length());
    }
}