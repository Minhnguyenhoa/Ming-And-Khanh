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
public class DebtDetail {
    private int id;
    private String description;
    private boolean deptType;
    private double amount;
    private String image;
    private Timestamp creatAt;
    private String qr;
    private int debtor_id;
    private int interest_rate_id;

    public DebtDetail() {
    }

    public DebtDetail(int id, String description, boolean deptType, double amount, String image, Timestamp creatAt, String qr, int debtor_id, int interest_rate_id) {
        this.id = id;
        this.description = description;
        this.deptType = deptType;
        this.amount = amount;
        this.image = image;
        this.creatAt = creatAt;
        this.qr = qr;
        this.debtor_id = debtor_id;
        this.interest_rate_id = interest_rate_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeptType() {
        return deptType;
    }

    public void setDeptType(boolean deptType) {
        this.deptType = deptType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Timestamp creatAt) {
        this.creatAt = creatAt;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public int getDebtor_id() {
        return debtor_id;
    }

    public void setDebtor_id(int debtor_id) {
        this.debtor_id = debtor_id;
    }

    public int getInterest_rate_id() {
        return interest_rate_id;
    }

    public void setInterest_rate_id(int interest_rate_id) {
        this.interest_rate_id = interest_rate_id;
    }

    
    
}
