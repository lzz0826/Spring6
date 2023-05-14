package com.tony.dao;


import com.tony.anno.Bean;

@Bean
public class UserDaoImpl implements UserDao{

  @Override
  public void add() {
    System.out.println("Dao....");
  }
}
