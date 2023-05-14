package com.tony.annoaop;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {




  @Test
  public void test(){

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    Calculator bean = context.getBean("calculatorImpl",Calculator.class);

    bean.add(2,3);




  }
}
