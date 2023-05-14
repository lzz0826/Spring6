package com.tony.scope;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {


    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);

        Orders orders2 = context.getBean("orders", Orders.class);
        System.out.println(orders2);

    }
}
