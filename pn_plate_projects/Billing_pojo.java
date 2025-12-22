                                                                                                                                       
package pn_plate_projects;


public class Billing_pojo {
    
    private String product;
    private String pro_name;
    private String pro_size;
    private int quntity;
    private double price;
    private double discount;
    private double amount;
    private String date;
    private String time;
    private double total;

    public Billing_pojo(String product, String pro_name, String pro_size, int quntity, double price, double discount, double amount, String date, String time, double total) {
        this.product = product;
        this.pro_name = pro_name;
        this.pro_size = pro_size;
        this.quntity = quntity;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.total = total;
    }

    public Billing_pojo() {
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
    
    
}