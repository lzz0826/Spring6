package com.tony.server;

import java.lang.reflect.InvocationTargetException;

public interface UserServer {

  public void add()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
