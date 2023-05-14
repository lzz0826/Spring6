package com.tony.resource;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.FileSystemResource;

//訪問系統資源
public class FileSystemResourceDemo {

  //  classpath:：從classpath中獲取資源，通常用於獲取class文件和配置文件。
//  file:：從文件系統中獲取資源，可以是絕對路徑，也可以是相對路徑。
//  http: 和 https:：從Web服務器上獲取資源，通常用於獲取遠程文件。
//  ftp: 和 ftps:：通過FTP協議從FTP服務器上獲取資源。
//  jar: 和 war:：從jar或war包中獲取資源，通常用於獲取類或資源文件。

  public static void loadFileResource(String path) throws IOException {

    //創建對象
    FileSystemResource resource = new FileSystemResource(path);

    System.out.println(resource.getFilename());
    System.out.println(resource.getDescription());

    InputStream inputStream = resource.getInputStream();

    byte[] b = new byte[1024];
    int length;
    StringBuilder builder = new StringBuilder();
    while ((length = inputStream.read(b)) != -1){
      builder.append(new String(b,0,length));
    }
    String content = builder.toString();
    System.out.println(content);

  }

  public static void main(String[] args) throws IOException {
    //絕對路徑
//    loadFileResource("/Users/sai/Desktop/加班.txt");
    //相對路徑讀取主模塊路徑下
    loadFileResource("加班.txt");


  }

}
