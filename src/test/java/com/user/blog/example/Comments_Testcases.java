package com.user.blog.example;

import com.blog.example.constants.Constant;
import com.blog.example.model.Comment;
import com.user.blog.example.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.blog.example.controller.ApiController.get;
import static com.blog.example.reporting.ExtentManager.createExtentTest;
import static org.testng.Assert.assertTrue;

public class Comments_Testcases {

    @BeforeClass
    public void startReport() {
        createExtentTest("Comments test case");
    }


    @Test(priority = 1)
    public void should_return_success_response_code_and_correct_content_type_for_fetching_comments() {
        Response response =get("/comments");
        ResponseValidator.assertResponseCode(response, 200);
        ResponseValidator.assertResponseContentType(response, Constant.ContentType.APPLICATION_JSON.type);
    }

    @Test(priority = 1)
    public void should_return_comments_for_fetch_by_postId() {
        Response response =get("/comments?postId=1");
        List<Comment> responseList = Arrays.asList(response.getBody().as(Comment[].class));
        assertTrue(responseList.size()>0);    }

}
