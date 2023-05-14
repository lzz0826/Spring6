package com.tony;

//基本計算機功能
public class CalculatorStaticProxy implements Calculator {

  //被代理目標對象通過構造傳遞過來

  private Calculator calculator;

  private CalculatorImpl calculatorImpl;

  public CalculatorStaticProxy(Calculator calculator){
    this.calculator = calculator;
  }

  @Override
  public int add(int i, int j) {

    System.out.println("[日誌]:add 方法開始了,參數是:"+i+","+j );

    //調用目標對象的方法 實現核心業務
    int result = calculator.add(i,j);


    System.out.println("[日誌]:add 方法結束了,結果是:"+i+","+j );


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
