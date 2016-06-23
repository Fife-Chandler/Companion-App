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
public class Families implements Serializable {
    
    // Declare attributes
    @Id
    private Integer id;
    @Column (name="familyName")
    private String familyName;
    @Column (name="address")
    private String address;
    @Column (name="city")
    private String city;
    @Column (name="st")
    private String st;
    @Column (name="zip")
    private String zip;
    
    // Constructor Methods
    public Families() {
    }
    
    public Families(Integer id, String familyName, String address, String city, String st, String zip) {
        this.id = id;
        this.familyName = familyName;
        this.address = address;
        this.city = city;
        this.st = st;
        this.zip = zip;
    }
    
    // Getter and Setter Methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
