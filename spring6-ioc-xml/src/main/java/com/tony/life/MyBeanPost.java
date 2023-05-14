package com.tony.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


//實現BeanPostProcessor
public class MyBeanPost implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("3 bean後置處理器,初始化之前執行ㄓ");
        System.out.println(beanName+":"+ bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean後置處理器,初始化後執行ㄓ");
        System.out.println(beanName+":"+ bean);
        return bean;    }
}
