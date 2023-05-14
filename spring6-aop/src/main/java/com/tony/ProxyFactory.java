package com.tony;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {


  private Object target;

  //目標掉項
  public ProxyFactory(Object target) {
    this.target = target;
  }

  //返回代裡對象
  public Object getProxy(){

    // Proxy.newProxyInstance() 有三個參數
    // ClassLoader: 加載動態生成代理類的類加載器
    // Class<?>[] interfaces: 目錄對象實現的所有接口的class類型數組
    // InvocationHandler: 設置代理對對象實現目標對象方法的過程

    //1.ClassLoader: 加載動態生成代理類的類加載器
    ClassLoader classLoader = target.getClass().getClassLoader();

    //2. Class<?>[] interfaces: 目錄對象實現的所有接口的class類型數組
    Class<?>[] interfaces = target.getClass().getInterfaces();

    //3.InvocationHandler: 設置代理對對象實現目標對象方法的過程
    //使用匿名內部類
    InvocationHandler invocationHandler = new InvocationHandler() {

      //proxy 代理對象
      //method 需要重寫目標對象方法
      //args method方法裡面參數
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法調用之前輸出
        System.out.println("[動態代理[日誌]"+method.getName()+"參數:"+ Arrays.toString(args));

        //調用目標的方法
        Object result = method.invoke(target, args);

        //方法調用之後輸出
        System.out.println("[動態代理[日誌]"+method.getName()+"結果:"+ result);
        return result;
      }
    };

    return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

  }

}
