/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Families;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author co075oh
 */
public class FamiliesController {
    
    public boolean addFamily(SessionFactory sessionFactory, Families family) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(family);
        session.getTransaction().commit();
        session.close();
        return false;
    }
    
    public boolean updateFamily(SessionFactory sessionFactory, Families family) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(family);
        session.getTransaction().commit();
        return false;
    }
    
    public boolean deleteFamily(SessionFactory sessionFactory, Families family) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(family);
        session.getTransaction().commit();
        return false;
    }
    
    public ArrayList<Families> viewFamilies(SessionFactory sessionFactory, String search) {
        Session session = sessionFactory.openSession();
        ArrayList<Families> families = new ArrayList<>();
        session.beginTransaction();
        session.delete(search);  //Need to change this to get the full list of families in an ArrayList
        session.getTransaction().commit();
        return families;
    }
    
    public void displayFamily(Families family) {
        System.out.println("Family");
        System.out.println("-----------------------");
        System.out.println("Name: " + family.getFamilyName());
        System.out.println("Address: " + family.getAddress());
        System.out.println("City: " + family.getCity());
        System.out.println("State: " + family.getSt());
        System.out.println("Zip: " + family.getZip());
    }
}
