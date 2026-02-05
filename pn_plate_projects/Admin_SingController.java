/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_SingController implements Initializable {

    @FXML
    private AnchorPane Ang_admin_sing;
    @FXML
    private Label labele_admin;
    @FXML
    private TextField txt_f_name;
    @FXML
    private TextField txt_L_name;
    @FXML
    private TextField txt_mobile;
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField pws_pass;
    @FXML
    private PasswordField pws_c_pass;
    @FXML
    private Button bt_back;
    @FXML
    private Button bt_save;
    @FXML
    private TextField txt_U_name;
    
    public static int lastUsedSequenceNumber = 50; 
    
    public static String adminId = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void f_name(ActionEvent event) {
    }

    @FXML
    private void L_name(ActionEvent event) {
    }

    @FXML
    private void mobile(ActionEvent event) {
    }

    @FXML
    private void email(ActionEvent event) {
    }

    @FXML
    private void pass(ActionEvent event) {
    }

    @FXML
    private void c_pass(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws Exception {
        
      Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }

    @FXML
    private void save(ActionEvent event) throws Exception {
        
               
      String F_name =txt_f_name.getText();
      String L_name =txt_L_name.getText();
      String Email=txt_email.getText();
      String Mob=txt_mobile.getText();
      String U_name=txt_U_name.getText();
      String Pass=pws_pass.getText();
      String c_pass=pws_c_pass.getText();
      
      long Mobile = Long.parseLong(Mob);
      
      String regex = "^(?=.*[0-9])"+"(?=.*[a-z])"+"(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{8,20}$";
        
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(Pass);
      
        if (m.matches()) {
            
           generateAdminId();
    
           Admin_Sing_Dao obj = new Admin_Sing_Dao();
                      
           obj.admin_sing(F_name, L_name, Email, Mobile, U_name, Pass, c_pass, adminId);
           
           System.out.println(F_name+","+L_name+","+Email+","+Mobile+","+U_name+","+Pass+","+c_pass);
          
           massage();
        } 
        else{ 
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Alert");
           alert.setHeaderText(null);
           alert.setContentText("Invalid Password");
           alert.showAndWait();
          }
    
    }

    @FXML
    private void U_name(ActionEvent event) {
    }
    
    public void generateAdminId() throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

    // LAST ADMIN ID FETCH
    String getLastIdQuery = "SELECT id_name FROM admin_id ORDER BY id_name DESC LIMIT 1";
    PreparedStatement psLast = con.prepareStatement(getLastIdQuery);
    ResultSet rs = psLast.executeQuery();   // ✔ FIXED

    int lastSeq = 0;

    if (rs.next()) {
        String lastId = rs.getString(1); // Example: ADMIN-25-051
        String[] parts = lastId.split("-"); 
        lastSeq = Integer.parseInt(parts[2]);  // 51
    }

    // NEXT SEQUENCE
    int nextSequenceNumber = lastSeq + 1;

    String prefix = "ADMIN";
    String year = String.valueOf(Year.now()).substring(2);
    String sequence = String.format("%03d", nextSequenceNumber);

    // READY ID
     adminId = prefix + "-" + year + "-" + sequence;
    
     System.out.println(adminId);


     adnin_id_insert();
    
}
 public void adnin_id_insert() throws Exception{
 
      Class.forName(PN_Dao_Paroperty.driver);

      Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass
);

// Use PreparedStatement properly
PreparedStatement ps = con.prepareStatement(
        "INSERT INTO admin_id (id_name) VALUES (?)"
);

ps.setString(1, adminId);

int num = ps.executeUpdate();

if (num > 0) {
    System.out.println("Inserted");
} else {
    System.out.println("Not Inserted");
}

ps.close();
con.close();

 }
 public void massage(){
 
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Massage");
           alert.setHeaderText(null);
           alert.setContentText(adminId);
           alert.showAndWait();
 
 }
 
 
}
