/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import Control.FamiliesController;
import Model.Families;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class HomeTeachingCompanionSrvr {

    // Declare Executor Service
    private static final int threadCount = 4;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    
    // Declare Session Factory
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        FamiliesController familiesController = new FamiliesController();
        // Test FamiliesController - Add a family
        Families testFamily1 = new Families(1, "Smith", "50 N West Temple", "Salt Lake City", "Utah", "84150");
        familiesController.addFamily(sessionFactory, testFamily1);

        // Test FamiliesController - Update a family
        Families testFamily2 = new Families(6, "Yandle", "953 5th Street South", "New Valdosta", "GA", "31601");
        familiesController.updateFamily(sessionFactory, testFamily2);

        // Test FamiliesController - Delete a family
        Families testFamily3 = new Families(5, "Smith", "187 5th Avenue", "Yonkers", "NY", "10701");
        familiesController.deleteFamily(sessionFactory, testFamily3);

        // Test FamiliesController - View all families
        List families = familiesController.viewFamilies(sessionFactory);
        for (Object family : families) {
            Families currentFamily = (Families) family;
            System.out.println("Family");
            System.out.println("-----------------------");
            System.out.println("Name: " + currentFamily.getFamilyName());
            System.out.println("Address: " + currentFamily.getAddress());
            System.out.println("City: " + currentFamily.getCity());
            System.out.println("State: " + currentFamily.getSt());
            System.out.println("Zip: " + currentFamily.getZip());
            System.out.println("\n");
        }
        
        // Create Server Socket
        ServerSocket serverSocket = new ServerSocket(7890);
        
        // Await client connections
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.submit(new ClientConnThread(socket));
        }
        
    }
    
}
