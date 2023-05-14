package com.tony.di;


import org.springframework.core.io.Resource;

public class ResourceBean {


  private Resource resource;


  public Resource getResource() {
    return this.resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }


  public void run(){
    System.out.println(resource.getFilename());
    System.out.println(resource.getDescription());
  }





}
