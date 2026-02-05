
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


public class sign_Dao {
    
   
    
   public void next(String f_name, String l_name, String email,
                 long mob, String username, String password, String con_password )
        throws Exception {
       
       LocalTime time = LocalTime.now();
   String times  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        
    LocalDate date = LocalDate.now();

     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String dates = date.format(formatter);
     

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO pn_sign " +
            "(f_name, l_name, email, mob, username, password, con_password , date , time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? ,? ,?)")) {

        ps.setString(1, f_name);
        ps.setString(2, l_name);
        ps.setString(3, email);
        ps.setLong(4, mob);
        ps.setString(5, username);
        ps.setString(6, password);
        ps.setString(7, con_password);
        ps.setString(8, dates);
        ps.setString(9, times);
        

        int num = ps.executeUpdate();

        if (num > 0) {
            BtController obj = new BtController();
            obj.nextPage1();
        } else {
            System.out.println("Not inserted");
        }
    }
}
public void msg()throws Exception{
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("SUSSASFULL");
alert.setContentText("YOUR DATA INSERTSUSSASFULL");

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
 
}
