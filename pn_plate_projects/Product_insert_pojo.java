package pn_plate_projects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product_insert_pojo {

    private SimpleStringProperty prodectName = new SimpleStringProperty("");
    private SimpleStringProperty model = new SimpleStringProperty("");
    private SimpleStringProperty size = new SimpleStringProperty("");
    private SimpleDoubleProperty price = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty discount = new SimpleDoubleProperty(0.0);
    private SimpleIntegerProperty openingProduct = new SimpleIntegerProperty(0);

    // ===== Constructor =====
    public Product_insert_pojo(String prodectName, String model, String size,
                               double price, double discount , int openingProduct) {
        this.prodectName.set(prodectName);
        this.model.set(model);
        this.size.set(size);
        this.price.set(price);
        this.discount.set(discount);
        this.openingProduct.set(openingProduct);
    }

    public Product_insert_pojo() {
    }

    // ===== PRODUCT NAME =====
    public SimpleStringProperty prodectNameProperty() {
        return prodectName;
    }

    public String getProdectName() {
        return prodectName.get();
    }

    public void setProdectName(String prodectName) {
        this.prodectName.set(prodectName);
    }

    // ===== MODEL =====
    public SimpleStringProperty modelProperty() {
        return model;
    }

    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    // ===== SIZE =====
    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    // ===== PRICE =====
    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
    
    // ===== DISCOUNT =====
    public SimpleDoubleProperty discountProperty() {
        return discount;
    }

    public double getDiscount() {
        return discount.get();
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    // ===== OPENING PRODUCT =====
    public SimpleIntegerProperty openingProductProperty() {
        return openingProduct;
    }

    public int getOpeningProduct() {
        return openingProduct.get();
    }

    public void setOpeningProduct(int openingProduct) {
        this.openingProduct.set(openingProduct);
    }
}
