/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;

/**
 *
 * @author MINIMONIE
 */
public class Notification {

    private int id;
    private Timestamp notificationDate;
    private String status;
    private String discription;
    private int debtdetails_id;
    private int debtdetails_debtor_id;
     private int debtdetails_debtor_account_id;

    public Notification() {
    }

    public Notification(int id, Timestamp notificationDate, String status, String discription, int debtdetails_id, int debtdetails_debtor_id, int debtdetails_debtor_account_id) {
        this.id = id;
        this.notificationDate = notificationDate;
        this.status = status;
        this.discription = discription;
        this.debtdetails_id = debtdetails_id;
        this.debtdetails_debtor_id = debtdetails_debtor_id;
        this.debtdetails_debtor_account_id = debtdetails_debtor_account_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Timestamp notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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

    public int getDebtdetails_debtor_account_id() {
        return debtdetails_debtor_account_id;
    }

    public void setDebtdetails_debtor_account_id(int debtdetails_debtor_account_id) {
        this.debtdetails_debtor_account_id = debtdetails_debtor_account_id;
    }

   
}
