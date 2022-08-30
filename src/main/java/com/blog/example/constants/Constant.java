package com.blog.example.constants;

public class Constant {
    public enum ContentType {
        APPLICATION_JSON("application/json; charset=utf-8");

        public final String type;

        ContentType(String type) {
            this.type = type;
        }
    }
}
