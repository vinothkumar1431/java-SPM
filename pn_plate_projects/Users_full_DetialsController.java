/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import static com.sun.deploy.config.JREInfo.clear;
import static com.sun.deploy.net.UpdateTracker.clear;
import static com.sun.deploy.perf.DeployPerfUtil.clear;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import static pn_plate_projects.PN_Main.stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Users_full_DetialsController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private StackPane stackpane;
    @FXML
    private TableView<Users_full_Detials_pojo> table_full_detials;
    @FXML
    private TableColumn<Users_full_Detials_pojo, Integer> col_serial;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_username;
    @FXML
    private TableColumn<Users_full_Detials_pojo,String > col_password;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_firstname;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_lastname;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_email;
    @FXML
    private TableColumn<Users_full_Detials_pojo, Long> col_mobilenumber;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_date;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_time;
     @FXML
    private TableView<Users_full_Detials_pojo> table_full_user;
    @FXML
    private TableColumn<Users_full_Detials_pojo, Integer> col_serial1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_firstname1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_lastname1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_email1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, Long> col_mobilenumber1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_username1;
    @FXML
    private TableColumn<Users_full_Detials_pojo,String > col_password1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_date1;
    @FXML
    private TableColumn<Users_full_Detials_pojo, String> col_time1;
    @FXML
    private Button bt_user_detials;
    @FXML
    private Button bt_home;
    @FXML
    private Button bt_block_detials;
    @FXML
    private Button bt_back;
    @FXML
    private Button bt_deleting;
    @FXML
    private Button bt_unblock;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_block;
    @FXML
    private Button  bt_recovery;
    @FXML
    private Button bt_totalclean;
    
    
    
    /**
     * Initializes the controller class.
     */
     private User_full_Detials_Dao dao = new User_full_Detials_Dao();
     

    @Override
public void initialize(URL url, ResourceBundle rb) {

    // Blocked users table
    col_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
    col_password.setCellValueFactory(new PropertyValueFactory<>("passWord"));
    col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    col_lastname.setCellValueFactory(new PropertyValueFactory<>("lestName"));
    col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
    col_mobilenumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

    // All users table
    col_serial1.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_username1.setCellValueFactory(new PropertyValueFactory<>("userName"));
    col_password1.setCellValueFactory(new PropertyValueFactory<>("passWord"));
    col_firstname1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    col_lastname1.setCellValueFactory(new PropertyValueFactory<>("lestName"));
    col_email1.setCellValueFactory(new PropertyValueFactory<>("email"));
    col_mobilenumber1.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
    col_date1.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time1.setCellValueFactory(new PropertyValueFactory<>("time"));

  
}


    
@FXML
private void user_detials(ActionEvent event) {
    
      User_full_Detials_Dao daos = new User_full_Detials_Dao();

    table_full_user.setVisible(true);
    
    table_full_user.setItems(daos.UsersDetials());

    table_full_detials.setVisible(false);

    
}


    @FXML
    private void home(ActionEvent event)throws Exception{//////-----------HOME PAGE
        
        Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show();
    }
    @FXML
    private void recovery(ActionEvent event) {//////----------- RECOVERY
        
    Users_full_Detials_pojo users = table_full_user.getSelectionModel().getSelectedItem();
   
    if (users != null) {

    String username = users.getUserName();
    String password = users.getPassWord();
    String f_name = users.getFirstName();
    String l_name = users.getLestName();
    String email = users.getEmail();
    Long mobile = users.getMobileNumber();

    System.out.println(username);
    System.out.println(password);
    
        table_full_user.getItems().remove(users);

    }
    }
    @FXML
    private void totalClean(ActionEvent event) throws Exception{//////-----------TOTAL CLEAN
        
        Users_full_Detials_pojo user = table_full_detials.getSelectionModel().getSelectedItem();

     if (user != null) {

    String username = user.getUserName();
    String password = user.getPassWord();
    String f_name = user.getFirstName();
    String l_name = user.getLestName();
    String email = user.getEmail();
    Long mobile = user.getMobileNumber();

    System.out.println(username);
    System.out.println(password);
    
         All_delete(username, password);


    table_full_detials.getItems().remove(user);
}
    }
     @FXML
private void block_detials(ActionEvent event) {////////--------BLOCK DETIALS

     User_full_Detials_Dao daos = new User_full_Detials_Dao();

    table_full_detials.setVisible(true);
    
    table_full_detials.setItems(daos.blockList());

    table_full_user.setVisible(false);
}

    @FXML
    private void bt_back(ActionEvent event)throws Exception{////////-----------BACK PAGE
        
        Parent root = FXMLLoader.load(getClass().getResource("User_Detials.fxml"));
        
        Scene scene = new Scene(root);
        
        PN_Main.stage.setScene(scene);
        
        PN_Main. stage.show();
      
        
    }
  
    @FXML
    private void deleting_detials(ActionEvent event) throws Exception{/////-------DELETING DITIALS
        
     User_full_Detials_Dao daos = new User_full_Detials_Dao();

    table_full_detials.setVisible(true);
    
    table_full_detials.setItems(daos.DeleteingList());

    table_full_user.setVisible(false);  

    }

    @FXML
    private void block(ActionEvent event) throws Exception{/////------UNBLOCK
        
      Users_full_Detials_pojo user = table_full_detials.getSelectionModel().getSelectedItem();

    if (user != null) {
        
        int serial = user.getSerial();
        String username = user.getUserName();
        String password = user.getPassWord();
        String f_name = user.getFirstName();
        String l_name = user.getLestName();
        String email = user.getEmail();
        Long moble = user.getMobileNumber();
        String date = user.getDate();
        String time = user.getTime();
        

        System.out.println(username);
        System.out.println(password);

        unblock_list_select(username, password);
        
                table_full_user.getItems().remove(user);

    }
    }

    @FXML
    private void delete(ActionEvent event) throws Exception{
        
    Users_full_Detials_pojo user = table_full_detials.getSelectionModel().getSelectedItem();

    Users_full_Detials_pojo users = table_full_user.getSelectionModel().getSelectedItem();

if (user != null) {

    String username = user.getUserName();
    String password = user.getPassWord();
    String f_name = user.getFirstName();
    String l_name = user.getLestName();
    String email = user.getEmail();
    Long mobile = user.getMobileNumber();

    System.out.println(username);
    System.out.println(password);

    delete_list_insert(username, password, f_name, l_name, email, mobile);

    // UI remove
    table_full_detials.getItems().remove(user);

} else if (users != null) {

    String username = users.getUserName();
    String password = users.getPassWord();
    String f_name = users.getFirstName();
    String l_name = users.getLestName();
    String email = users.getEmail();
    Long mobile = users.getMobileNumber();

    System.out.println(username);
    System.out.println(password);

    delete_list_insert(username, password, f_name, l_name, email, mobile);

    // UI remove
    table_full_user.getItems().remove(users);

} else {
    System.out.println("No row selected in both tables");
}
    }
    @FXML
    private void block_(ActionEvent event) throws Exception{
        
    Users_full_Detials_pojo users = table_full_user.getSelectionModel().getSelectedItem();

    
     if (users != null) {

        String username = users.getUserName();
        String password = users.getPassWord();

        System.out.println("From table_full_user");
        System.out.println(username);
        System.out.println(password);

Users_DetialsController dao = new Users_DetialsController();
        
        dao.user_black(username, password);
        

    table_full_user.getItems().remove(users);

    } 
    else {
        System.out.println("Row select pannunga");
    }
    }
    

    
    
    public void unblock_list_select(String username ,String password)throws Exception{
        
        String sql = "SELECT username, password, first_name, least_name, email, moblie_number " +
                 "FROM id_black WHERE username = ? AND password = ? ";
        
        Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.setString(2, password);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                String fName   = rs.getString("username");
                String lName   = rs.getString("password");
                String email   = rs.getString("first_name");
                String uName   = rs.getString("least_name");
                String pass    = rs.getString("email");
                long mobile    = rs.getLong("moblie_number");

                
                unblock_list_insert(username, password, fName, lName, email, mobile);
            } else {
                System.out.println("INVALID USERNAME OR PASSWORD");
            }
        }
    }
    
    }
    public void unblock_list_insert(String username , String password ,String first_name , String least_name ,String email ,long moblie_number )throws Exception{
        
        LocalTime time = LocalTime.now();
   String currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        
LocalDate date = LocalDate.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  String currentDate = date.format(formatter);
  
     

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO pn_sign " +
            "(f_name, l_name, email, mob, username, password,con_password,date, time) " +
            "VALUES (? ,?, ?, ?, ?, ?, ?, ? ,? )")) {
        ps.setString(1, first_name);
        ps.setString(2, least_name);
        ps.setString(3, email);
        ps.setLong(4, moblie_number);
        ps.setString(5, username);
        ps.setString(6, password);
        ps.setString(7, password);
        ps.setString(8, currentDate);
        ps.setString(9, currentTime);
      

        int num = ps.executeUpdate();

        if (num > 0) {
        
            unblock_delete(username, password);
            
        } else {
            System.out.println("Not inserted");
        }
    }
    
    }
    public void unblock_delete(String username ,String password)throws Exception{
    
         Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM id_black WHERE username = ? AND password = ?")) {

        ps.setString(1, username);
        ps.setString(2, password);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    }
    
    }
    public void delete_list_insert(String username, String password ,String first_name , String least_name ,String email ,long moblie_number)throws Exception{
        
        LocalTime time = LocalTime.now();
   String currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        
LocalDate date = LocalDate.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  String currentDate = date.format(formatter);
  
     

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO users_delete " +
            "(username, password, first_name, least_name, email, moblie_number,date,time) " +
            "VALUES (? ,?, ?, ?, ?, ?, ?, ?)")) {
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, first_name);
        ps.setString(4, least_name);
        ps.setString(5, email);
        ps.setLong(6, moblie_number);
        ps.setString(7, currentDate);
        ps.setString(8, currentTime);
      

        int num = ps.executeUpdate();

        if (num > 0) {
        
            deleteing_list(username, password);
            
        } else {
            System.out.println("Not inserted");
        }
    }
    
    }
    public void deleteing_list(String username , String password)throws Exception{
    
                 Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM id_black WHERE username = ? AND password = ?")) {

        ps.setString(1, username);
        ps.setString(2, password);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    
    }
    
    }
    
    public void Recovery_List(String username , String password)throws Exception{
        
        String sql = "SELECT username, password, first_name, least_name, email, moblie_number " +
                 "FROM users_delete WHERE username = ? AND password = ? ";
        
        Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.setString(2, password);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                String fName   = rs.getString("username");
                String lName   = rs.getString("password");
                String email   = rs.getString("first_name");
                String uName   = rs.getString("least_name");
                String pass    = rs.getString("email");
                long mobile    = rs.getLong("moblie_number");

                
                Recovery_Insert(fName, lName, email, mobile, username, password);
            } else {
                System.out.println("INVALID USERNAME OR PASSWORD");
            }
        }
    }
    
    
    }
    
    public void Recovery_Insert(String first_name,String least_name,String email,long moblie_number,String username,String password)throws Exception{
    
      LocalTime time = LocalTime.now();
   String currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        
LocalDate date = LocalDate.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  String currentDate = date.format(formatter);
  
     

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO pn_sign " +
            "(f_name, l_name, email, mob, username, password,con_password,date, time) " +
            "VALUES (? ,?, ?, ?, ?, ?, ?, ? ,? )")) {
        ps.setString(1, first_name);
        ps.setString(2, least_name);
        ps.setString(3, email);
        ps.setLong(4, moblie_number);
        ps.setString(5, username);
        ps.setString(6, password);
        ps.setString(7, password);
        ps.setString(8, currentDate);
        ps.setString(9, currentTime);
      

        int num = ps.executeUpdate();

        if (num > 0) {
        
            Recovery_Deleteing(username, password);
            
        } else {
            System.out.println("Not inserted");
        }
    }
    
    }
     public void Recovery_Deleteing(String username , String password)throws Exception{
    
                 Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM users_delete WHERE username = ? AND password = ?")) {

        ps.setString(1, username);
        ps.setString(2, password);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    
    }
    
    }
    
  

    public void All_delete(String username , String password)throws Exception{
    
         Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM users_delete WHERE username = ? AND password = ?")) {

        ps.setString(1, username);
        ps.setString(2, password);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    
    }
    
    }
    
}
