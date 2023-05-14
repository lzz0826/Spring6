package com.tony;

import static java.util.Locale.CHINESE;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resourcel18n {




  //basename_language_country.properties (命名規則)
  public static void main(String[] args) {
    ResourceBundle zh = ResourceBundle.getBundle("messages",
        new Locale("zh","CN"));

    String zhString = zh.getString("test");
    System.out.println(zhString);

    ResourceBundle gb = ResourceBundle.getBundle("messages"
        , new Locale("en", "GB"));
    String gbString = gb.getString("test");
    System.out.println(gbString);


  }

}
