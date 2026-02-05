/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Bills_editController implements Initializable {

    @FXML
    private AnchorPane anger_pane;
    @FXML
    private TextField txt_customername;
    @FXML
    private TextField txt_contactno;
    @FXML
    private TextField txt_date;
    @FXML
    private TextField txt_time;
    @FXML
    private TextField txt_product;
    @FXML
    private TextField txt_model;
    @FXML
    private TextField txt_size;
    @FXML
    private TextField txt_qty;
    @FXML
    private TextField txt_discount;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_amount;
    @FXML
    private TextField txt_subtotal;
    @FXML
    private TextField txt_total;
    @FXML
    private TextField txt_received;
    @FXML
    private TextField txt_paidamount;
    @FXML
    private TextField txt_balance;
    @FXML
    private Rectangle box_top;
    @FXML
    private AnchorPane anchor_center;
    @FXML
    private TextField txt_billid;
    @FXML
    private Button bu_delete;
    @FXML
    private Button bu_enter;
    @FXML
    private Button bu_back;
   
    @FXML
    private Button bu_next; 
    @FXML
    private Button bu_close;
    
    
    @FXML
    private TextField txt_serial;
    @FXML
    private Label label_totalproducat;

    private int billid = 0;
    private int serial_number = 0;
    private int Count_Bill=0;
    
    
Connection conn;
PreparedStatement pss;
ResultSet rss;   
 
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
            // TODO

       
       
    }    

    @FXML
    private void customername(ActionEvent event) {
        
        
    }

    @FXML
    private void contactno(ActionEvent event) {
    }

    @FXML
    private void date(ActionEvent event) {
        
    }

    @FXML
    private void time(ActionEvent event) {
    }

    @FXML
    private void product(ActionEvent event) {
    }

    @FXML
    private void model(ActionEvent event) {
    }

    @FXML
    private void size(ActionEvent event) {
    }

    @FXML
    private void qty(ActionEvent event) {
    }

    @FXML
    private void Discount(ActionEvent event) {
    }

    @FXML
    private void price(ActionEvent event) {
    }

    @FXML
    private void amount(ActionEvent event) {
    }

    @FXML
    private void subtotal(ActionEvent event) {
    }

    @FXML
    private void total(ActionEvent event) {
    }

    @FXML
    private void received(ActionEvent event) {
    }

    @FXML
    private void paidamount(ActionEvent event) {
    }

    @FXML
    private void balance(ActionEvent event) {
    }

    @FXML
    private void billid(ActionEvent event) {
    }
     @FXML
    private void Serial(ActionEvent event) {
    }
      @FXML
    private void close(ActionEvent event)throws Exception{
        
      Parent root = FXMLLoader.load(getClass().getResource("Billing.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }

 @FXML
private void delete(ActionEvent event)throws Exception{
    
  int serial = billid;  
  int bill_ids =Integer.parseInt(txt_billid.getText());
  String customername = txt_customername.getText();
  long customerumber = Long.parseLong(txt_contactno.getText());
  String date =txt_date.getText();
  String time = txt_time.getText();
  String product =txt_product.getText();
  String model = txt_model.getText();
  String size = txt_size.getText();
  int qty = Integer.parseInt(txt_qty.getText());
  double discount = Double.parseDouble(txt_discount.getText());
  double price = Double.parseDouble(txt_price.getText());
  double amount = Double.parseDouble(txt_amount.getText());
  double paidamount = Double.parseDouble(txt_paidamount.getText());
  double subtotal = Double.parseDouble(txt_subtotal.getText());
  double received = Double.parseDouble(txt_received.getText());
  double toala = Double.parseDouble(txt_total.getText());
  double balance = Double.parseDouble(txt_balance.getText());
  LocalTime time1 = LocalTime.now();
        String currentTime =
            time1.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        LocalDate date1 = LocalDate.now();
        String currentDate =
            date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  
  
     DELETEINSERT( bill_ids, customername, customerumber, date, time, product, model, size, qty, discount, price, amount, paidamount, subtotal, received, toala, balance,currentDate,currentTime);
  
  
      
clearFields();
}

public void productdelete()throws Exception{

     String sql = "DELETE FROM rr_table WHERE bill_id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);

        int rows = ps.executeUpdate();
        
    costomer_table_delet();
     
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
private void enter(ActionEvent event) throws Exception {

    String id = txt_billid.getText();
    String number = txt_serial.getText();

    billid = Integer.parseInt(id);

    product_count();
    customer_details();

    // serial number empty check
    if (number != null && !number.isEmpty()) {

        serial_number = Integer.parseInt(number);
        System.out.println("Serial Number: " + serial_number);

        product_selecter();   // serial irundha
    } else {

        loadProductData();    // serial illana
    }
}


    @FXML
private void back(ActionEvent event)throws Exception{

   
        if (rss != null && rss.previous()) {
            showProductFromRS();
            bu_next.setDisable(false); 
       System.out.println("rss " +rss);

        } else {
            System.out.println("First record reached");
        }
    
}



   @FXML
private void next(ActionEvent event) {

    try {
        if (rss != null && rss.next()) {
            showProductFromRS();   
        } else {
            System.out.println("Last record reached");
            bu_next.setDisable(true); 
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
public void customer_details() {

    String sql = "SELECT date, time, customer_name, customer_number, total, sub_total, paid_amount, balance_amount, received " +
                 "FROM bill_amounts WHERE bill_id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                String date = rs.getString("date");
                String time = rs.getString("time");
                String customerName = rs.getString("customer_name");
                long customerNumber = rs.getLong("customer_number");
                double total = rs.getDouble("total");
                double subTotal = rs.getDouble("sub_total");
                double paidAmount = rs.getDouble("paid_amount");
                double balanceAmount = rs.getDouble("balance_amount");
                double received = rs.getDouble("received");

                // Debug
                System.out.println("Customer: " + customerName + " Total: " + total + " Date: " + date);

                // JavaFX UI set
                txt_date.setText(date);
                txt_time.setText(time);
                txt_customername.setText(customerName);
                txt_contactno.setText(String.valueOf(customerNumber));
                txt_total.setText(String.valueOf(total));
                txt_subtotal.setText(String.valueOf(subTotal));
                txt_paidamount.setText(String.valueOf(paidAmount));
                txt_balance.setText(String.valueOf(balanceAmount));
                txt_received.setText(String.valueOf(received));

            } else {
                System.out.println("No bill found for bill_id: " + billid);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

 public void prodact_detials() throws Exception {

    String sql = "SELECT serial_number, product_name, product_model, product_size, " +
                 "qut, discount, price, amount " +
                 "FROM rr_table WHERE bill_id = ? ORDER BY serial_number";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {   

                txt_serial.setText(rs.getString("serial_number"));
                txt_product.setText(rs.getString("product_name"));
                txt_model.setText(rs.getString("product_model"));
                txt_size.setText(rs.getString("product_size"));
                txt_qty.setText(rs.getString("qut"));
                txt_discount.setText(rs.getString("discount"));
                txt_price.setText(rs.getString("price"));
                txt_amount.setText(rs.getString("amount"));
            }
        }
    }
}

    
public int product_count() throws Exception {

    int count = 0;

    if (billid <= 0) {
        label_totalproducat.setText("0");
        return 0;
    }

    String sql = "SELECT COUNT(*) FROM rr_table WHERE bill_id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);   

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
    }

    
    label_totalproducat.setText(String.valueOf(count));

    return count;
}
public void loadProductData() throws Exception {
    
   
    try {
        conn = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass
        );

        pss = conn.prepareStatement(
            "SELECT serial_number, product_name, product_model, product_size, " +
            "qut, discount, price, amount " +
            "FROM rr_table WHERE bill_id = ? ORDER BY serial_number",
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        pss.setInt(1, billid);

        rss = pss.executeQuery();

        if (rss.next()) {      
            showProductFromRS();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void showProductFromRS() throws SQLException {

    txt_serial.setText(rss.getString("serial_number"));
    txt_product.setText(rss.getString("product_name"));
    txt_model.setText(rss.getString("product_model"));
    txt_size.setText(rss.getString("product_size"));
    txt_qty.setText(rss.getString("qut"));
    txt_discount.setText(rss.getString("discount"));
    txt_price.setText(rss.getString("price"));
    txt_amount.setText(rss.getString("amount"));
}
public void product_selecter() {

    String sql = "SELECT serial_number, product_name, product_model, product_size, " +
                 "qut, discount, price, amount " +
                 "FROM rr_table WHERE bill_id = ? AND serial_number = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);          
        ps.setInt(2, serial_number);  

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                txt_serial.setText(rs.getString("serial_number"));
                txt_product.setText(rs.getString("product_name"));
                txt_model.setText(rs.getString("product_model"));
                txt_size.setText(rs.getString("product_size"));
                txt_qty.setText(rs.getString("qut"));
                txt_discount.setText(rs.getString("discount"));
                txt_price.setText(rs.getString("price"));
                txt_amount.setText(rs.getString("amount"));

            } else {
                System.out.println("No product found for this serial");
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}


public void costomer_table_delet()throws Exception{

     String sql = "DELETE FROM bill_amounts WHERE bill_id = ?";
   
    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, billid);

        int rows = ps.executeUpdate();

}
}
public void DELETEINSERT(
        int billid, String customername, long mobile,
        String dates, String times, String product,
        String model, String size, int qtys,
        double discount, double price, double amount,
        double paidamount, double subtotal,
        double received, double total, double balance,
        String currentdate,String currenttime
) throws Exception {

    count(); // ✅ auto serial

    String sql =
        "INSERT INTO usert_bill_delete " +
        "(serial, billid, customername, moblieNumber, date, time, " +
        "productname, model, size, qty, discount, price, amount, " +
        "paidamount, subtotal, receied, tolal, balance, udeletedate, deletetime) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1,serial_number);
        ps.setInt(2, billid);
        ps.setString(3, customername);
        ps.setLong(4, mobile);
        ps.setString(5, dates);
        ps.setString(6, times);
        ps.setString(7, product);
        ps.setString(8, model);
        ps.setString(9, size);
        ps.setInt(10, qtys);
        ps.setDouble(11, discount);
        ps.setDouble(12, price);
        ps.setDouble(13, amount);
        ps.setDouble(14, paidamount);
        ps.setDouble(15, subtotal);
        ps.setDouble(16, received);
        ps.setDouble(17, total);
        ps.setDouble(18, balance);
        ps.setString(19, currentdate);
        ps.setString(20, currenttime);

        ps.executeUpdate();
    }

    productdelete();
}


public void count() throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String sql = "SELECT MAX(serial) AS serial FROM usert_bill_delete";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        int lastSerial = 0;

        if (rs.next()) {
            lastSerial = rs.getInt("serial");

            // table empty case
            if (rs.wasNull()) {
                lastSerial = 0;
            }
        }

        serial_number = lastSerial + 1; // ✅ correct place
        System.out.println("Next Serial Number : " + serial_number);
    }
}


private void clearFields() {

    txt_billid.clear();
    txt_customername.clear();
    txt_contactno.clear();
    txt_date.clear();
    txt_time.clear();
    txt_product.clear();
    txt_model.clear();
    txt_size.clear();
    txt_qty.clear();
    txt_discount.clear();
    txt_price.clear();
    txt_amount.clear();
    txt_paidamount.clear();
    txt_subtotal.clear();
    txt_received.clear();
    txt_total.clear();
    txt_balance.clear();
}

}
