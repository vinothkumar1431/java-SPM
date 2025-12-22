/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Username_and_PasswordController implements Initializable {

    @FXML
    private TextField txt_usename;
    @FXML
    private TextField txt_pass;
    @FXML
    private TextField txt_conpass;
    @FXML
    private Button bt_save;
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
    private void usename(ActionEvent event) {
    }

    @FXML
    private void pass(ActionEvent event) {
    }

    @FXML
    private void conpass(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) throws Exception {
        
      String uname =txt_usename.getText();
      String pass = txt_pass.getText();
      String conpass=txt_conpass.getText();
      
     String regex = "^(?=.*[0-9])"+"(?=.*[a-z])"+"(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{8,20}$";
        
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(pass);

        if (m.matches()) {
            
             User_Dao obj =new User_Dao();
                   
             obj.save(uname, pass,conpass);
             
             start();
        } 
        else {
            System.out.println("Invalid password");
        }
        clearpage2();
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
      Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
    }
    public void clearpage2(){
    
    txt_usename.clear();
    txt_pass.clear();
    txt_conpass.clear();
    
    }
        public void start() throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("PN.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
       PN_Main. stage.show();
    
}
}
