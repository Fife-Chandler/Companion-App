/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author co075oh
 */
@Entity
public class District implements Serializable {
    
    // Declare attributes
    @Id
    private double id;
    @Column (name="memberID")
    private double memberID;

    // Constructor Method
    public District(double id, double memberID) {
        this.id = id;
        this.memberID = memberID;
    }
    
    // Getter and Setter Methods
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getMemberID() {
        return memberID;
    }

    public void setMemberID(double memberID) {
        this.memberID = memberID;
    }
}
