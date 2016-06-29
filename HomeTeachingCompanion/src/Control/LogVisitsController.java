/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Model.LogVisits;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Koop
 */
public class LogVisitsController {
    
    public boolean addLogVisits(SessionFactory sessionFactory, Log Visits) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(LogVisits);
            session.getTransaction().commit();
        }
        return false;
    }
    
     public boolean updateLogVisits(SessionFactory sessionFactory, Log Visits) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(LogVisits);
            session.getTransaction().commit();
        }
        return false;
    }
     
    public boolean deleteLogVisits(SessionFactory sessionFactory, Log Visits) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(LogVisits);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public List<LogVisits> viewLogVisits(SessionFactory sessionFactory) {
        List<LogVisits> LogVisits;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            LogVisits = session.createCriteria(LogVisits.class).list();
        }
        return LogVisits;
    }
    
}
    
    

