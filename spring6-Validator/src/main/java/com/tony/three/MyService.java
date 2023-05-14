package com.tony.three;


import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {


  public String testMethod(@Nonnull @Valid User user){

    return user.toString();
  }


}
