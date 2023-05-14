package com.tony.two;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Service
public class MyValidationSpring {

  //使用Spring的
  @Resource
  public Validator validator;

  public boolean validationSpringByUser(User user){

    BindException bindException = new BindException(user, user.getName());
    validator.supports(User.class);
    validator.validate(user,bindException);
    System.out.println(bindException.getMessage());

    return bindException.hasErrors();


  }

}
