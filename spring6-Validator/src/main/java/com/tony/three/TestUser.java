package com.tony.three;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {


  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);

    MyService myService = context.getBean(MyService.class);

    User user = new User();

    user.setName("tony");
    user.setAge(17);
    user.setPhone("13566754321");
    user.setMessage("abcdefg");

    String s = myService.testMethod(user);
    System.out.println(s);


  }



}
