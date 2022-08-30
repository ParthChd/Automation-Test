package com.blog.example.controller;

import io.restassured.response.Response;

import java.util.Map;

import static com.blog.example.utils.SpecBuilder.getRequestSpec;
import static io.restassured.RestAssured.given;

public class ApiController {


    public static Response get(String url) {
        Response response = null;
        try {
            response = given(getRequestSpec()).when()
                    .get(url).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    public static Response getWithParams(String url, Map<String, Integer> params) {
        Response response = null;
        try {
            response = given(getRequestSpec()).params(params).when().get(url).then().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
