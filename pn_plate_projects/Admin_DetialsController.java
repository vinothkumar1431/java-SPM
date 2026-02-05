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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_DetialsController implements Initializable {

    @FXML
    private AnchorPane anchorpan;
    @FXML
    private Label label_name;
    @FXML
    private Label label_pass;
    @FXML
    private Label label_user;
    @FXML
    private Label label_email;
    @FXML
    private Label label_number;
    @FXML
    private Label  label_adminId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            ADMINSELECT();
        } catch (Exception ex) {
            Logger.getLogger(Admin_DetialsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
   public void ADMINSELECT()throws Exception{
       
       Class.forName(PN_Dao_Paroperty.driver);

    String sql = "SELECT * FROM admin_data";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

       String firstName ="";
       String lastName ="";
       String email ="";
       long mobileNum =0;
       String userName="";
       String pass ="";
       String adminId="";


        while (rs.next()) {

            firstName = rs.getString("f_name");
            lastName  = rs.getString("l_name");
            email     = rs.getString("email");
            mobileNum   = rs.getLong("mobile");
            userName  = rs.getString("u_name");
            pass      = rs.getString("pass");
            adminId   = rs.getString("admin_id");


        }
       String name1 = "vinoth"; 
       String name2 = "kumar";
       
      String name = name1+name2;

        
     label_name.setText(name);
     label_number.setText(String.valueOf(mobileNum));
     label_email.setText(email);
     label_user.setText(userName);
     label_pass.setText(pass);
     label_adminId.setText(adminId);
     
    }
   
   }
    
}
