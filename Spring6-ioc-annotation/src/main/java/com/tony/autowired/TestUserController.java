package com.tony.autowired;

import com.tony.autowired.controller.UserController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


public class TestUserController {



    @Test
    public void test(){


        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserController userController = context.getBean("userController", UserController.class);


        userController.add();
    }
}
