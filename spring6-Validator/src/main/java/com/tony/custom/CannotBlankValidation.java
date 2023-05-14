package com.tony.custom;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CannotBlankValidation implements ConstraintValidator<CannotBlank,String> {

  //isValid 在這實現具體校驗
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if(value != null && value.contains(" ")){
      //獲取默認提示訊息
      String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
      System.out.println("default messate :"+defaultConstraintMessageTemplate);
      //禁用默認提示
      context.disableDefaultConstraintViolation();
      //設置提示語
      context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();

      return false;

    }


    return true;
  }
}











