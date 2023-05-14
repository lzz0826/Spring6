package com.tony.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {



  @Test
  public void test(){

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    ResourceBean resourceBean = context.getBean("resourceBean",ResourceBean.class);


    resourceBean.run();


  }
}
