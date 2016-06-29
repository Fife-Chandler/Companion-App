package Control;


import Model.Log;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Koop
 */
public class LogController {
    
    public boolean addLog(SessionFactory sessionFactory, Log) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(Log);
            session.getTransaction().commit();
        }
        return false;
    }
    
     public boolean updateLog(SessionFactory sessionFactory, Log) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(Log);
            session.getTransaction().commit();
        }
        return false;
    }
     
    public boolean deleteLog(SessionFactory sessionFactory, Log) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(Log);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public List<Log> viewLog(SessionFactory sessionFactory) {
        List<Log> Log;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Log = session.createCriteria(Log.class).list();
        }
        return Log;
    }
    
}