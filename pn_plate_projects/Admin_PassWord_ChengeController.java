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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_PassWord_ChengeController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField txt_oldpasss;
    @FXML
    private TextField txt_conformpass;
    @FXML
    private PasswordField pass_new_pass;
    @FXML
    private Button bt_save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Old_pass(ActionEvent event) {
    }

    @FXML
    private void ConformPass(ActionEvent event) {
    }

    @FXML
    private void New_Pass(ActionEvent event) {
    }

    @FXML
    private void Save(ActionEvent event) throws Exception{
        
        String oldpass = txt_oldpasss.getText();
        String newpass = pass_new_pass.getText();
        String coformpass = txt_conformpass.getText();
        
        passwordchenge(newpass, coformpass);
        
        
        
    }
    
    public void passwordchenge(String pass , String Conformpass)throws Exception{
    

String sql = "UPDATE Adminsecuritys SET password = ? , conform_Password = ?";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1, pass);      
    ps.setString(2, Conformpass);     

    int rows = ps.executeUpdate();

    if (rows > 0) {
        System.out.println("Password Updated Successfully");
    } else {
        System.out.println("No record found");
    }

} catch (Exception e) {
    e.printStackTrace();
}

    }
    
}
