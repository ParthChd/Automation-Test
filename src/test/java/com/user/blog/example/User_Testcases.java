package com.user.blog.example;

import com.blog.example.constants.Constant;
import com.blog.example.model.User;
import com.user.blog.example.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.blog.example.controller.ApiController.get;
import static com.blog.example.reporting.ExtentManager.createExtentTest;
import static org.testng.Assert.assertTrue;

public class User_Testcases {

    private String nameToSearch = "Samantha";

    @BeforeClass
    public void startReport() {
        createExtentTest("User test case");
    }


    @Test(priority = 1)
    public void should_return_success_response_code_and_correct_content_type_for_fetching_users_list() {
        Response response =get("/users");
        ResponseValidator.assertResponseCode(response, 200);
        ResponseValidator.assertResponseContentType(response, Constant.ContentType.APPLICATION_JSON.type);
    }

    @Test(priority = 1)
    public void should_return_samantha_in_response_for_users_lists() {
        Response response =get("/users");
        List<User> responseList = Arrays.asList(response.getBody().as(User[].class));
        assertTrue(responseList.size()>0);
    }

}
