package com.tony.annoaop;

import org.springframework.stereotype.Component;

//基本計算機功能
@Component
public class CalculatorImpl implements Calculator {

  @Override
  public int add(int i, int j) {

    int result = i+j;
    System.out.println("方法內部 result:"+result);

//    int e = 1/0;

    return result;
  }

  @Override
  public int sub(int i, int j) {
    int result = i-j;
    System.out.println("方法內部 result:"+result);

    return result;
  }

  @Override
  public int mul(int i, int j) {
    int result = i*j;
    System.out.println("方法內部 result:"+result);

    return result;
  }

  @Override
  public int div(int i, int j) {

    int result = i/j;
    System.out.println("方法內部 result:"+result);

    return result;
  }
}
