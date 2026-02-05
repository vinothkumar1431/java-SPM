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
public class Admin_Product_Updat_pojo {
    
    private int serial;
    private String productName;
    private String ProductModel;
    private String ProductSize;
    private double price;
    private double Discount;
    private int OpeningStock;
    private String Date;
    private String Time;

    public Admin_Product_Updat_pojo(int serial, String productName, String ProductModel, String ProductSize, double price, double Discount, int OpeningStock, String Date, String Time) {
        this.serial = serial;
        this.productName = productName;
        this.ProductModel = ProductModel;
        this.ProductSize = ProductSize;
        this.price = price;
        this.Discount = Discount;
        this.OpeningStock = OpeningStock;
        this.Date = Date;
        this.Time = Time;
    }

    public Admin_Product_Updat_pojo() {
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

    public String getProductModel() {
        return ProductModel;
    }

    public void setProductModel(String ProductModel) {
        this.ProductModel = ProductModel;
    }

    public String getProductSize() {
        return ProductSize;
    }

    public void setProductSize(String ProductSize) {
        this.ProductSize = ProductSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
