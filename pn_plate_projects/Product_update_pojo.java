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
public class Product_update_pojo {
    
    private int serial;
    private String productName;
    private String Model;
    private String Size;
    private double Price;
    private String Date;
    private String Time;

    public Product_update_pojo(int serial, String productName, String Model, String Size, double Price, String Date, String Time) {
        this.serial = serial;
        this.productName = productName;
        this.Model = Model;
        this.Size = Size;
        this.Price = Price;
        this.Date = Date;
        this.Time = Time;
    }

    public Product_update_pojo() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
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
    
    
    
}
