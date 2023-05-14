package com.tony;



public class TestCal {


  public static void main(String[] args) {

    //傳遞目標對象(動態)
    ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());


    Calculator proxy = (Calculator) proxyFactory.getProxy();

    proxy.add(2,4);

    proxy.mul(3,4);



  }

}
