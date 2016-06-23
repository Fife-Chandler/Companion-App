/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import Control.FamiliesController;
import Model.Families;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class HomeTeachingCompanion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // Test FamiliesController
        Families testFamily = new Families(1, "Smith", "50 N West Temple", "Salt Lake City", "Utah", "84150");
        FamiliesController familiesController = new FamiliesController();
        familiesController.displayFamily(testFamily);
        familiesController.addFamily(sessionFactory, testFamily);
        
        sessionFactory.close();
        
    }
    
}
