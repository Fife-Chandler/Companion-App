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
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class FamiliesController {
    
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private final Session session = sessionFactory.openSession();
    
    public boolean addFamily(Families family) {
        this.session.beginTransaction();
        this.session.save(family);
        this.session.getTransaction().commit();
        return false;
    }
    
    public boolean updateFamily(Families family) {
        this.session.beginTransaction();
        this.session.update(family);
        this.session.getTransaction().commit();
        return false;
    }
    
    public boolean deleteFamily(Families family) {
        this.session.beginTransaction();
        this.session.delete(family);
        this.session.getTransaction().commit();
        return false;
    }
    
    public ArrayList<Families> viewFamilies(String search) {
        ArrayList<Families> families = new ArrayList<>();
        this.session.beginTransaction();
        this.session.delete(search);  //Need to change this to get the full list of families in an ArrayList
        this.session.getTransaction().commit();
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
