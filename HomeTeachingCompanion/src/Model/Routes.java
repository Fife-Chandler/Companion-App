/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author brendon
 */
public class Routes {

    
    // Declare attributes
    
    private Integer id;
    private Integer companionshipID;
    private Integer familyID;
    
    
    // Constructor Method
    
    public Routes(Integer id, Integer companionshipID, Integer familyID) {
        this.id = id;
        this.companionshipID = companionshipID;
        this.familyID = familyID;
    }
    
    // Getter and Setter Methods
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanionshipid() {
        return companionshipID;
    }

    public void setCompanionshipid(Integer companionshipID) {
        this.companionshipID = companionshipID;
    }

    public Integer getFamilyid() {
        return familyID;
    }
    
    public void setFamilyid(Integer familyID) {
        this.familyID = familyID;
    }
}
