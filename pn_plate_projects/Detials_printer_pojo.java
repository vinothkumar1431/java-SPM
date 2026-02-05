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
public class Detials_printer_pojo {
    
    private int serial;
    private String billid;
    private double totalamount;
    private double paidamount;
    private double balancesamount;
    private String date;
    private String time;

    public Detials_printer_pojo(int serial, String billid, double totalamount, double paidamount, double balancesamount, String date, String time) {
        this.serial = serial;
        this.billid = billid;
        this.totalamount = totalamount;
        this.paidamount = paidamount;
        this.balancesamount = balancesamount;
        this.date = date;
        this.time = time;
    }

    public Detials_printer_pojo() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String  getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public double getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(double paidamount) {
        this.paidamount = paidamount;
    }

    public double getBalancesamount() {
        return balancesamount;
    }

    public void setBalancesamount(double balancesamount) {
        this.balancesamount = balancesamount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
}
