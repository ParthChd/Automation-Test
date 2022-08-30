package com.user.blog.example.utils;


import org.apache.commons.io.IOUtils;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ResponseValidator {
    public static void assertResponseCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void assertResponseContentType(Response response, String expectedContentType) {
        Assert.assertEquals(response.getContentType(), expectedContentType);
    }

    @Test
    public static void assertResponseContent(String path, Response response) {
        try {
            String expected = IOUtils.toString(new File(path).toURI(), Charset.defaultCharset());
            String actual = response.asString();
            JSONAssert.assertEquals(
                    expected, actual, JSONCompareMode.LENIENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
