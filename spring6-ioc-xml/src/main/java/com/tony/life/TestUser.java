package com.tony.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {


    public static void main(String[] args) {

        //必須使用 ClassPathXmlApplicationContext 子類才能銷毀
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");

        User user = context.getBean("user", User.class);

        System.out.println("6 bean對象創建完成 可以使用");
        System.out.println(user);
        context.close();//銷毀
    }
}
