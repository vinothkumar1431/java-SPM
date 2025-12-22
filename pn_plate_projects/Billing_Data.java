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
public class Billing_Data {

   
    
        
    private String product;
    private String pro_name;
    private String pro_size;
    private int Quntity;
    private double Price;
    private double Discount;
    private double Amount;
    private String date;
    private String time;
    private double totals;

    public Billing_Data(String product, String pro_name, String pro_size, int Quntity, double Price, double Discount, double Amount, String date, String time, double totals) {
        this.product = product;
        this.pro_name = pro_name;
        this.pro_size = pro_size;
        this.Quntity = Quntity;
        this.Price = Price;
        this.Discount = Discount;
        this.Amount = Amount;
        this.date = date;
        this.time = time;
        this.totals = totals;
    }

    public Billing_Data() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_size() {
        return pro_size;
    }

    public void setPro_size(String pro_size) {
        this.pro_size = pro_size;
    }

    public int getQuntity() {
        return Quntity;
    }

    public void setQuntity(int Quntity) {
        this.Quntity = Quntity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
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

    public double getTotals() {
        return totals;
    }

    public void setTotals(double totals) {
        this.totals = totals;
    }
    
    

}