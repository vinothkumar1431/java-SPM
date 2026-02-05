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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static pn_plate_projects.PN_Main.stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class AdminSecuritysController implements Initializable {

    @FXML
    private TextField txt_conformpass;
    @FXML
    private PasswordField pa_pass;
    @FXML
    private Button bt_passwordchenge;
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
    private void ConformPassword(ActionEvent event)throws Exception{
        
    
    }

    @FXML
    private void Password(ActionEvent event) {
    }

    @FXML
    private void Passwordchenge(ActionEvent event) throws Exception{
        
         Parent root = FXMLLoader.load(getClass().getResource("Admin_PassWord_Chenge.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
    }

    @FXML
    private void Save(ActionEvent event)throws Exception{
        
        String pass = pa_pass.getText();
        String conform = txt_conformpass.getText();
       
        password_save(pass, conform);
        
    }
    
    public void password_save(String pass,String conformPass)throws Exception{
    
    String sql = "INSERT INTO Adminsecuritys(Password , conform_Password) VALUES (? , ?)";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1,pass);
    ps.setString(2,conformPass);


    int rows = ps.executeUpdate();

    if (rows > 0) {
        System.out.println("Data Inserted Successfully");
    }

} catch (Exception e) {
    e.printStackTrace();
}
    }
    
}
