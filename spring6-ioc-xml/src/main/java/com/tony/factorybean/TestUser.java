package com.tony.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");

        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);

    }
}
