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
public class Admin_Product_Deteing_pojo {
    
    private int Serial;
    private String ProductName;
    private String PriductModel;
    private String ProductSize;
    private double Price;
    private double Discount;
    private int OpeningStock;
    private String Date;
    private String Time;

    public Admin_Product_Deteing_pojo(int Serial, String ProductName, String PriductModel, String ProductSize, double Price, double Discount, int OpeningStock, String Date, String Time) {
        this.Serial = Serial;
        this.ProductName = ProductName;
        this.PriductModel = PriductModel;
        this.ProductSize = ProductSize;
        this.Price = Price;
        this.Discount = Discount;
        this.OpeningStock = OpeningStock;
        this.Date = Date;
        this.Time = Time;
    }

    public Admin_Product_Deteing_pojo() {
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

    public String getPriductModel() {
        return PriductModel;
    }

    public void setPriductModel(String PriductModel) {
        this.PriductModel = PriductModel;
    }

    public String getProductSize() {
        return ProductSize;
    }

    public void setProductSize(String ProductSize) {
        this.ProductSize = ProductSize;
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

    public int getOpeningStock() {
        return OpeningStock;
    }

    public void setOpeningStock(int OpeningStock) {
        this.OpeningStock = OpeningStock;
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
