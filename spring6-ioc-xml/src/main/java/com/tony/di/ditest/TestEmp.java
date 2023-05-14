package com.tony.di.ditest;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {


    @Test
    public void test(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");

        Emp emp = context.getBean("emp" , Emp.class);


        emp.work();


    }
}
