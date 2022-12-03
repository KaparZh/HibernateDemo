package org.kaparzh.hibernatedemo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();


    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
