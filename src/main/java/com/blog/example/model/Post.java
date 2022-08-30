package com.blog.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

//Note - not including all the json properties as of now which are not useful for the test cases
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Post {

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

}
