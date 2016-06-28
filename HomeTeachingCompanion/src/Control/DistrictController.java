/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.District;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Brendon Moore
 */
public class DistrictController {
    
    public boolean addDistrict(SessionFactory sessionFactory, District district) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(district);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public boolean updateDistrict(SessionFactory sessionFactory, District district) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(district);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public boolean deleteDistrict(SessionFactory sessionFactory, District district) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(district);
            session.getTransaction().commit();
        }
        return false;
    }
    
    public List<District> viewDistrict(SessionFactory sessionFactory) {
        List<District> district;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            district = session.createCriteria(District.class).list();
        }
        return district;
    }
    
}
