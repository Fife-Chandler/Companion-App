/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tabitha
 */
public class Companionship {
    private double id;
    private String elderOne;
    private String elderTwo;
    private double districtId; 

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
