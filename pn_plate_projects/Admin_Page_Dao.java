/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 *
 * @author vinot
 */
public class Admin_Page_Dao {
    
    public void Admin_Login(String U_name,String pass,String adminId) throws Exception{
    
       Class.forName(PN_Dao_Paroperty.driver);
       
       Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
       PreparedStatement ps = con.prepareStatement("select U_name,pass,admin_id from admin_data where  u_name=? and pass=? and admin_id=?");
       
       ps.setString(1, U_name);
       ps.setString(2, pass);
       ps.setString(3, adminId);
       
       ResultSet rs = ps.executeQuery();
       

       String name ="";
       String pass1="";
       String Admin="";
       

       while(rs.next()){
              
          name = rs.getString(1);
          pass1 = rs.getString(2);
          Admin = rs.getString(3);
          
       }
      if(name.equals(U_name)){
           
      if(pass1.equals(pass)){
       
     if(Admin.equals(adminId)){
      // ✔ LOGIN SUCCESS
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Login Status");
    alert.setHeaderText(null);
    alert.setContentText("Login Successful!");
    alert.showAndWait();
    
    next_page();
               }
     else{
     
    // ❌ ADMIN ID FAILED
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Login Status");
    alert.setHeaderText(null);
    alert.setContentText("Admin ID");
    alert.showAndWait();

     }
       }
           else{
           
    // ❌ PASSWORD FAILED
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Login Status");
    alert.setHeaderText(null);
    alert.setContentText("Invalid Password");
    alert.showAndWait();

           }     
    }
       else{
       
    // ❌ USER NAME FAILED
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Login Status");
    alert.setHeaderText(null);
    alert.setContentText("Invalid Username");
    alert.showAndWait();

       }     

    }
    public void next_page() throws IOException{
        
      Parent root = FXMLLoader.load(getClass().getResource("Billing.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }
}