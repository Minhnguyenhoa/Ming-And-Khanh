/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Report {

    private int id;
    private String status;
    private String description;
    private int debtdetails_id;
    private int debtdetails_debtor_id;

    public Report() {
    }

    public Report(int id, String status, String description, int debtdetails_id, int debtdetails_debtor_id) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.debtdetails_id = debtdetails_id;
        this.debtdetails_debtor_id = debtdetails_debtor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDebtdetails_id() {
        return debtdetails_id;
    }

    public void setDebtdetails_id(int debtdetails_id) {
        this.debtdetails_id = debtdetails_id;
    }

    public int getDebtdetails_debtor_id() {
        return debtdetails_debtor_id;
    }

    public void setDebtdetails_debtor_id(int debtdetails_debtor_id) {
        this.debtdetails_debtor_id = debtdetails_debtor_id;
    }
                    
}
