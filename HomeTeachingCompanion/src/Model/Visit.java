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
public class Visit {
    
    // Declare attributes
    private Integer id;
    private String date;
    private Integer familyID;
    private Integer companionshipID;
    private String notes;
    
    // Constructor Method
    public Visit(Integer id, String date, Integer familyID, Integer companionshipID, String notes) {
        this.id = id;
        this.date = date;
        this.familyID = familyID;
        this.companionshipID = companionshipID;
        this.notes = notes;
    }
    
    // Getter and Setter Methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public Integer getCompanionshipID() {
        return companionshipID;
    }

    public void setCompanionshipID(Integer companionshipID) {
        this.companionshipID = companionshipID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
