package com.tony.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersionValidator implements Validator {


  //對應的類
  @Override
  public boolean supports(Class<?> clazz) {
    return Person.class.equals(clazz);
  }


  //校驗規則
  @Override
  public void validate(Object target, Errors errors) {

    //name不能為空
    ValidationUtils.rejectIfEmpty(errors,
        "name","name.empty","名字不能為空");


    //age不能小於0 不能大於200
    Person person = (Person) target;
    if(person.getAge() < 0){
      errors.rejectValue("age","age.value.error","年齡小於0");
    }
    if(person.getAge() >200){
      errors.rejectValue("age","age.value.old","年齡大於200");

    }

  }
}
