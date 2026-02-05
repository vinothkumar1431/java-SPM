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
public class Deleteing_Bills_view_pojo {
    
    private int Billid;
    private String CastomerName;
    private long MobileNumber;
    private String Date;
    private String Time;
    private double Amount;
    private double PaidAmount;
    private double SubTotal;
    private double Receied;
    private double Total;
    private double Balance;
    private String DeleteingDate;
    private String DeleteingTime;

    public Deleteing_Bills_view_pojo(int Billid, String CastomerName, long MobileNumber, String Date, String Time, double Amount, double PaidAmount, double SubTotal, double Receied, double Total, double Balance, String DeleteingDate, String DeleteingTime) {
        this.Billid = Billid;
        this.CastomerName = CastomerName;
        this.MobileNumber = MobileNumber;
        this.Date = Date;
        this.Time = Time;
        this.Amount = Amount;
        this.PaidAmount = PaidAmount;
        this.SubTotal = SubTotal;
        this.Receied = Receied;
        this.Total = Total;
        this.Balance = Balance;
        this.DeleteingDate = DeleteingDate;
        this.DeleteingTime = DeleteingTime;
    }

    public Deleteing_Bills_view_pojo() {
    }

    public int getBillid() {
        return Billid;
    }

    public void setBillid(int Billid) {
        this.Billid = Billid;
    }

    public String getCastomerName() {
        return CastomerName;
    }

    public void setCastomerName(String CastomerName) {
        this.CastomerName = CastomerName;
    }

    public long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(long MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(double PaidAmount) {
        this.PaidAmount = PaidAmount;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getReceied() {
        return Receied;
    }

    public void setReceied(double Receied) {
        this.Receied = Receied;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getDeleteingDate() {
        return DeleteingDate;
    }

    public void setDeleteingDate(String DeleteingDate) {
        this.DeleteingDate = DeleteingDate;
    }

    public String getDeleteingTime() {
        return DeleteingTime;
    }

    public void setDeleteingTime(String DeleteingTime) {
        this.DeleteingTime = DeleteingTime;
    }
    
    
}
