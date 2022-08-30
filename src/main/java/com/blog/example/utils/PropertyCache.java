package com.blog.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyCache {
    private final Properties properties = new Properties();
    private static PropertyCache INSTANCE;

    private PropertyCache() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static PropertyCache getPropertyCache() {
        if (INSTANCE == null) {
            INSTANCE = new PropertyCache();
            return INSTANCE;
        } else
            return INSTANCE;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
