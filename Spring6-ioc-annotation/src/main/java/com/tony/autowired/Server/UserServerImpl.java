package com.tony.autowired.Server;


import com.tony.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer{


//    //通過屬性注入
//    @Autowired
//    public UserDao userDao;



//    //Set方法注入
//    @Autowired
//    public UserDao userDao;
//    public void setUserDao(UserDao userDao){
//        this.userDao = userDao;
//    }



//    //構造方法注入
//    @Autowired
//    public UserDao userDao;
//    @Autowired
//    public UserServerImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }


//    //行參注入
//    public UserDao userDao;
//    public UserServerImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //根據名注入
    @Autowired
    @Qualifier("userRedisDaoImpl")
    public UserDao userDao;


    @Override
    public void add() {
        userDao.add();
        System.out.println("Server......");
    }
}
