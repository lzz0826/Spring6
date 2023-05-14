package com.tony.di.ditest;


import java.sql.SQLOutput;
import java.util.Arrays;

//員工類
public class Emp {

    //員工屬於某個部門 對象類型屬性
    private Dept dept;

    private String ename;

    private int age;

    //愛好 數組
    private String[] lives;


    public void work (){
        System.out.println(ename+" work..." + age);
        dept.info();
        System.out.println(Arrays.toString(lives));
    }




    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getLives() {
        return lives;
    }

    public void setLives(String[] lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", lives=" + Arrays.toString(lives) +
                '}';
    }
}
