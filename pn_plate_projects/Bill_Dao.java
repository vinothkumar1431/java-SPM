
package pn_plate_projects;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.swing.event.ListDataEvent;

public class Bill_Dao {
    
     private int currentNum; // Save current table name
     private final String tableName ="RR_TABLE";

    
    
   public Select_amount_pojo select_data(String prodact1,String prodatcname1,String prodactsize1,int quntity) throws Exception{
   
            Class.forName(PN_Dao_Paroperty.driver);
            Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
            PreparedStatement ps = con.prepareStatement("select price  from Items_plates where product = ? and product_name = ? and  product_size = ? ");
      
      ps.setString(1, prodact1);
      ps.setString(2, prodatcname1);
      ps.setString(3, prodactsize1);
     
      
      ResultSet rs = ps.executeQuery();
      
      Select_amount_pojo old =new Select_amount_pojo();

      double price = 0;
        
      old.setPrice(price);
        
      while(rs.next()){
      
      price = rs.getDouble("price");
      }
      
    System.out.println(price);
      
   return new Select_amount_pojo(price);
   } 
  
      
       public void show() throws Exception{
            
            Databaces_pojo pojo = new Databaces_pojo();
            
           String table =  pojo.getName();
           
            
            Class.forName(PN_Dao_Paroperty.driver);
            Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
            PreparedStatement ps = con.prepareStatement("select product_name , product_model ,"
                    + " product_size, qut , price , discount , amount , date ,time , total  from rr_table");
            
             ResultSet rs = ps.executeQuery();
             
             Billing_pojo bill =new Billing_pojo();
             
                  while (rs.next()){
                      
                  String product =  rs.getString("product");
                  String product_name = rs.getString("product_name");
                  String product_size =  rs.getString("product_size");
                  int quantity = rs.getInt("quantity");
                  double price =  rs.getDouble("price");
                  double discount = rs.getDouble("discount");
                  double amount = rs.getDouble("amount");
                  String date = rs.getString("date");
                 String time =  rs.getString("time");
                 double total =  rs.getDouble("total");
                 
                 
                  
                  bill.setProduct(product);
                  bill.setPro_name(product_name);
                  bill.setPro_size(product_size);
                  bill.setQuntity(quantity);
                  bill.setPrice(price);
                  bill.setDiscount(discount);
                  bill.setAmount(amount);
                  bill.setDate(date);
                  bill.setTime(time);
                  bill.setTotal(total);

                  }
       
           BillingController show_view =new BillingController();
                    
          //show_view.
          
        
} 

public void prices() throws Exception{

            Class.forName(PN_Dao_Paroperty.driver);
            Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
            PreparedStatement ps = con.prepareStatement("select price from Items_plates ");
      
                   ResultSet rs = ps.executeQuery();


} 
public void creat () throws Exception{
    
int last = select_count().getCount_number();

currentNum = last + 1;

count_number(currentNum);

System.out.println("✅ Table created: " + currentNum);

    
}

public void Items_Add(
        int serial , int id,String date, String time,
        String product_name, String product_model,
        String product_size, int qut,
        double price, double discount,
        double amount, double total) throws Exception {
    
    System.out.println("Serial NO : "+serial);

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO rr_table (" + 
            "serial_number ,bill_id ,date, time, product_name, product_model, product_size, " +
            "qut, price, discount, amount, total) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
         )) {
        ps.setInt(1, serial);
        ps.setInt(2, id);
        ps.setString(3, date);
        ps.setString(4, time);
        ps.setString(5, product_name);
        ps.setString(6, product_model);
        ps.setString(7, product_size);
        ps.setInt(8, qut);
        ps.setDouble(9, price);
        ps.setDouble(10, discount);
        ps.setDouble(11, amount);
        ps.setDouble(12, total);

        ps.executeUpdate();
        System.out.println("✅ Item inserted successfully");
    }
}




   
   public void count_number(int count_num)throws Exception{
        Class.forName(PN_Dao_Paroperty.driver);
        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);
             PreparedStatement ps = con.prepareStatement("INSERT INTO count_table(count_number) VALUES (?)")) {

            ps.setInt(1, count_num);
            ps.executeUpdate();
            System.out.println("Count updated: " + count_num);
        }

   }
  public Count_pojo select_count()throws Exception{
      
        Count_pojo count_data = new Count_pojo();
        Class.forName(PN_Dao_Paroperty.driver);
        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT count_number FROM count_table ORDER BY count_number DESC LIMIT 1");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count_data.setCount_number(rs.getInt(1));
            }
        }
        return count_data;
    }
      
  public void set_bill() throws Exception{
      
   
    Class.forName(PN_Dao_Paroperty.driver);
    try (Connection con = DriverManager.getConnection(
             PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
             PN_Dao_Paroperty.user,
             PN_Dao_Paroperty.pass);
        PreparedStatement ps = con.prepareStatement("INSERT INTO Bill_name(bill_names) VALUES (?)")) {

        ps.setString(1,tableName);
        int num = ps.executeUpdate();

        if (num > 0){
            System.out.println("✅ Bill name inserted: "+tableName);
        }   else{
            System.out.println("❌ Not inserted");
        }
    }
}
  public void Bill_AMT(int bill,String date,String time,String customer_Name,long customer_Number,
          double total,double sub_total,double paid_amount,double  balance_amount ,
          double received ) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO bill_amounts (" +
            "bill_id ,date, time, customer_name, customer_number, total, " +
            "sub_total, paid_amount, balance_amount, received) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
         )) {
        ps.setInt(1,bill);
        ps.setString(2, date);
        ps.setString(3, time);
        ps.setString(4, customer_Name);
        ps.setLong(5, customer_Number);
        ps.setDouble(6, total);
        ps.setDouble(7, sub_total);
        ps.setDouble(8, paid_amount);
        ps.setDouble(9, balance_amount);
        ps.setDouble(10, received);

        ps.executeUpdate();
        System.out.println("✅ Item inserted successfully");
        
        //next_new();

    }
}
    public void next_new() throws Exception{
     
      Parent root = FXMLLoader.load(getClass().getResource("New_Bill_Model.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
     
     }


      
  }