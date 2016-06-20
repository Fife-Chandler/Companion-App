/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author co075oh
 */
public class District {
    
    // Declare attributes
    private double id;
    private double memberid;

    // Constructor Method
    public District(double id, double memberid) {
        this.id = id;
        this.memberid = memberid;
    }
    
    // Getter and Setter Methods
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getMemberid() {
        return memberid;
    }

    public void setMemberid(double memberid) {
        this.memberid = memberid;
    }
}
