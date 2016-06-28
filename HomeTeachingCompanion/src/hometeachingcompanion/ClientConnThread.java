/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class ClientConnThread implements Runnable {

    // Declare attributes
    Socket socket;
    Scanner inputStream;
    PrintStream outputStream;
    
    // Default Constructor
    public ClientConnThread (Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new Scanner(socket.getInputStream());
        this.outputStream = new PrintStream(socket.getOutputStream());
    }
    
    // Run Method
    @Override
    public void run() {
        boolean done = false;
        String command, data;
        
        while (!done) {
            // Gather information from client
            command = inputStream.nextLine();
            switch(command) {
                case "command1":
                    data = inputStream.nextLine();
                    break;
                case "command2":
                    data = inputStream.nextLine();
                    break;
                case "bye":
                    done = true;
                    this.inputStream.close();
                    this.outputStream.close();
                    try {
                        this.socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientConnThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }
    
}
