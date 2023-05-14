package com.tony.autowired.controller;


import com.tony.autowired.Server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

//    //  屬性注入
//    @Autowired
//    private UserServer userServer;

//    //Set方法注入
//    @Autowired
//    private UserServer userServer;
//    public void setUserServer(UserServer userServer){
//        this.userServer = userServer;
//    }


//    //構造方法注入
//    private UserServer userServer;
//    public UserController(UserServer userServer){
//        this.userServer = userServer;
//    }

//    //行參注入
//        private UserServer userServer;
//    public UserController(@Autowired UserServer userServer) {
//        this.userServer = userServer;
//    }


    //只有一個有參構造函數 無註解會自動照到(有兩個以上構造就不能用)
    private UserServer userServer;
        public UserController( UserServer userServer) {
            this.userServer = userServer;
        }

    public void add(){

        userServer.add();
        System.out.println("Controller....");
    }


}
