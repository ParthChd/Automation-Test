package com.blog.example.utils;

import com.aventstack.extentreports.Status;

import static com.blog.example.reporting.ExtentManager.getExtentTest;

public class LoggingUtil {
    public void logMessage(Status status, String message)
    {
        getExtentTest().get().log(status, message);
    }

    public void assertResponseStatusCode(int statusCode, String message)
    {
    }
}
