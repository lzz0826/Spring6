package com.tony.springi18n;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Resourcel18n {




  //basename_language_country.properties (命名規則)
  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    Object[] o = new Object[]{"ttpmu",new Date().toString()};

    //使用中文properties
    String message = context.getMessage("www.tony.com", o, Locale.CHINA);
    System.out.println(message);

    //使用英文properties
    String message2 = context.getMessage("www.tony.com",o, Locale.UK);
    System.out.println(message2);


  }

}
