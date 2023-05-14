package com.tony.bean;

import com.tony.anno.Bean;
import com.tony.anno.Di;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AnnotationApplicationContext implements ApplicationContext {

  //創建map集合 放bean對象
  private Map<Class, Object> beanFactory = new HashMap<>();

  private static String rootPath;

  @Override
  public Object getBean(Class clazz) {
    return beanFactory.get(clazz);
  }

  //創建有參構造 傳遞包路徑 設置包掃描規則
  //當前包及其子包 哪個類@Bean註解 把這類通過反側實例化
  public AnnotationApplicationContext(String beanPackage) throws Exception {
    //com.tony

    try {
      //1 把.換成\
      String packagePath = beanPackage.replaceAll("\\.", "\\/");
      //2 獲取包絕對路徑
      Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
          .getResources(packagePath);
      System.out.println(urls.hasMoreElements());
      while (urls.hasMoreElements()) {
        URL url = urls.nextElement();
        String filePath = URLDecoder.decode(url.getFile(), "utf-8");
        System.out.println(filePath);
        rootPath = filePath.substring(0, filePath.length() - packagePath.length());
        //掃描包
        loadBean(new File(filePath));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //屬性注入
    loadDi();

  }

  //包掃描過程 實例化
  private void loadBean(File file)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

      //1 判斷當前是否文件夾
      if(file.isDirectory()) {
        //2 獲取文件夾裡面所有內容
        File[] childrenFiles = file.listFiles();

        //3 判斷文件夾裡面為空 直接反回
        if(childrenFiles == null || childrenFiles.length == 0){
          return;
        }else {
          //4 如果文件夾裡不為空 遍歷文件夾所有內容
          for (File child : childrenFiles) {
            //4.1 遍歷得到每個File對象 繼續判斷 如果是文件 遞歸
            if(child.isDirectory()){
              //遞歸
              loadBean(child);
            }else {
              //4.2  遍歷得到每File對象不是文件夾 是文件
              //4.3 得到包路徑+類名稱部份-字符串擷取
              String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

              //4.4 判斷當前文件類型是否.class
              if(pathWithClass.contains(".class")){
                //4.5 如果是.class類型 把路徑\替換成. 把class去掉
                // com.tony.service.UserServiceImpl
                String allName = pathWithClass.replaceAll("\\/", "\\.").replace(".class", "");
                //4.6 判斷類上面是否有註解@Bean 如果有實例化過程
                //4.6.1 獲取類的Class
                Class clazz = Class.forName(allName.substring(1));

                //4.6.2 判斷不是街口
                if (!clazz.isInterface()) {
                  //4.6.3 判斷類上面是否有註解 @Bean
                  Bean annotation = (Bean) clazz.getAnnotation(Bean.class);
                  if(annotation != null){
                    //4.6.4 實例化
                    Object instance = clazz.getConstructor().newInstance();

                    //4.7 把對象實例化之後 放到map集合beanFactory
                    //4.7.1 判斷當前類如果有街口 讓街口class作為map 的 key
                    if(clazz.getInterfaces().length>0){
                      beanFactory.put(clazz.getInterfaces()[0],instance);
                    }else {
                      beanFactory.put(clazz,instance);

                    }

                  }
                }
              }
            }
          }
        }
      }
  }

  public void loadDi()
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    //實例化對象在beanFactory的map集合裡面
    //1.遍歷beanFactory的map集合
    for (Entry<Class, Object> classObjectEntry : beanFactory.entrySet()) {
      //2.遍歷得到每個對象屬性數組 得到每個屬性
      Object obj = classObjectEntry.getValue();
      Class<?> aClass = obj.getClass();
      //3.遍歷得到每個對象數組 得到屬性
      Field[] declaredFields = aClass.getDeclaredFields();
      for (Field dField : declaredFields) {
        //4.判斷屬性上面是否有@Di註解
        Di annotation = dField.getAnnotation(Di.class);
        if(annotation !=null){
          //可以讀取private
          dField.setAccessible(true);
          //5.如果有@Di註解 把對象進行設置(注入)
          //obj : 對象  beanFactory.get(dField.getType()):通過類型 重beanFactory取得對象
          dField.set(obj,beanFactory.get(dField.getType()));

        }

      }





    }






  }


}
