package pn_plate_projects;

import javafx.beans.property.*;

public class Item {


    private final StringProperty name = new SimpleStringProperty("");
    private final IntegerProperty qty = new SimpleIntegerProperty(0);
    private final DoubleProperty price = new SimpleDoubleProperty(0.0);

    public Item() {}

    public Item(String name, int qty, double price) {
        this.name.set(name);
        this.qty.set(qty);
        this.price.set(price);
    }

    // NAME
    public StringProperty nameProperty() {
        return name; }
    public String getName() { 
        return name.get(); }
    public void setName(String name) {
        this.name.set(name); }

    // QTY
    public IntegerProperty qtyProperty() { return qty; }
    public int getQty() { return qty.get(); }
    public void setQty(int qty) { this.qty.set(qty); }

    // PRICE
    public DoubleProperty priceProperty() { return price; }
    public double getPrice() { return price.get(); }
    public void setPrice(double price) { this.price.set(price); }
}
