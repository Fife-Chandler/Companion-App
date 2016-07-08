/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class HomeTeachingCompanionSrvr {

    // Declare Executor Service
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    
    // Declare Session Factory
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    
    // Set Server and port variables
    public static final String SERVER = "127.0.0.1";
    public static final int PORT = 7890;
    
    // Declare Log Writter
    private static PrintWriter logFile = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {

            // Create Server Socket
            ServerSocket serverSocket = new ServerSocket(7890);
            
            // Open log file
            String filePath = "log.txt";
            HomeTeachingCompanionSrvr.logFile = new PrintWriter(new FileWriter(filePath, true));
        
            // Log application start time
            htcLogger.log("Application Started", "Server application started and listening on " + serverSocket.getLocalSocketAddress(), "INFO");
            
            // Await client connections
            while (true) {
                Socket socket = serverSocket.accept();
                htcLogger.log("newConnection", "New Connection from " + socket.getRemoteSocketAddress(), "INFO");
                EXECUTOR_SERVICE.submit(new ClientConnThread(socket));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HomeTeachingCompanionSrvr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Getter methods
    public static ExecutorService getEXECUTOR_SERVICE() {
        return EXECUTOR_SERVICE;
    }

    public static SessionFactory getSESSION_FACTORY() {
        return SESSION_FACTORY;
    }
    
    public static PrintWriter getLogFile() {
        return logFile;
    }
    
}
