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
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class Users_DetialsController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private StackPane stackpane;
    @FXML
    private TableView<Users_Bills_pojo> table_Usersbills;
    @FXML
    private TableColumn<Users_Bills_pojo, Integer> view_serial;
    @FXML
    private TableColumn<Users_Bills_pojo, String> view_username;
    @FXML
    private TableColumn<Users_Bills_pojo, String> view_password;
    @FXML
    private TableColumn<Users_Bills_pojo, Integer> view_billsid;
    @FXML
    private TableColumn<Users_Bills_pojo , String> view_billstime;
    @FXML
    private TableColumn<Users_Bills_pojo, Double> view_billsamount;
    @FXML
    private TableView<Users_Working_pojo> table_working;
    @FXML
    private TableColumn<Users_Working_pojo, Integer> view_serials;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_user;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_pass;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_intime;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_indate;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_outtime;
    @FXML
    private TableColumn<Users_Working_pojo, String> view_outdate;
    
    @FXML
    private TableView <users_counttotal_pojo> tableview_least;
     @FXML
    private TableColumn<users_counttotal_pojo,Integer> col_serial;
    @FXML
    private TableColumn<users_counttotal_pojo,String> col_username;
    @FXML
    private TableColumn<users_counttotal_pojo,String> col_password;
    
    
    @FXML
    private Button bt_usersbills;
    @FXML
    private Button bt_workings;
    @FXML
    private Button bt_print;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_clean;
    @FXML
    private Button bt_moredetial;
    @FXML
    private Button bt_select;
    @FXML
    private Button bt_Black;
    @FXML
    private Button bt_home;
   
    @FXML
    private Label label_totaluser;
    @FXML
    private AnchorPane anchor_center;

    /**
     * Initializes the controller class.
     */
@Override
public void initialize(URL url, ResourceBundle rb) {
    total_count();


    // -------- USERS BILLS TABLE --------
    view_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
    view_username.setCellValueFactory(new PropertyValueFactory<>("username"));
    view_password.setCellValueFactory(new PropertyValueFactory<>("password"));
    view_billsid.setCellValueFactory(new PropertyValueFactory<>("billId"));
    view_billstime.setCellValueFactory(new PropertyValueFactory<>("billingTime"));
    view_billsamount.setCellValueFactory(new PropertyValueFactory<>("billingAmount"));

    // -------- WORKING TABLE --------
    view_serials.setCellValueFactory(new PropertyValueFactory<>("serial"));
    view_user.setCellValueFactory(new PropertyValueFactory<>("userName"));
    view_pass.setCellValueFactory(new PropertyValueFactory<>("passWord"));
    view_intime.setCellValueFactory(new PropertyValueFactory<>("inTime"));
    view_indate.setCellValueFactory(new PropertyValueFactory<>("inDate"));
    view_outtime.setCellValueFactory(new PropertyValueFactory<>("outTime"));
    view_outdate.setCellValueFactory(new PropertyValueFactory<>("outDate"));

        // -------- USERS TOTAL --------
        
  // -------- USERS TOTAL --------
tableview_least.setVisible(true);

col_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
col_password.setCellValueFactory(new PropertyValueFactory<>("password"));

        try {
            loadTableData();
        } catch (Exception ex) {
            Logger.getLogger(Users_DetialsController.class.getName()).log(Level.SEVERE, null, ex);
        }



    // ❗ Initially hide both tables
    table_Usersbills.setVisible(false);
}


@FXML
private void Users_Bills(ActionEvent event) {
    Users_Deteals_Dao dao = new Users_Deteals_Dao();

    // Users Bills table visible pannitu data load
    table_Usersbills.setVisible(true);
    table_Usersbills.setItems(dao.UsersBills_Detials());

    // Working table hide
    table_working.setVisible(false);
    table_working.setItems(FXCollections.observableArrayList());
}

@FXML
private void workings(ActionEvent event) {
    Users_Deteals_Dao dao = new Users_Deteals_Dao();

    // Working table visible pannitu data load
    table_working.setVisible(true);
    table_working.setItems(dao.Working_Detials());

    // Users Bills table hide
    table_Usersbills.setVisible(false);
    table_Usersbills.setItems(FXCollections.observableArrayList());
}
@FXML
private void print(ActionEvent event) throws Exception {

    Users_Bills_pojo user = table_Usersbills.getSelectionModel().getSelectedItem();

    if (user != null) {

        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println(username);
        System.out.println(password);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Users_Detials_Printer.fxml"));

        Parent root = loader.load();

        Users_Detials_PrinterController controller =
                loader.getController();

        controller.loadTable(username, password);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

@FXML
private void delete(ActionEvent event)throws Exception{
    
    Users_Bills_pojo user = table_Usersbills.getSelectionModel().getSelectedItem();
    
    Users_Working_pojo users = table_working.getSelectionModel().getSelectedItem();

    if (user != null) {

        String username = user.getUsername();
        String password = user.getPassword();
        
        USERS_DELETE(username, password);

        System.out.println(username);
        System.out.println(password);


    }
    else if (users != null) {

        String username = users.getUserName();
        String password = users.getPassWord();
        
        WORKING_DELETE(username, password);

        System.out.println(username);
        System.out.println(password);


    }

}
@FXML
private void clean(ActionEvent event)throws Exception{
    
   Users_Bills_pojo user = table_Usersbills.getSelectionModel().getSelectedItem();
    
  Users_Working_pojo users = table_working.getSelectionModel().getSelectedItem();
  
  if (user != null) {
      USERS_DELETE_CLEN();
}
  else if (users != null) {
      WORKING_DELETE_CLEN();
}
}

@FXML
private void Home(ActionEvent event) throws Exception{
    
     Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();

}


@FXML
private void moredetial(ActionEvent event) throws Exception{
    
        Parent root = FXMLLoader.load(getClass().getResource("Users_full_Detials.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        

}
@FXML
private void select(ActionEvent event) throws Exception{
    
    users_counttotal_pojo user = tableview_least.getSelectionModel().getSelectedItem();

    if (user != null) {

        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println(username);
        System.out.println(password);

       users_delete_deteals(username, password);

        
        
    
    }
}
@FXML
private void Black(ActionEvent event) throws Exception {
    
    
    users_counttotal_pojo user = tableview_least.getSelectionModel().getSelectedItem();

    if (user != null) {

        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println(username);
        System.out.println(password);

        user_black(username,password);

        
        
        

    } else {
        System.out.println("Please select a row first");
    }

}
private void loadTableData() throws Exception {

   Users_Deteals_Dao demo = new Users_Deteals_Dao();

ObservableList<users_counttotal_pojo> list = demo.users_count();

tableview_least.setItems(list);
}
public void total_count() {

    String sql = "SELECT COUNT(*) AS total FROM pn_sign";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            label_totaluser.setText(String.valueOf(rs.getInt("total")));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void user_black(String username, String password) throws Exception {
    

    String sql = "SELECT f_name, l_name, email, mob, username, password " +
                 "FROM pn_sign WHERE username = ? AND password = ?";

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

                String fName   = rs.getString("f_name");
                String lName   = rs.getString("l_name");
                String email   = rs.getString("email");
                long mobile    = rs.getLong("mob");
                String uName   = rs.getString("username");
                String pass    = rs.getString("password");
                
                id_black(username, password, fName, lName, email, mobile);
            } else {
                System.out.println("INVALID USERNAME OR PASSWORD");
            }
        }
    }
}
public void id_black(String username ,String password,String f_name , String l_name ,String email ,long mob )
        throws Exception {
    
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
            "INSERT INTO id_black " +
            "(username, password, first_name, least_name, email, moblie_number,date, time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? ,?)")) {
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, f_name);
        ps.setString(4, l_name);
        ps.setString(5, email);
        ps.setLong(6, mob);
        ps.setString(7, currentDate);
        ps.setString(8, currentTime);
      

        int num = ps.executeUpdate();

        if (num > 0) {
                  deleteUser(username, password);

        } else {
            System.out.println("Not inserted");
        }
    }
}
public void deleteUser(String username ,String password) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM pn_sign WHERE username = ? AND password = ?")) {

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

public void users_delete_deteals(String username ,String password) throws Exception{

  String sql = "SELECT f_name, l_name, email, mob, username, password " +
                 "FROM pn_sign WHERE username = ? AND password = ?";

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

                String fName   = rs.getString("f_name");
                String lName   = rs.getString("l_name");
                String email   = rs.getString("email");
                long mobile    = rs.getLong("mob");
                String uName   = rs.getString("username");
                String pass    = rs.getString("password");
                
                users_insert_delete(username, password, fName, lName, email, mobile);
            } else {
                System.out.println("INVALID USERNAME OR PASSWORD");
            }
        }
    }
}

public void users_insert_delete(String username ,String password,String f_name,String l_name,String email,long mob )throws Exception{

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
            "INSERT INTO users_deletes " +
            "(username, password, first_name, least_name, email, moblie_number,date, time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? ,?)")) {
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, f_name);
        ps.setString(4, l_name);
        ps.setString(5, email);
        ps.setLong(6, mob);
        ps.setString(7, currentDate);
        ps.setString(8, currentTime);
      

        int num = ps.executeUpdate();

        if (num > 0) {
                  deleteUser_detials(username, password);

        } else {
            System.out.println("Not inserted");
        }
    }
}
public void deleteUser_detials(String username ,String password) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    
    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM pn_sign WHERE username = ? AND password = ?")) {

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
public void USERS_DELETE(String username , String password)throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM user_working WHERE username = ? AND password = ?")) {

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
public void WORKING_DELETE(String username , String password)throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM user_working WHERE username = ? AND password = ?")) {

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
public void USERS_DELETE_CLEN()throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "TRUNCATE TABLE user_working")) {

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    }

}
public void WORKING_DELETE_CLEN()throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "TRUNCATE TABLE user_working;")) {


        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("DELETED SUCCESSFULLY");
        } else {
            System.out.println("USER NOT FOUND");
        }
    }

}

}



