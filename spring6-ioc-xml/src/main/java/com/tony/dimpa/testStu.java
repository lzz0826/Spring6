package com.tony.dimpa;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testStu {


    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");

        Student student = context.getBean("studentP" , Student.class);

        student.run();

    }

}
