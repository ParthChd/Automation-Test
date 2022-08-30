package com.blog.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extent;
    public static ThreadLocal<ExtentTest> getExtentTest() {
        return extentTest;
    }

    public static void getExtentReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = null;
        String workingDir=System.getProperty("user.dir");
        try {
            spark = new ExtentSparkReporter(workingDir+"/testoutput/extentReport/UserBlogApiTestReport.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        extent.attachReporter(spark);
        extent.setSystemInfo("Blog Name", "User Blog API Automation Report");
        extent.setSystemInfo("Author", "Parth Bhardwaj");
    }

    public static void flushExtentReports() {
        extent.flush();
    }

    public static void createExtentTest(String testname){
        ExtentTest test = extent.createTest(testname);
        extentTest.set(test);
    }
}
