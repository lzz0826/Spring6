package com.tony.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan("com.tony.three")
public class ValidationConfig {

  @Bean
  public MethodValidationPostProcessor ValidationPostProcessor(){
    return new MethodValidationPostProcessor();

  }


}
