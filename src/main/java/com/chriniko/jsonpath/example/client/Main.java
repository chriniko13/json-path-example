package com.chriniko.jsonpath.example.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config-beans.xml");

        GameGroupsTester.firstExample(context);
    }

}
