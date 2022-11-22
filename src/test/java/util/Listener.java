package util;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tinylog.Logger;


public abstract class Listener implements ITestListener {

    public static final String PassedColor = "\u001B[32m";
    public static final String FailedColor =  "\u001B[31m";
    public static final String ResetColor = "\u001B[0m";

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.info("Test " + result.getName() + "..." + PassedColor + "[PASSED]" + ResetColor);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.error("Test " + result.getName() + "..." + FailedColor + "[FAILED]" + ResetColor);
    }
}