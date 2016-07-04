/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Member;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author co075oh
 */
public class MemberControl {
    
    public boolean authMember(String email, String password) {
        String hashedPassword = this.hashPassword(password);
        boolean authenticated = false;
        SessionFactory sessionFactory = hometeachingcompanion.HomeTeachingCompanionSrvr.getSESSION_FACTORY();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (session.createCriteria(Member.class).add( Restrictions.eq("email", email) ).add( Restrictions.eq("password", hashedPassword) ).list().size() == 1) {
                authenticated = true;
            }
        } catch (Exception ex) {
            hometeachingcompanion.htcLogger.log("authMember", ex.getMessage(), "ERR");
        }
        return authenticated;
    }
    
    public String hashPassword(String password) {
        String hashedPassword = "nopassword";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            hometeachingcompanion.htcLogger.log("hashPassword", ex.getMessage(), "ERR");
        }
        return hashedPassword;
    }
    
}
