package nl.zeeuw.util;

import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Pieter
 * 
 * @date 18 sep. 2014
 */



public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml   
            
            Configuration config = new Configuration ();
            config.configure();
            config.addAnnotatedClass(Boek.class);
            config.addAnnotatedClass(Persoon.class);
            
            ServiceRegistry registry = new StandardServiceRegistryBuilder()
            	.applySettings(config.getProperties())
            	.build();
            
            
            return config.buildSessionFactory(registry);
            /*
            SessionFactory sf = new AnnotationConfiguration ().configure()
        	    .addAnnotatedClass(Boek.class)
        	    .addAnnotatedClass(Persoon.class)
        	    .buildSessionFactory();
        	   */
            //return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
