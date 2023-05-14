package com.tony.server.impl;

import com.tony.anno.Bean;
import com.tony.anno.Di;
import com.tony.dao.UserDao;
import com.tony.dao.UserDaoImpl;
import com.tony.server.UserServer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Bean
public class UserServerImpl implements UserServer {


  @Di
  private UserDao userDao;

  @Override
  public void add()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    System.out.println("server....");

//    //調用Dao 使用反射
//    Class aClass = Class.forName("com.tony.dao.UserDaoImpl");
//    Method add = aClass.getMethod("add");
//    Object instance = aClass.newInstance();
//    add.invoke(instance);
//
//    //調用Dao 使用反射 使用構造
//    UserDaoImpl userDao = UserDaoImpl.class.getConstructor().newInstance();
//    userDao.add();

    //通過手寫@Di注入
    userDao.add();

  }



}
