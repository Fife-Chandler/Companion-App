/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.google.gson.Gson;
import Model.Companionship;
import com.google.gson.reflect.TypeToken;
import hometeachingcompanion.HomeTeachingCompanionSrvr;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koop
 */
public class ClientCompanionshipControl {
    
    public void createCompanionship(int id, String firstName, String middleName, String lastName, String gender, String phone, String dob, String email, boolean hoh, int familyID) {
        Companionship companionship = new Companionship(id, firstName, middleName, lastName, gender, phone, dob, email, hoh, familyID);
        
        Gson companionshipsGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("createCompanionship");
            outputStream.println(companionshipsGSON.toJson(companionship));
        } catch (IOException ex) {
            Logger.getLogger(ClientCompanionshipControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Companionship retrieveCompanionship(int id) {
        Companionship companionship = null;
        String companionshipJSON;
        Gson companionshipGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveCompanionship");
            outputStream.println(id);
            companionshipJSON = inputStream.nextLine();
            companionship = companionshipGSON.fromJson(companionshipJSON, new TypeToken<List<Companionship>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientCompanionshipControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return companionship;
    }
    
    public List<Companionship> retrieveAllCompanionships() {
        List<Companionship> allCompanionships = null;
        String allCompanionshipsJSON;
        Gson allCompanionshipsGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveAllCompanionships");
            allCompanionshipsJSON = inputStream.nextLine();
            allCompanionships = allCompanionshipsGSON.fromJson(allCompanionshipsJSON, new TypeToken<List<Companionship>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientCompanionshipControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCompanionships;
    }
    
    public void updateCompanionship(Companionship companionship) {
        Gson companionshipsGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("updateCompanionship");
            outputStream.println(companionshipsGSON.toJson(companionship));
        } catch (IOException ex) {
            Logger.getLogger(ClientCompanionshipControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCompanionship(Companionship companionship) {
        Gson companionshipsGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("deleteCompanionship");
            outputStream.println(companionshipsGSON.toJson(companionship));
        } catch (IOException ex) {
            Logger.getLogger(ClientCompanionshipControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}