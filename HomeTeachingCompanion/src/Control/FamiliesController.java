/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Families;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author co075oh
 */
public class FamiliesController {
    
    public boolean addFamily(SessionFactory sessionFactory, Families family) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(family);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public boolean updateFamily(SessionFactory sessionFactory, Families family) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(family);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public boolean deleteFamily(SessionFactory sessionFactory, Families family) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(family);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public List<Families> viewFamilies(SessionFactory sessionFactory) {
        List<Families> families;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            families = session.createCriteria(Families.class).list();
        }
        return families;
    }
    
}
