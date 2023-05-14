package com.tony.resourceloaderaware;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {



  @Test
  public void test(){

    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    TestBean bean = context.getBean("testBean", TestBean.class);

    ResourceLoader resourceLoader = bean.getResourceLoader();

    System.out.println(context == resourceLoader);

  }

}
