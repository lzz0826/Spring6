package com.tony.auto.service;

import com.tony.auto.dao.UserDao;

public class UserServiceImpl implements UserService{

    private UserDao userDao;


    public void setUserDao(UserDao userDao){
        this.userDao =userDao;
    }



    @Override
    public void addUserService() {
        //調用dao方法
        userDao.addUserDao();
        System.out.println("UserService方法執行了...");
    }
}
