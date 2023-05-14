package com.tony.auto;

import com.tony.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {


    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");

        UserController userController = context.getBean("userController", UserController.class);

        userController.addUser();


    }

}
