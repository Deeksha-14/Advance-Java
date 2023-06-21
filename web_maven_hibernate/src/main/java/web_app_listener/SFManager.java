package web_app_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static utils.HibernateUtils.getFactory;


/**
 * Application Lifecycle Listener implementation class SFManager
 *
 */
@WebListener ///compulsory annotation
public class SFManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SFManager() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
      System.out.println("in ctx destroyed");
      getFactory().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("in ctx init"); // at startup
      getFactory();//triggers cls loading --static init block -- builds session factory
    }
	
}
