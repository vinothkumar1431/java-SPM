/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;
   import javafx.beans.property.*;

/**
 *
 * @author vinot
 */
public class Items {
    


    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();

    public Items(String name, int qty, double price) {
        this.name.set(name);
        this.qty.set(qty);
        this.price.set(price);
    }

    public StringProperty nameProperty() { return name; }
    public IntegerProperty qtyProperty() { return qty; }
    public DoubleProperty priceProperty() { return price; }

    public String getName() { return name.get(); }
    public int getQty() { return qty.get(); }
    public double getPrice() { return price.get(); }

    public void setName(String v) { name.set(v); }
    public void setQty(int v) { qty.set(v); }
    public void setPrice(double v) { price.set(v); }
}
    

