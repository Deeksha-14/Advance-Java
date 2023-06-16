package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory; //singleton, immutable, inherently thread safe object created one per database; to provide the seesion...session provider
	static {
		System.out.println("in static init block");
		factory = new Configuration().configure().buildSessionFactory();
		//empty config
		//reads props n mapping from hibernate.cfg.xml
		//building SF
		
		
				
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
	
	
}
