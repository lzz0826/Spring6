package com.tony.resource.Server;


import com.tony.resource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer {


    @Override
    public void add() {
//        userDao.add();
        System.out.println("Server......");
    }
}
