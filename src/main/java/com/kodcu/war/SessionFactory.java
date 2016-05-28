package com.kodcu.war;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by usta on 28.05.2016.
 */
public class SessionFactory {

    @Produces
    @ApplicationScoped
    public Session session() {

        Configuration configure = new AnnotationConfiguration().configure();
        org.hibernate.SessionFactory sessionFactory = configure.buildSessionFactory();
        org.hibernate.classic.Session session = sessionFactory.openSession();
        return session;
    }
}
