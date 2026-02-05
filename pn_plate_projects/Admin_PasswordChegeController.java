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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_PasswordChegeController implements Initializable {

    @FXML
    private PasswordField pass_newpassword;
    @FXML
    private PasswordField pass_repassword;
    @FXML
    private TextField txt_conformpassword;
    @FXML
    private Button bt_save;
    
     private String newPass = "";
     private String rePass = "";
     private String conformPass = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NewPassword(ActionEvent event) {
    }

    @FXML
    private void Repassword(ActionEvent event) {
    }

    @FXML
    private void Conformpassword(ActionEvent event) {
    }
   

     
    @FXML
    private void Save(ActionEvent event) throws Exception{
        
        newPass = pass_newpassword.getText();
        rePass = pass_repassword.getText();
        conformPass = txt_conformpassword.getText();
        
        passwordChek();
        
        
    }
    public void passwordChek() throws Exception{
         String passwordRegex =
            "^(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{8,20}$";

    Pattern ps = Pattern.compile(passwordRegex);
    Matcher m = ps.matcher(newPass);

    if (!m.matches()) {
        msg();  
        return;
    }
    
    Pattern psm = Pattern.compile(newPass);
    Matcher mm = psm.matcher(rePass);  
    
    if(!mm.matches()){
       rePasswordMsg();
       return;
    }
    Pattern psc = Pattern.compile(newPass);
    Matcher mc = psc.matcher(conformPass);  
            if(!mc.matches()){       
           rePasswordMsg();
            return;
            
            }
                  username_Select();

    }       
        
public void username_Select()throws Exception{
    
    
   String sql = "SELECT u_name FROM admin_data";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

          ResultSet rs = ps.executeQuery();

      String name = "";    
          
       while (rs.next()) {
    name = rs.getString("u_name");
    System.out.println(name);
}

        passwordUpdate(newPass, newPass ,name);


}
                    
}                   
public void passwordUpdate(String newpass, String conpass, String username) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String query =
        "UPDATE admin_data " +
        "SET pass = ?, c_pass = ? " +
        "WHERE u_name = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setString(1, newpass);
        ps.setString(2, conpass);
        ps.setString(3, username);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("✅ PASSWORD UPDATED SUCCESSFULLY");
            showSuccessAndGoNext();
        } else {
            System.out.println("❌ USER NOT FOUND");
        }
    }
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
    public void rePasswordMsg() {

    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Password Mismatch!");
    alert.setHeaderText(null);

    alert.setContentText(
        "Password and Re-Password do not match" +
        "Please enter the same password in both fields."
    );

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #D32F2F, #B71C1C);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 8;" +
        "-fx-padding: 10;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 4, 0, 0, 2);"
    );

    alert.showAndWait();
}
    public void showSuccessAndGoNext() {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("Password changed successfully!");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #2E7D32, #1B5E20);" +
        "-fx-font-size: 15px;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 8;" +
        "-fx-padding: 10;"
    );

    alert.showAndWait();

}



}
