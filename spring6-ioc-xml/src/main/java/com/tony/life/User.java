package com.tony.life;

public class User {

    private String name;


    private User(){

        System.out.println("1 bean對象創建,調用無參構造....");
    }

    public void setName(String name) {
        this.name = name;

        System.out.println("2 給bean對象設置屬性值");
    }
    //初始化方法
    public void initMethod(){
        System.out.println("4 bean對象初始化,調用指定的初始化方法");
    }

    //銷毀方法
    public void destroyMethod(){
        System.out.println("7 bean對象銷毀,調用指定的銷毀方法");

    }



}
