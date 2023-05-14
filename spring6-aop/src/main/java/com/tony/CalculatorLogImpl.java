package com.tony;

//帶日誌計算機功能
public class CalculatorLogImpl implements Calculator {

  @Override
  public int add(int i, int j) {

    System.out.println("[日誌]:add 方法開始了,參數是:"+i+","+j );
    int result = i+j;
    System.out.println("方法內部 result:"+result);

    System.out.println("[日誌]:add 方法結束了,結果是:"+i+","+j );


    return result;
  }

  @Override
  public int sub(int i, int j) {

    System.out.println("[日誌]:sub 方法開始了,參數是:"+i+","+j );

    int result = i-j;
    System.out.println("方法內部 result:"+result);
    System.out.println("[日誌]:sub 方法結束了,結果是:"+i+","+j );


    return result;
  }

  @Override
  public int mul(int i, int j) {

    System.out.println("[日誌]:mul 方法開始了,參數是:"+i+","+j );

    int result = i*j;
    System.out.println("方法內部 result:"+result);

    System.out.println("[日誌]:mul 方法結束了,結果是:"+i+","+j );


    return result;
  }

  @Override
  public int div(int i, int j) {

    System.out.println("[日誌]:div 方法開始了,參數是:"+i+","+j );

    int result = i/j;
    System.out.println("方法內部 result:"+result);

    System.out.println("[日誌]:div 方法結束了,結果是:"+i+","+j );


    return result;
  }
}
