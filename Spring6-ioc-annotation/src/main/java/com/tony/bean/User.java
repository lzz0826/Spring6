package com.tony.bean;


import org.springframework.stereotype.Component;

@Component(value = "user") // value 自訂名(預設名User(全小寫))  @Component相當於xml的 <bean id ="" class=""...>
public class User {
}
