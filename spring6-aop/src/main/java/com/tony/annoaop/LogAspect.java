package com.tony.annoaop;


import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//ioc
@Aspect//切面
public class LogAspect {

  //設置切入點和通知類型
  //切入點表達式 : execution(訪問修飾符 增強方法返回類型 增強方法所在全路徑.方法名稱(方法參數))
  //                         *          *              *            *      (..)  * . 表示任意帶入
  //                                *Server以Server結尾            get*以get開頭
  //通知類型:
  // 前置@Before(value = "切入點表達式配置切入點")
//  @Before(value = "execution(* com.tony.annoaop.*.*(..))")
  @Before(value = "execution(public int com.tony.annoaop.CalculatorImpl.add(int,int))")
  public void before(JoinPoint joinPoint){
    //JoinPoint 切入點詳細內容
    String name = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    System.out.println("LogAspect:前置作業"+"方法名稱"+ name+ "  參數 :"+Arrays.toString(args));

  }

  // 後置@After()
//  @After(value = "execution(* *.add(..))")
  //使用重入
//  @After(value = "com.tony.annoaop.LogAspect.pontCut()")
  @After(value = "pontCut()")
  public void after(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    System.out.println("LogAspect:後置作業"+"方法名稱"+ name);

  }
  // 反回@AfterReturning
  //  returning : 返回結果
  @AfterReturning(value = "execution(public int com.tony.annoaop.CalculatorImpl.add(..))" ,returning = "result")
  public void afterReturning(JoinPoint joinPoint,Object result){
    String name = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    System.out.println("LogAspect:返回作業"+"方法名稱"+ name+ "  參數 :"+Arrays.toString(args)
    +"  result : "+result);


  }
  // 異常@AfterThrowing
  @AfterThrowing(value = "execution(public int com.tony.annoaop.CalculatorImpl.add(..))" ,throwing = "ex")
  public void afterThrowing(JoinPoint joinPoint , Throwable ex){
    String name = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    System.out.println("LogAspect:異常作業"+"方法名稱"+ name+ "  參數 :"+Arrays.toString(args)
    +"異常方法 : "+ ex);


  }
  // 環繞@Around() 包含上面4種方式
  @Around(value = "execution(public int com.tony.annoaop.CalculatorImpl.add(..))")
  // ProceedingJoinPoint : 繼承JoinPoint 方法更多
  public Object around(ProceedingJoinPoint joinPoint){
    Object[] args = joinPoint.getArgs();
    String argString = Arrays.toString(args);
    System.out.println("環繞通知==方法參數 : "+ argString);
    Object proceed = null;

    try {
      System.out.println("環繞通知==目標方法之前執行");
      //調用目標方法
      proceed = joinPoint.proceed();
      System.out.println("環繞通知==目標方法之後執行");
    }catch (Throwable e){
      e.printStackTrace();
      System.out.println("環繞通知==目標方法出現異常執行");

    } finally {
      System.out.println("環繞通知==目標方法執行完畢");

    }

    return proceed;
  }

  //重用切入點表達式
  @Pointcut(value = "execution(public int com.tony.annoaop.CalculatorImpl.add(int,int))")
  public void pontCut(){}





}
