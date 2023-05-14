package com.tony.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import org.springframework.core.io.UrlResource;

public class UrlResourceDemo {

  //  classpath:：從classpath中獲取資源，通常用於獲取class文件和配置文件。
//  file:：從文件系統中獲取資源，可以是絕對路徑，也可以是相對路徑。
//  http: 和 https:：從Web服務器上獲取資源，通常用於獲取遠程文件。
//  ftp: 和 ftps:：通過FTP協議從FTP服務器上獲取資源。
//  jar: 和 war:：從jar或war包中獲取資源，通常用於獲取類或資源文件。


  //訪問前綴http.file
//  1. usage
  public static void loadUrlResource(String path) throws IOException {
    //創建Resource實現類的對象 UrlResource
    UrlResource url = new UrlResource(path);
    //獲取資源訊息
    System.out.println(url.getFilename());
    System.out.println(url.getURL());
    System.out.println(url.getDescription());
    System.out.println(url.getInputStream().read());

    //內容字串
    InputStream inputStream = url.getInputStream();
    byte[] buffer = new byte[1024];
    int length;
    StringBuilder sb = new StringBuilder();
    while ((length = inputStream.read(buffer)) != -1) {
      sb.append(new String(buffer, 0, length));
    }
    String content = sb.toString();
    System.out.println(content);

  }

  public static void main(String[] args) throws IOException {

    //Http 前綴開頭
//    loadUrlResource("https://www.youtube.com/");

    //file 前綴開頭 必須放在根目錄 主模塊目錄下
    loadUrlResource("file:tony.txt");

  }

}
