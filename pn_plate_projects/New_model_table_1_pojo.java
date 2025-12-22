package pn_plate_projects;

public class New_model_table_1_pojo {

    private int serial;
    private String product_name;
    private String product_model;
    private String product_size;
    private int qty;
    private double discount;
    private double price;
    private double amount;

    public New_model_table_1_pojo(int serial, String product_name,
            String product_model, String product_size,
            int qty, double discount, double price, double amount) {

        this.serial = serial;
        this.product_name = product_name;
        this.product_model = product_model;
        this.product_size = product_size;
        this.qty = qty;
        this.discount = discount;
        this.price = price;
        this.amount = amount;
    }

    public int getSerial() {
        return serial;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_model() {
        return product_model;
    }

    public String getProduct_size() {
        return product_size;
    }

    public int getQty() {
        return qty;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }
}

