package com.tony.di.ditest;

import java.util.ArrayList;
import java.util.List;


//部門類
public class Dept {

    //一個部門有很多員工
    private List<Emp> empList ;
    private String dname;


    public void info(){

        System.out.println("部門名:"+ dname);
    }


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
        for(Emp emp : empList){
            System.out.println(emp.getEname());
        }
    }

    @Override
    public String toString() {
        return "Dept{" +
                "empList=" + empList +
                ", dname='" + dname + '\'' +
                '}';
    }
}
