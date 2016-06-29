package Control;


import Model.Visit;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Koop
 */
public class VisitsController {
    
    public boolean addVisit(SessionFactory sessionFactory, Visit visit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(visit);
            session.getTransaction().commit();
        }
        return false;
    }
    
     public boolean updateVisit(SessionFactory sessionFactory, Visit visit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(visit);
            session.getTransaction().commit();
        }
        return false;
    }
     
    public boolean deleteVisit(SessionFactory sessionFactory, Visit visit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(visit);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public List<Visit> viewVisits(SessionFactory sessionFactory) {
        List<Visit> Log;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Log = session.createCriteria(Visit.class).list();
        }
        return Log;
    }
    
}