package com.tony.two;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@CacheConfig
@ComponentScan("com.tony.two")
public class ValidationConfig {

  @Bean
  public LocalValidatorFactoryBean getLocalValidatorBean(){
    return new LocalValidatorFactoryBean();
  }

}
