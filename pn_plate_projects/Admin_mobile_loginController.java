/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
public class Admin_mobile_loginController implements Initializable {

    @FXML
    private AnchorPane Anchor_pane;
    @FXML
    private TextField txt_mobile;
    @FXML
    private Button bt_login;
    
    private int count = 0;
    
    private int Hours_24 = 0;
    
    private long  mobileNumber = 0; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Mobile(ActionEvent event) throws Exception{
    }

    @FXML
    private void Login(ActionEvent event)throws Exception{
                
        long Number = Long.valueOf(txt_mobile.getText());
        
        System.out.println(Number);
        
        MOBILENUMBERSELECT(Number);
        
        
        if(count==1){
        
        nextpage();
        }
        else if(count == 2){
        
        check();
        }  
        else if(count == 3){
        
        check();
        } 
        else if(count == 4){
        
        DELETESELECT();

        }
        
    }
   
    
public void MOBILENUMBERSELECT(long mobile) throws Exception {
    
    MOBILEMECHES();
    
    LocalTime time1 = LocalTime.now();
        String currentTime =
            time1.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        LocalDate date1 = LocalDate.now();
        String currentDate =
            date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass)) {

        String adminSql = "SELECT mobile FROM admin_data WHERE mobile = ?";

        try (PreparedStatement ps = con.prepareStatement(adminSql)) {
            ps.setLong(1, mobile);
            
          ResultSet rs = ps.executeQuery();
                
                long mobiles= 0;
                
                if (rs.next()) {
                    
                   mobiles  = rs.getLong("mobile");
                   
                   
                    insertFirstAttempt(count, mobile, currentDate, currentTime);
                }
            
        }

        
        }
}


public void MOBILEMECHES()throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

String sql = "SELECT COUNT(*) AS total FROM mobilepass";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

   
    
    if (rs.next()) {
       int  number = rs.getInt("total");
         
        count = number+1;
       
    }
}

    
}

public void insertFirstAttempt(int number, long mobile, String date, String time)
        throws Exception {

    String sql =
      "INSERT INTO mobilepass (count, mobilenumber, date, time) VALUES (?, ?, ?, ?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, number);
        ps.setLong(2, mobile);
        ps.setString(3, date);
        ps.setString(4, time);

        ps.executeUpdate();  

    }
}

public void check() throws Exception {

    String sql = "SELECT * FROM mobilepass";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {

            int count = rs.getInt("count");
            long mobile = rs.getLong("mobilenumber");

            String dateStr = rs.getString("date"); 
            String timeStr = rs.getString("time"); 

            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date =
                    LocalDate.parse(dateStr, dateFormatter);

            DateTimeFormatter timeFormatter =
                    DateTimeFormatter.ofPattern("hh:mm:ss a");
            LocalTime time =
                    LocalTime.parse(timeStr, timeFormatter);

            LocalDateTime lastAttempt =
                    LocalDateTime.of(date, time);

            LocalDateTime now = LocalDateTime.now();

            long hours =
                    Duration.between(lastAttempt, now).toHours();


            if (hours >= 24) {
            }
         
        }
    }
}
   public void DELETESELECT() throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String sql = "SELECT * FROM admin_data";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            String firstName = rs.getString("f_name");
            String lastName  = rs.getString("l_name");
            String email     = rs.getString("email");
            long mobileNum   = rs.getLong("mobile");
            String userName  = rs.getString("u_name");
            String adminId   = rs.getString("admin_id");

            UsernamePassword(userName);

        }
    }
}
public void UsernamePassword(String username) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String sql =
        "UPDATE admin_data SET f_name = '', l_name = '', email = '', mobile = 0, " +
        "admin_id = '' WHERE u_name = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, username);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            
        }
    }
}


       public void nextpage()throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
}
       
       

    }


