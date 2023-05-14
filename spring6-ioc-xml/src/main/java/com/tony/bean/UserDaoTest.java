package com.tony.bean;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {


    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //使用類型同時有兩格實例的話會報錯
//        UserDao u = context.getBean(UserDao.class);

        UserDao u = (UserDao) context.getBean("PersonDalImpl");

        u.run();


    }
}
