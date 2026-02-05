/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

/**
 *
 * @author vinot
 */
public class Users_Bills_pojo {
    private int serial;
    private String username;
    private String password;
    private int billId;
    private String billingTime;
    private double billingAmount;

    public Users_Bills_pojo(int serial , String username, String password, int billId, String billingTime, double billingAmount) {
        
        this.serial = serial;
        this.username = username;
        this.password = password;
        this.billId = billId;
        this.billingTime = billingTime;
        this.billingAmount = billingAmount;
    }

    public Users_Bills_pojo() {
        
    }
     public int getSerial() {
        return serial;
    }

    public void setSerial(int Serial) {
        this.serial = Serial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(String billingTime) {
        this.billingTime = billingTime;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }
    
    
    
}
