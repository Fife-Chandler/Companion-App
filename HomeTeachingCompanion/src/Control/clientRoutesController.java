/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.google.gson.Gson;
import Model.Route;
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
 * @author co075oh
 */
public class ClientRoutesControl {
    
    public void createRoute(int id, String firstName, String middleName, String lastName, String gender, String phone, String dob, String email, boolean hoh, int familyID) {
        Route Route = new Route(id, firstName, middleName, lastName, gender, phone, dob, email, hoh, familyID);
        
        Gson RoutesGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("createRoute");
            outputStream.println(RoutesGSON.toJson(Route));
        } catch (IOException ex) {
            Logger.getLogger(ClientRoutesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Route retrieveRoute(int id) {
        Route Route = null;
        String RouteJSON;
        Gson RouteGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveRoute");
            outputStream.println(id);
            RouteJSON = inputStream.nextLine();
            Route = RouteGSON.fromJson(RouteJSON, new TypeToken<List<Route>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientRoutesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Route;
    }
    
    public List<Route> retrieveAllRoutes() {
        List<Route> allRoutes = null;
        String allRoutesJSON;
        Gson allRoutesGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveAllRoutes");
            allRoutesJSON = inputStream.nextLine();
            allRoutes = allRoutesGSON.fromJson(allRoutesJSON, new TypeToken<List<Route>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientRoutesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allRoutes;
    }
    
    public void updateRoute(Route Route) {
        Gson RoutesGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("updateRoute");
            outputStream.println(RoutesGSON.toJson(Route));
        } catch (IOException ex) {
            Logger.getLogger(ClientRoutesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteRoute(Route Route) {
        Gson RoutesGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("deleteRoute");
            outputStream.println(RoutesGSON.toJson(Route));
        } catch (IOException ex) {
            Logger.getLogger(ClientRoutesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}