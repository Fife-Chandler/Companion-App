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
public class Families {
    
    // Declare attributes
    private Integer id;
    private String familyName;
    private String address;
    private String city;
    private String state;
    private String zip;
    
    // Constructor Method
    public Families(Integer id, String familyName, String address, String city, String state, String zip) {
        this.id = id;
        this.familyName = familyName;
        this.address = address;
        this.city = city;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
