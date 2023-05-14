package com.tony;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testUser(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

//        //根據id獲取到bean
        User user1 = (User) context.getBean("User");
        System.out.println("根據id獲取到bean"+user1);

        //根據類型取得bean
        //要求IOC容器中只應類型的beanu有且只能有一個
//        org.springframework.beans.factory.NoUniqueBeanDefinitionException:
//        No qualifying bean of type 'com.tony.User' available: expected single matching bean but
//        found 2: User,User2

        User user2 = context.getBean(User.class);
        System.out.println("根據類型取得bean"+user2);



//        //根據id.類型獲取到bean
        User user3 = context.getBean("User", User.class);
        System.out.println("根據id.類型獲取到bean"+user3);


    }

}
