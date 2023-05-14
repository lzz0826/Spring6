import com.tony.bean.AnnotationApplicationContext;
import com.tony.bean.ApplicationContext;
import com.tony.server.UserServer;

public class TestUser {

  public static void main(String[] args) throws Exception {

    ApplicationContext applicationContext = new AnnotationApplicationContext("com.tony");

    UserServer userServer = (UserServer) applicationContext.getBean(UserServer.class);

    System.out.println(userServer);

    userServer.add();

  }

}
