package com.anjali.config;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String baseUrl;

    static {
        Properties properties = new Properties();
        try {
            String env = System.getProperty("env.USER");
            if (env == null || env.isEmpty()) {
                properties.load(new FileReader("src/main/resources/config/test.properties"));
            } else if (env.equals("int")) {
                properties.load(new FileReader("src/main/resources/config/test.properties"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            baseUrl = properties.getProperty("baseUrl");
        }
    }
}
