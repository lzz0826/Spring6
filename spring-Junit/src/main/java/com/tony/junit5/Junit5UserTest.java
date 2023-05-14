package com.tony.junit5;



import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class Junit5UserTest {


  @Resource(name = "user")
  private User user1;

  @Test
  public void testUser(){

    System.out.println(user1);
    user1.run();
  }
}
