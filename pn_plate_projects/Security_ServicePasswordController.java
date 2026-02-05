/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static pn_plate_projects.PN_Main.stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Security_ServicePasswordController implements Initializable {

    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private TextField txt_pass;
    @FXML
    private Button bt_samit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Password(ActionEvent event) {
    }

    @FXML
    private void Samit(ActionEvent event) throws Exception{
        
        String pass = txt_pass.getText();
        
        passwordmach(pass, pass);
    }
    public void passwordmach(String pass, String conpass) throws Exception {

    String sql = "SELECT password, conform_password FROM adminsecuritys";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        String password = "";
        String conformpass = "";

        if (rs.next()) { // only ONE row expected
            password = rs.getString("password");           // ✔ lowercase
            conformpass = rs.getString("conform_password");
        }

        if (pass.equals(password) && conpass.equals(conformpass)) {

            Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("Password mismatch");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    }

