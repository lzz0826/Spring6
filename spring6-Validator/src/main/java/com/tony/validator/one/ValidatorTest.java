package com.tony.validator.one;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;

public class ValidatorTest {




  @Test
  public void test(){

    //創建persion對象
    Person person = new Person(null,-1);

    //創建persion對應的databinder
    DataBinder dataBinder = new DataBinder(person);

    //設置校驗器
    dataBinder.setValidator(new PersionValidator());

    //調用方法執行校驗
    dataBinder.validate();


    //輸出校驗結果
    BindingResult result = dataBinder.getBindingResult();
    System.out.println(result.getAllErrors());


  }

}









