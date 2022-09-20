package DB;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartApp implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("The Application started");
        DbWork.getConnection();
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The Application stopped");
        DbWork.close();
    }

}
