package com.blog.example.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.blog.example.utils.PropertyCache.getPropertyCache;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(getPropertyCache().getValue("base.uri"))
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .build();
    }
}
