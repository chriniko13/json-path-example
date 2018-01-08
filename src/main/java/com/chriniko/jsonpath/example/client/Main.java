package com.chriniko.jsonpath.example.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        loadJsonPathConfiguration();

        ApplicationContext context = new ClassPathXmlApplicationContext("config-beans.xml");

        GameGroupsTester.firstExample(context);

        BooksTester.firstExample(context);
    }

    private static void loadJsonPathConfiguration() {
        // load necessary json path configuration...
        try {
            Class.forName("com.chriniko.jsonpath.example.configuration.JsonPathConfiguration");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("critical configuration error");
        }
    }

}
