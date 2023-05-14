package com.tony.resource;

import com.tony.config.SpringConfig;
import com.tony.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestResourceUserController {



    @Test
    public void test(){

        //加載配置類
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = context.getBean("userController", UserController.class);


        userController.add();
    }
}
