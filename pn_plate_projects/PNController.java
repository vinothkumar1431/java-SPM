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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author vinot
 */
public class PNController implements Initializable {

    @FXML
    private TextField txt_uname;
    @FXML
    private PasswordField pwd_pass;
    @FXML
    private Button bt_log;
    @FXML
    private Button bt_Sign;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uname(ActionEvent event) {
    }

    @FXML
    private void pass(ActionEvent event) {
        
    }

    @FXML
    private void log(ActionEvent event) throws Exception {
  
     String name = txt_uname.getText();
     String pass = pwd_pass.getText();
     
     
        blackList(name, pass);
     
     
     
     
        //System.out.println(username+","+userpass);
     
     
    }

    @FXML
    private void Sign(ActionEvent event) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show(); 
    }
    
    public void cleaData(){
    
        txt_uname.clear();
        pwd_pass.clear();
        
   
        
    }
    public void  nextPage() throws Exception{
    
      Parent root = FXMLLoader.load(getClass().getResource("Billing.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show();
      
    }
    private void showAlert(Alert.AlertType type, String title, String message) {
        
    Alert alert = new Alert(type);
    
    alert.setTitle(title);
    
    alert.setHeaderText(null);
    
    alert.setContentText(message);
    
    alert.showAndWait();
}
 public void demo(){

      
    /* String uname =txt_uname.getText();
      String pass = pwd_pass.getText();
      
      String regex = "^(?=.*[0-9])"+"(?=.*[a-z])"+"(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{8,20}$";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pass);

        if (m.matches()) {
            
             PN_Dao obj = new PN_Dao();
        
              obj.log(uname, pass);
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
       cleaData();
    
        PN_Dao obj =new PN_Dao();
        
        String uname=txt_uname.getText();
        String upass=pwd_pass.getText();
        
        PN_Pojo pojo = obj.log(uname,upass);
        
        String user=pojo.getUname();
        String pass=pojo.getPass();
        
                 System.out.println(user);  

        
      if(user.equals(uname)){
            
       if(pass.equals(upass)){
           
         System.out.println(user);  
            
       PNController pnc =new PNController();
         
           try {
               pnc.nextPage();
           } catch (IOException ex) {
               Logger.getLogger(PNController.class.getName()).log(Level.SEVERE, null, ex);
           }
             
        }
        else{
              
         Alert alert =new Alert(Alert.AlertType.ERROR);
        
        alert.setTitle("Alert!");
        
        alert.setContentText("This is an aalert");
        
        Optional<ButtonType>result = alert.showAndWait();
        
       if (result.isPresent()) {
           
    if (result.get() == ButtonType.OK) {
        
        System.out.println("OK clicked!");
        
    } else if (result.get() == ButtonType.CANCEL) {
        
        System.out.println("Cancel clicked!");
        
    } else {
        
        System.out.println("Alert closed without button!");
    }
}
          
          }
      }
      
      else{
      
          Alert alert =new Alert(Alert.AlertType.ERROR);
        
        alert.setTitle("Alert!");
        
        alert.setContentText("This is an aalert");
        
        Optional<ButtonType>result = alert.showAndWait();
        
       if (result.isPresent()) {
           
    if (result.get() == ButtonType.OK) {
        
        System.out.println("OK clicked!");
        
    } else if (result.get() == ButtonType.CANCEL) {
        
        System.out.println("Cancel clicked!");
        
    } else {
        
        System.out.println("Alert closed without button!");
    }
}     
      
      
      }
*/       
}   
 
 public void blackList(String username, String password) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement( "SELECT username, password FROM id_black WHERE username=? AND password=?")) {

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
      
        String uname = "";
         String pass = "";
         
        while(rs.next()) {

             uname = rs.getString("username");
             pass = rs.getString("password");

           
        } 
        
        if(username.equals(uname)){
        
         username();   
       }
        else if(password.equals(pass)){
         
           password();  
         }
        else{
            PN_Dao obj = new PN_Dao();
            obj.login(username, password);

            PN_Pojo pojo = new PN_Pojo();
            pojo.setUname(username);
            pojo.setPass(password);

                
                }

    }
 }

 public void username() throws Exception{

    Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("UserName Alert!");
alert.setContentText("Your UserName Block");

alert.getDialogPane().setStyle(
        
"-fx-background-color: linear-gradient(to bottom, #0078D7, #005A9E);" +  // Gradient blue
"-fx-text-fill: white;" +
"-fx-font-weight: bold;" +
"-fx-font-size: 15px;" +
"-fx-font-family: 'Segoe UI Semibold';" +  // Professional system font
"-fx-background-radius: 8;" +
"-fx-padding: 8 18 8 18;" +
"-fx-cursor: hand;" +
"-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 3, 0, 0, 1);" +
"-fx-border-color: transparent;" +
"-fx-border-radius: 8;"      
  
);
alert.showAndWait();
 
}

public void password() throws Exception{

    Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("UserName Alert!");
alert.setContentText("Your UserName Block");

alert.getDialogPane().setStyle(
        
"-fx-background-color: linear-gradient(to bottom, #0078D7, #005A9E);" +  // Gradient blue
"-fx-text-fill: white;" +
"-fx-font-weight: bold;" +
"-fx-font-size: 15px;" +
"-fx-font-family: 'Segoe UI Semibold';" +  // Professional system font
"-fx-background-radius: 8;" +
"-fx-padding: 8 18 8 18;" +
"-fx-cursor: hand;" +
"-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 3, 0, 0, 1);" +
"-fx-border-color: transparent;" +
"-fx-border-radius: 8;"      
  
);
alert.showAndWait();
 
}
 
}

