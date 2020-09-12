package by.it.academy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

public class HibernateUtil {
    static Logger log = Logger.getLogger(HibernateUtil.class.getName());


    static StandardServiceRegistry registry;
    static SessionFactory factory;
    static Session session;


    public static Session getSession() {
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (Throwable throwable) {
            log.info(throwable.getLocalizedMessage());
            throw new ExceptionInInitializerError(throwable);
        }
        return factory.openSession();
    }

    public static Session getTestSession() {
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.test.cfg.xml")
                    .build();
            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (Throwable throwable) {
            log.info(throwable.getLocalizedMessage());
            throw new ExceptionInInitializerError(throwable);
        }
        return factory.openSession();
    }

}
