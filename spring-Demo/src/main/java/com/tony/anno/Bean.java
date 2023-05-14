package com.tony.anno;


import org.springframework.stereotype.Repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//作用範圍
@Target(ElementType.TYPE)
//        TYPE：用於聲明類、接口或enum定義
//        FIELD：用於聲明類中的字段
//        METHOD：用於聲明方法
//        PARAMETER：用於聲明方法的參數
//        CONSTRUCTOR：用於聲明構造方法
//        LOCAL_VARIABLE：用於聲明局部變量
//        ANNOTATION_TYPE：用於聲明注解
//        PACKAGE：用於聲明包
//運行時生效
@Retention(RetentionPolicy.RUNTIME)
//        SOURCE：注解只在源代码中保留，编译器编译时直接丢弃该注解，不会保留到运行时。
//        CLASS：注解在编译时会被保留到.class文件中，但是在运行时会被 JVM 忽略掉。这是默认的注解保留策略。
//        RUNTIME：注解在编译时会被保留到.class文件中，并且在运行时会被 JVM 保留，可以通过反射机制读取该注解的信息。
public @interface Bean {
}
