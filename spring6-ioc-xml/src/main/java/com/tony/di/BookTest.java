package com.tony.di;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {



    @Test
    public void testSet(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = (Book) context.getBean("Book",Book.class);

        System.out.println(book);


    }


    @Test
    public void testConstructor(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = (Book) context.getBean("BookCon",Book.class);

        System.out.println(book);


    }
}
