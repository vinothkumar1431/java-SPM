
package pn_plate_projects;



public class Billing_Model_pojo {
    
    private String name;
    private String model;
    private String size;
    private int quntity;
    private double price;
    private double discount;
    private double amount;
    private String date;
    private String time;
    private double total;
    private String bill;

    public Billing_Model_pojo(String name, String model, String size, int quntity, double price, double discount, double amount, String date, String time, double total, String bill) {
        this.name = name;
        this.model = model;
        this.size = size;
        this.quntity = quntity;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.total = total;
        this.bill = bill;
    }

    public Billing_Model_pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    
    
 

}