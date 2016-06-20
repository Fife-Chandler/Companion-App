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
public class Companionship {
    
    // Declare attributes
    private double id;
    private String elderOne;
    private String elderTwo;
    private double districtId; 

    // Constructor Method
    public Companionship(double id, String elderOne, String elderTwo, double districtId) {
        this.id = id;
        this.elderOne = elderOne;
        this.elderTwo = elderTwo;
        this.districtId = districtId;
    }
    
    // Getter and Setter Methods
    public double getId() {
        return id;
    }

    public String getElderOne() {
        return elderOne;
    }

    public String getElderTwo() {
        return elderTwo;
    }

    public double getDistrictId() {
        return districtId;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setElderOne(String elderOne) {
        this.elderOne = elderOne;
    }

    public void setElderTwo(String elderTwo) {
        this.elderTwo = elderTwo;
    }

    public void setDistrictId(double districtId) {
        this.districtId = districtId;
    }
}
