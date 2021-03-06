package anime.parser.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil() {}

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ExceptionInInitializerError();
        }
    }

    public static void sessionFactoryClean() {
        sessionFactory.close();
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}
