package com.tony.autowired.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("Redis Dao.....");
    }
}
