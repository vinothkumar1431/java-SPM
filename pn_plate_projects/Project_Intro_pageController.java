/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import static com.itextpdf.awt.geom.misc.Messages.getString;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import pn_plate_projects.Admin_intro_pageController;



/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Project_Intro_pageController implements Initializable {

    @FXML
    private AnchorPane secent_anchor;
    @FXML
    private Button bt_user;
    @FXML
    private Button bt_admin;

     @FXML
    private ToggleButton bt_ok;
     
    private boolean toggleStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void User(ActionEvent event) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("PN.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show(); 
    }

    @FXML
private void Admin(ActionEvent event) throws Exception {
    
getLastAdminSelect();
}

public void getLastAdminSelect() {

    String sql = "SELECT admin_select FROM project_intro ORDER BY id DESC LIMIT 1";


    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {  
            String value = rs.getString("admin_select");
            

            if ("true".equalsIgnoreCase(value)) {
                
              Admin_Page1();
            } else if ("false".equalsIgnoreCase(value)) {
              Admin_Page2();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void Admin_Page1() throws Exception{
    
       Parent root = FXMLLoader.load(getClass().getResource("Security_ServicePassword.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show();  
}
public void Admin_Page2() throws Exception{
    
       Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show();  
}

}





    

