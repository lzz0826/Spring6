package com.tony.two;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyValidationNative {


  //使用原生的
  @Autowired
  private Validator validator;

  public boolean validatorNativeByUser(User user){
    Set<ConstraintViolation<User>> validate = validator.validate(user);

    System.out.println(validate);

    return validate.isEmpty();
  }






}
