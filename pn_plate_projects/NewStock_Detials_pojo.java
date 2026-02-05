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
public class NewStock_Detials_pojo {
    
    private int Serial;
    private String ProductName;
    private String Model;
    private String Size;
    private double Price;
    private double Discount;
    private int OldStock;
    private int NewStock;
    private String Date;
    private String Time;

    public NewStock_Detials_pojo(int Serial, String ProductName, String Model, String Size, double Price, double Discount, int OldStock, int NewStock, String Date, String Time) {
        this.Serial = Serial;
        this.ProductName = ProductName;
        this.Model = Model;
        this.Size = Size;
        this.Price = Price;
        this.Discount = Discount;
        this.OldStock = OldStock;
        this.NewStock = NewStock;
        this.Date = Date;
        this.Time = Time;
    }

    public NewStock_Detials_pojo() {
    }

    public int getSerial() {
        return Serial;
    }

    public void setSerial(int Serial) {
        this.Serial = Serial;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
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

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public int getOldStock() {
        return OldStock;
    }

    public void setOldStock(int OldStock) {
        this.OldStock = OldStock;
    }

    public int getNewStock() {
        return NewStock;
    }

    public void setNewStock(int NewStock) {
        this.NewStock = NewStock;
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
