package com.tony.reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class TestCar {



    //1 獲取Class對象多種方式
    @Test
    public void test01() throws Exception {
//        1 類名.class
        Class carClass1 = Car.class;

//        2 對象.getClass()
        Class carClass2 = new Car().getClass();

//        3 Class.forName("全路徑")
        Class carClass3 = Class.forName("com.tony.reflect.Car");

        //實例化
        Car car = (Car) carClass3.getDeclaredConstructor().newInstance();

        System.out.println(car);
    }

    //2 獲取構造方法
    @Test
    public void test02() throws Exception{
        Class carClass = Car.class;


        //獲取所有構造
        //getConstructors() 獲取所有public構造
//        Constructor[] constructors = carClass.getConstructors();
        //getDeclaredConstructors() 獲取所有構造 包括private

        Constructor[] constructors = carClass.getDeclaredConstructors();
        for(Constructor c : constructors){
            System.out.println("構造名"+c.getName()+"  參數數量:"+c.getParameterCount());
        }


        //指定有參構造創建對象
//        1. 構造public
//        Constructor c1 = carClass.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("te",22,"Red");
//        System.out.println(car1.getAge());


//        2. 構造private
        Constructor c2 = carClass.getDeclaredConstructor(String.class, int.class, String.class);
        //設置允許讀取private
        c2.setAccessible(true);
        Car car2 = (Car) c2.newInstance("gbrg",12,"Black");
        System.out.println(car2.getAge());


    }


    //3 獲取屬性

    @Test
    public void test() throws Exception {

        Class carClass = Car.class;

        Car car = (Car) carClass.getDeclaredConstructor().newInstance();


        //獲取public屬性
        Field[] fields = carClass.getFields();

        //獲取所有屬性(包含 private)
        Field[] declaredFields = carClass.getDeclaredFields();
        for(Field field : declaredFields ){
            if(field.getName().equals("name")){
                //設置允許訪問
                field.setAccessible(true);
                field.set(car,CarEnum.BMW.getName());
            }
            switch (field.getName()){
                case "age" :
                    field.setAccessible(true);
                    field.set(car,CarEnum.BMW.getAge());
                    break;
                case "color" :
                    field.setAccessible(true);
                    field.set(car,CarEnum.BMW.getColor());
                    break;
            }
            System.out.println(field.getName());
            System.out.println(car);
        }
    }

    //4 獲取方法

    @Test
    public void test03() throws Exception{

        //new 一個當前對象
        Car car = new Car("本田",3,"黑");

        //對象使用的class
        Class carClass = car.getClass();

        // public 方法
        Method[] methods = carClass.getMethods();
//        for (Method m : methods){
////            System.out.println(m.getName());
//            //使用方法toString
//            if(m.getName().equals("toString")){
//                //invoke(Object obj, Object... args) (當前的對象,參數)
//                String invoke = (String) m.invoke(car);
//                System.out.println(invoke);
//            }
//
//        }
        //private 方法
        Method[] declaredMethods = carClass.getDeclaredMethods();

        for(Method m2 : declaredMethods){
//            System.out.println(m2.getName());
            // 使用方法 run
            if(m2.getName().equals("run")){
                //允許訪問方法
                m2.setAccessible(true);
                m2.invoke(car);
            }

        }

    }


}

enum CarEnum{

    BMW("X6",4,"Red");

    private String name;

    private int age;

    private String color;


    CarEnum(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}