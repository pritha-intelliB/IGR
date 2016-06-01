package com.igr.hibernate.util;



import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.igr.registration.IssueFirstTokenAction;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Logger log = Logger
			.getLogger(HibernateUtil.class);
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure()
                    .buildSessionFactory();
        } catch (Exception ex) {
        	ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}