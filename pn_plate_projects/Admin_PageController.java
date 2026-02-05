/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_PageController implements Initializable {

    @FXML
    private AnchorPane ang_admin_page;
    @FXML
    private Label lable_log;
    @FXML
    private Label lable_intro;
    @FXML
    private TextField txt_user;
    @FXML
    private TextField txt_admin;
    @FXML
    private PasswordField pt_pass;
    @FXML
    private Button bt_log;
    @FXML
    private Button bt_sing;
    @FXML
    private Button bt_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void user(ActionEvent event) {
    }

    @FXML
    private void admin(ActionEvent event) {
    }

    @FXML
    private void pass(ActionEvent event) {
    }

    @FXML
    private void log(ActionEvent event) throws Exception {
   
      String name = txt_user.getText();
      String pass =pt_pass.getText();
      String admin = txt_admin.getText();
      
     Admin_Page_Dao obj = new Admin_Page_Dao();
     
    // obj.Admin_Login(name, pass, admin);
     
      Admin_intro_pageController on = new Admin_intro_pageController();
      
      on.NO();
      
    }

    @FXML
    private void sing(ActionEvent event) throws IOException{
        
     Parent root = FXMLLoader.load(getClass().getResource("Admin_mobile_login.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void admin_page(MouseEvent event) {
    }
    
    public void next_page()throws Exception{
    
      Parent root = FXMLLoader.load(getClass().getResource("Intro_page.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }
    
}
