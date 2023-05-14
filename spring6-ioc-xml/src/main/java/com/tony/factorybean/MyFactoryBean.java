package com.tony.factorybean;

import org.springframework.beans.factory.FactoryBean;

//實現implements 在使用范行 常用於整合第三方筐架
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
