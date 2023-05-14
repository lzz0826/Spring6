package com.tony.di.ditest;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {

    @Test
    public void test(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");

        Dept dept = context.getBean("dept", Dept.class);

        dept.info();
    }


}
