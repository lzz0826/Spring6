package com.tony.two;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {



  @Test
  public void testMyValidationNative(){
    ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
    MyValidationNative myValidationNative = context.getBean(
        MyValidationNative.class);
    User user = new User();
    user.setName("tony");
    user.setAge(10);
    boolean b = myValidationNative.validatorNativeByUser(user);
    System.out.println("使用原生Validation : "+b);

  }

  @Test
  public void test(){
    ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);

    MyValidationSpring myValidationSpring = context.getBean(MyValidationSpring.class);

    User user = new User();
    user.setName("t");
//    user.setAge(-1);

    boolean b = myValidationSpring.validationSpringByUser(user);

    System.out.println("使用Spring :" +b);


  }


}
