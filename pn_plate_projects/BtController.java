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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class BtController implements Initializable {

    @FXML
    private Button bt_next;
    @FXML
    private TextField txt_fname;
    @FXML
    private TextField txt_lname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_mob;
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
    private void Next(ActionEvent event) throws  Exception {
        
     String f_name = txt_fname.getText();
     String l_name =txt_lname.getText();
     String n_email = txt_email.getText();
     String mob = txt_mob.getText();
     
     long mob1 = Long.parseLong(mob);
     
     sign_Dao obj = new sign_Dao();
     
     obj.next(f_name, l_name, n_email, mob1);
     
     cleardata1();
             
    
        
   
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
    
    }
     public void  nextPage1()throws IOException{
         
      Parent root = FXMLLoader.load(getClass().getResource("Username_and_Password.fxml"));
        
      Scene scene = new Scene(root);
           
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show();
    
     }    
}
