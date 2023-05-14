package com.tony.auto.controller;

import com.tony.auto.service.UserService;

public class UserController {


    private UserService userService;

    public void setUserService(UserService userServiceSet){
        this.userService = userServiceSet;
    }


    public void addUser(){


        //調用userService方法
        userService.addUserService();

        System.out.println("UserController方法執行了...");


    }
}
