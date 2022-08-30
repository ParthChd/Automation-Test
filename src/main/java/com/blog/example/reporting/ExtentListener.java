package com.blog.example.reporting;

import com.aventstack.extentreports.Status;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentManager.getExtentReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentManager.flushExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        appendTestInfoInReport(Status.PASS, result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        appendTestInfoInReport(Status.FAIL, result);
    }

    private synchronized void appendTestInfoInReport(Status testStatus, ITestResult iTestResult) {
        if (testStatus.equals(Status.FAIL)) {

            String reason = iTestResult.getThrowable() != null ? iTestResult.getThrowable().getMessage() : "Assertion Error";

            ExtentManager.getExtentTest().get().fail("<b>" + iTestResult.getMethod().getMethodName() + " has failed with reason " + reason);
        }
        if (testStatus.equals(Status.PASS)) {
            ExtentManager.getExtentTest().get().pass("<b>" + iTestResult.getMethod().getMethodName() + " has passed successfully</b>");
        }

    }

}
