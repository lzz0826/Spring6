package com.tony;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {


    private Logger logger = LoggerFactory.getLogger(TestUser.class);



    @Test
    public void testUser(){
        //加載spring配置文件 , 對象創建,此時就會執行無參構造 (文件名稱)
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //獲取創建對象 beam.xml 設定的id 屬性值
        //返回Object 強轉成User
        User user = (User) context.getBean("User");

        System.out.println(user);

        //使用對象調用方法
        user.add();

        //手動寫log
        logger.info("方法調用完成");

    }


    //使用反射
    @Test
    public void testUserReflex() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //獲取Class對象
        Class userClass = Class.forName("com.tony.User");

        //調用方法創建對象
        //在17已過時
//        User user = (User) userClass.newInstance();

        //在此會執行無參構造
        User user = (User) userClass.getDeclaredConstructor().newInstance();
        System.out.println(user);

    }




}










