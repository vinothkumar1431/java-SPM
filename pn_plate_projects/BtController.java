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
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import static pn_plate_projects.PN_Dao.name;
import static pn_plate_projects.PN_Dao.pass1;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class BtController implements Initializable {

    @FXML
    private Button bt_save;
    @FXML
    private TextField txt_fname;
    @FXML
    private TextField txt_lname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_mob;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_con_password;
    @FXML
    private Button bt_back;
    
     private String f_names;
     private String l_names;
     private String n_email;
     private long moblis;
     private String username ;
     private String pass ;
     private String con_password ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) throws  Exception {
        
    String f_name = txt_fname.getText();
    String l_name = txt_lname.getText();
    String n_emails = txt_email.getText();
    String mob = txt_mob.getText();
    String usernames = txt_username.getText();
    String passs = txt_password.getText();
    String con_passwords = txt_con_password.getText();

 
       long mob1 = Long.parseLong(mob);
  

    String regex = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(n_emails);

    if (!m.matches()) {
        gmailmsg(); 
        return;
    }

    String passwordRegex =
            "^(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{8,20}$";

    Pattern psm = Pattern.compile(passwordRegex);
    Matcher mm = psm.matcher(passs);

    if (!mm.matches()) {
        msg();  
        return;
    }

    if (!passs.equals(con_passwords)) {
        msg2();  
        return;
    }
      username = usernames;
      pass =passs;
      n_email = n_emails;
      con_password = con_passwords;
      f_names = f_name;
      l_names = l_name;
      moblis = mob1;
      
    System.out.println("All validations passed");
    
        Id_balck(username, pass);
    
        System.out.println(username+" , "+ pass);
}
    
public void Id_balck( String names , String upass ) throws Exception {

       Class.forName(PN_Dao_Paroperty.driver);
       
       Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
       PreparedStatement ps = con.prepareStatement("select username,password,first_name,least_name,email,moblie_number from id_black where username = ? and password = ?");
       
       ps.setString(1, names);
       ps.setString(2, upass);
       
       ResultSet rs = ps.executeQuery();
       
       String uname = "";
       String pass_1 = "";
       String name_f = "";
       String name_l = "";
       String email_1 = "";
       long moblie_1 = 0;
       
      

       while(rs.next()){
           
         uname = rs.getString("username");
         pass_1 = rs.getString("password");
         name_f = rs.getString("first_name");
         name_l = rs.getString("least_name");
         email_1 = rs.getString("email");
         moblie_1 = rs.getLong("moblie_number");
         
        
         
       }
              System.out.println("fweufb"+names);

    if(uname.equals(username)){
            username();

    } else{
        if(pass_1.equals(pass)){
        
        password();
        }
         else{
        
             if(email_1.equals(n_email)){
             
                 
            email();
          
             }
             else{
             
                 if (moblie_1 == moblis) {
                     
                      mobile();
                 }
                 else{
                 
                       sign_Dao dao = new sign_Dao();
                    
                    dao.next(f_names, l_names,n_email , moblis, username, pass, con_password);
                 }
             }
        }
        
    }
   
}
    
    @FXML
    private void fname(ActionEvent event) {
    }

    @FXML
    private void lname(ActionEvent event) {
    }

    @FXML
    private void email(ActionEvent event) {
    }

    @FXML
    private void mob(ActionEvent event) {
    }
     @FXML
    private void username(ActionEvent event) {
    }
     @FXML
    private void password(ActionEvent event) {
    }
     @FXML
    private void confirm_password(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
     Parent root = FXMLLoader.load(getClass().getResource("PN.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }
    
    public void cleardata1(){
      
      txt_fname.clear();
      txt_lname.clear();
      txt_email.clear();
      txt_mob.clear();
      txt_username.clear();
      txt_password.clear();
      txt_con_password.clear();
    
    }
     public void  nextPage1()throws IOException{
         
      Parent root = FXMLLoader.load(getClass().getResource("PN.fxml"));
        
      Scene scene = new Scene(root);
           
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show();
    
     } 
public void msg()throws Exception{
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Password Alert!");
alert.setContentText(
    "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character."
);

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
   /* "-fx-background-color: #ffe6e6;" +
    "-fx-border-color: red;" +
    "-fx-border-width: 2px;" + 
    "-fx-font-size: 14px;" +
    "-fx-font-family: 'Latha';" +
    "-fx-text-fill: #b30000;"*/
);
alert.showAndWait();
 
}
public void msg2()throws Exception{
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Password Alert!");
alert.setContentText("The password and confirm password do not match. Please try again.");

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
   /* "-fx-background-color: #ffe6e6;" +
    "-fx-border-color: red;" +
    "-fx-border-width: 2px;" + 
    "-fx-font-size: 14px;" +
    "-fx-font-family: 'Latha';" +
    "-fx-text-fill: #b30000;"*/
);
alert.showAndWait();
 
}
public void gmailmsg()throws Exception{

Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Email Alert!");
alert.setContentText("Please enter a valid Gmail address (example@gmail.com).");

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
   /* "-fx-background-color: #ffe6e6;" +
    "-fx-border-color: red;" +
    "-fx-border-width: 2px;" + 
    "-fx-font-size: 14px;" +
    "-fx-font-family: 'Latha';" +
    "-fx-text-fill: #b30000;"*/
);
alert.showAndWait();
}
public void username() throws Exception{

    Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("UserName Alert!");
alert.setContentText("Your UserName Black");

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
alert.setTitle("PassWord Alert!");
alert.setContentText("Your PassWord Black");

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

public void email() throws Exception{

    Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Email Alert!");
alert.setContentText("Your Email Id Black");

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
public void mobile() throws Exception{

Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Mobile Number Alert!");
alert.setContentText("Your Mobile Number Black");

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




