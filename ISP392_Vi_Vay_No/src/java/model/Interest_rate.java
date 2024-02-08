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
public class Interest_rate {

    private int id;
    private double interestRate;
    private Timestamp dateOfApplication;

    public Interest_rate() {
    }

    public Interest_rate(int id, double interestRate, Timestamp dateOfApplication) {
        this.id = id;
        this.interestRate = interestRate;
        this.dateOfApplication = dateOfApplication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Timestamp getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Timestamp dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

}
