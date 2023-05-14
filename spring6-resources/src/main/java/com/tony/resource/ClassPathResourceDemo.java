package com.tony.resource;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;


//訪問類路徑下資源(resources路徑下)
public class ClassPathResourceDemo {

  //  classpath:：從classpath中獲取資源，通常用於獲取class文件和配置文件。
//  file:：從文件系統中獲取資源，可以是絕對路徑，也可以是相對路徑。
//  http: 和 https:：從Web服務器上獲取資源，通常用於獲取遠程文件。
//  ftp: 和 ftps:：通過FTP協議從FTP服務器上獲取資源。
//  jar: 和 war:：從jar或war包中獲取資源，通常用於獲取類或資源文件。


  public static void loadClasspathResource(String path) throws IOException {

    //創建對象ClassPathResource
    ClassPathResource resource = new ClassPathResource(path);
    System.out.println(resource.getFilename());
    System.out.println(resource.getDescription());
    InputStream inputStream = resource.getInputStream();

    //獲取文件內容
    byte[] bytes = new byte[1024];
    StringBuilder builder = new StringBuilder();
    int index;
    while ((index = inputStream.read(bytes)) != -1){
      builder.append(new String(bytes , 0 ,index));
    }
    System.out.println(builder);


    
  }

  public static void main(String[] args) throws IOException {
    loadClasspathResource("test99.txt");
  }


}
