package com.user.blog.example;

import com.blog.example.constants.Constant;
import com.blog.example.model.Post;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.blog.example.controller.ApiController.get;
import static com.blog.example.reporting.ExtentManager.createExtentTest;
import static com.user.blog.example.utils.ResponseValidator.assertResponseCode;
import static com.user.blog.example.utils.ResponseValidator.assertResponseContentType;
import static org.testng.Assert.assertTrue;

public class Posts_Testcases {


    @BeforeClass
    public void startReport() {
        createExtentTest("Post test case");
    }


    @Test(priority = 1)
    public void should_return_success_response_code_and_correct_content_type_for_fetching_posts() {
        Response response =get("/posts");
        assertResponseCode(response, 200);
        assertResponseContentType(response, Constant.ContentType.APPLICATION_JSON.type);
    }

    @Test(priority = 1)
    public void should_return_posts_for_fetch_by_id() {
        Response response =get("/posts/1");
        Post post = response.getBody().as(Post.class);
        assertTrue(post!= null);    }

}
