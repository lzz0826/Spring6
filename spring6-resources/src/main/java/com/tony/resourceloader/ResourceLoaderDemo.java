package com.tony.resourceloader;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoaderDemo {

//  classpath:：從classpath中獲取資源，通常用於獲取class文件和配置文件。
//  file:：從文件系統中獲取資源，可以是絕對路徑，也可以是相對路徑。
//  http: 和 https:：從Web服務器上獲取資源，通常用於獲取遠程文件。
//  ftp: 和 ftps:：通過FTP協議從FTP服務器上獲取資源。
//  jar: 和 war:：從jar或war包中獲取資源，通常用於獲取類或資源文件。


  @Test
  public void testClassPathXmlApplicationContext() throws IOException {

    //訪問類路徑下資源(resources路徑下)
    ApplicationContext context = new ClassPathXmlApplicationContext();
    Resource resource = context.getResource("tt.txt");

    System.out.println(resource.exists());
    InputStream inputStream = resource.getInputStream();

    byte[] b = new byte[1024];
    int length;
    StringBuilder builder = new StringBuilder();

    while ((length = inputStream.read(b)) != -1){
      builder.append(new String(b , 0 ,length));
    }
    String s = builder.toString();

    System.out.println(s);

  }



  @Test
  public void test() throws IOException {

    ApplicationContext context = new FileSystemXmlApplicationContext();
//    絕對路徑
//    Resource resource = context.getResource("file:/Users/sai/Desktop/加班.txt");

    //相對路徑讀取主模塊路徑下classpath(resources路徑下)
//    Resource resource = context.getResource("classpath:test99.txt");

    //前綴 https:
    Resource resource = context.getResource("https://www.youtube.com/");

    System.out.println(resource.exists());

    InputStream inputStream = resource.getInputStream();

    byte[] bytes = new byte[1024];
    int l ;

    StringBuilder builder = new StringBuilder();

    while ((l=inputStream.read(bytes)) != -1){
      builder.append(new String(bytes,0,l));
    }

    String s = builder.toString();
    System.out.println(s);

  }

}
