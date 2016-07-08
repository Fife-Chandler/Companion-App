/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.google.gson.Gson;
import Model.Member;
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
public class ClientMemberControl {
    
    public void createMember(int id, String firstName, String middleName, String lastName, String gender, String phone, String dob, String email, boolean hoh, int familyID) {
        Member member = new Member(id, firstName, middleName, lastName, gender, phone, dob, email, hoh, familyID);
        
        Gson membersGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("createMember");
            outputStream.println(membersGSON.toJson(member));
        } catch (IOException ex) {
            Logger.getLogger(ClientMemberControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Member retrieveMember(int id) {
        Member member = null;
        String memberJSON;
        Gson memberGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveMember");
            outputStream.println(id);
            memberJSON = inputStream.nextLine();
            member = memberGSON.fromJson(memberJSON, new TypeToken<List<Member>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientMemberControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return member;
    }
    
    public List<Member> retrieveAllMembers() {
        List<Member> allMembers = null;
        String allMembersJSON;
        Gson allMembersGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveAllMembers");
            allMembersJSON = inputStream.nextLine();
            allMembers = allMembersGSON.fromJson(allMembersJSON, new TypeToken<List<Member>>(){}.getType());
        } catch (IOException ex) {
            Logger.getLogger(ClientMemberControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMembers;
    }
    
    public void updateMember(Member member) {
        Gson membersGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("updateMember");
            outputStream.println(membersGSON.toJson(member));
        } catch (IOException ex) {
            Logger.getLogger(ClientMemberControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteMember(Member member) {
        Gson membersGSON = new Gson();
        try (Socket socket = new Socket(HomeTeachingCompanionSrvr.SERVER,HomeTeachingCompanionSrvr.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("deleteMember");
            outputStream.println(membersGSON.toJson(member));
        } catch (IOException ex) {
            Logger.getLogger(ClientMemberControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
