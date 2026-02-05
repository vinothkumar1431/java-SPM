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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static pn_plate_projects.PN_Main.stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_Product_DeleteingController implements Initializable {

    @FXML
    private AnchorPane Anchor_pane;
    
        /////-------------PRODUCT DETIALS---------------//////

    @FXML
    private TableView<Admin_Product_Deteing_pojo> tableview_totalproduct;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_serial;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productname;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_model;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_size;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_price;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_discount;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_openigstock;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_date;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_time;
    
    /////-------------BLOCK DETIALS---------------//////
    
    @FXML
    private TableView<Admin_Product_Deteing_pojo> tableview_BlockDeletials;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_serial1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productname1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_model1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_size1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_price1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_discount1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_openigstock1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_date1;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_time1;
    
    
    /////-------------DLETEING DETIALS---------------//////
    
    @FXML
    private TableView<Admin_Product_Deteing_pojo> tableview_DeleteDetials;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_serial2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productname2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_model2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_size2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_price2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_discount2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_openigstock2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_date2;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_time2;
    
    
    @FXML
    private AnchorPane ancheor_centorpane;
    @FXML
    private Button ProductDetials;
    @FXML
    private Button bt_blokdetials;
    @FXML
    private Button bt_deletedetials;
    @FXML
    private Button bt_block;
    @FXML
    private Button bt_clean;
    @FXML
    private Button bt_unblock;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_recovery;
    @FXML
    private Button bt_back;
    @FXML
    private Label label_totalproduct;
    @FXML
    private Label label_titiel;
    
private ObservableList<Admin_Product_Deteing_pojo> list = FXCollections.observableArrayList();

private Admin_Product_Deteing_Dao dao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            dao = new Admin_Product_Deteing_Dao();

        
                /////-------------PRODUCT DETIALS---------------//////

        
    col_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_productname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    col_model.setCellValueFactory(new PropertyValueFactory<>("PriductModel"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("ProductSize"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    col_openigstock.setCellValueFactory(new PropertyValueFactory<>("OpeningStock"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
        /////-------------BLOCK DETIALS---------------//////
    
    col_serial1.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_productname1.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    col_model1.setCellValueFactory(new PropertyValueFactory<>("PriductModel"));
    col_size1.setCellValueFactory(new PropertyValueFactory<>("ProductSize"));
    col_price1.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount1.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    col_openigstock1.setCellValueFactory(new PropertyValueFactory<>("OpeningStock"));
    col_date1.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time1.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
        /////-------------DLETEING DETIALS---------------//////
    
    col_serial2.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_productname2.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    col_model2.setCellValueFactory(new PropertyValueFactory<>("PriductModel"));
    col_size2.setCellValueFactory(new PropertyValueFactory<>("ProductSize"));
    col_price2.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount2.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    col_openigstock2.setCellValueFactory(new PropertyValueFactory<>("OpeningStock"));
    col_date2.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time2.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
    
    }  
    private void hideAllTables() {
    tableview_totalproduct.setVisible(false);
    tableview_BlockDeletials.setVisible(false);
    tableview_DeleteDetials.setVisible(false);
}

   @FXML
private void ProductDetials(ActionEvent event) {
    
    
String title = "PRODUCT DETIALS";

label_titiel.setText(title);

    hideAllTables();

    Admin_Product_Deteing_Dao dao = new Admin_Product_Deteing_Dao();

    tableview_totalproduct.setVisible(true);
    list = dao.Admin_Product_Deteals();
    tableview_totalproduct.setItems(list);

    label_totalproduct.setText(String.valueOf(list.size()));
}
@FXML
private void BlockDetials(ActionEvent event) {
    
    String title = "PRODUCT BLOCK DETIALS";
    
    label_titiel.setText(title);

    hideAllTables();

    Admin_Product_Deteing_Dao dao = new Admin_Product_Deteing_Dao();

    tableview_BlockDeletials.setVisible(true);
    tableview_BlockDeletials.setItems(dao.Admin_Product_BlockDetials());
   
}

@FXML
private void DeleteDetials(ActionEvent event) {
    
    String title ="PRODUCT DELETE DETIALS";
    
    label_titiel.setText(title);

    hideAllTables();

    Admin_Product_Deteing_Dao dao = new Admin_Product_Deteing_Dao();

    tableview_DeleteDetials.setVisible(true);
    tableview_DeleteDetials.setItems(dao.Admin_Product_DeleteingDetials());
}



    @FXML
    private void Block(ActionEvent event)throws Exception{
        
        Admin_Product_Deteing_pojo userProduct = tableview_totalproduct.getSelectionModel().getSelectedItem();
       
    if (userProduct != null) {
        int Serial = userProduct.getSerial();
        String ProductName = userProduct.getProductName();
        String ProductModel  = userProduct.getPriductModel();
        String ProductSize = userProduct.getProductSize();
        double price =userProduct.getPrice();
        double Discount = userProduct.getDiscount();
        int OpeningStock = userProduct.getOpeningStock();
        String Date = userProduct.getDate();
        String Time = userProduct.getTime();
        
        System.out.println("hiii");
        
        BLOCKSELECT(ProductName, ProductModel, ProductSize);
        tableview_totalproduct.getItems().remove(userProduct);

    }
    
    }

    @FXML
    private void Clean(ActionEvent event) throws Exception{
  Admin_Product_Deteing_pojo userproduct = tableview_totalproduct.getSelectionModel().getSelectedItem();
  Admin_Product_Deteing_pojo userblock = tableview_BlockDeletials.getSelectionModel().getSelectedItem();
  Admin_Product_Deteing_pojo userdelete = tableview_DeleteDetials.getSelectionModel().getSelectedItem();
if (userproduct != null) {
    CLEANPRODUCT();
}
else if(userblock != null){
    CLEANBLOCK();
}
else if(userdelete != null){
    CLEANDELETE();
}
    }

    @FXML
    private void UnBlock(ActionEvent event)throws Exception{
        
         Admin_Product_Deteing_pojo userunblock = tableview_BlockDeletials.getSelectionModel().getSelectedItem();
       
    if (userunblock != null) {
        int Serial = userunblock.getSerial();
        String ProductName = userunblock.getProductName();
        String ProductModel  = userunblock.getPriductModel();
        String ProductSize = userunblock.getProductSize();
        double price =userunblock.getPrice();
        double Discount = userunblock.getDiscount();
        int OpeningStock = userunblock.getOpeningStock();
        String Date = userunblock.getDate();
        String Time = userunblock.getTime();
        
        System.out.println("hiii");
        
        UNBLOCKSELECT(ProductName, ProductModel, ProductSize);
        
        tableview_BlockDeletials.getItems().remove(userunblock);

    }
    }
   @FXML
private void Delete(ActionEvent event) throws Exception {

      Admin_Product_Deteing_pojo userProduct = tableview_totalproduct.getSelectionModel().getSelectedItem();
       
    if (userProduct != null) {
        int Serial = userProduct.getSerial();
        String ProductName = userProduct.getProductName();
        String ProductModel  = userProduct.getPriductModel();
        String ProductSize = userProduct.getProductSize();
        double price =userProduct.getPrice();
        double Discount = userProduct.getDiscount();
        int OpeningStock = userProduct.getOpeningStock();
        String Date = userProduct.getDate();
        String Time = userProduct.getTime();
        
        System.out.println("hiii");
        
        DELETEING_SELECT(ProductName, ProductModel, ProductSize);
        
        tableview_totalproduct.getItems().remove(userProduct);

    }
   
    }

  @FXML
private void Recovery(ActionEvent event) throws Exception {

         Admin_Product_Deteing_pojo userProduct = tableview_DeleteDetials.getSelectionModel().getSelectedItem();
       
    if (userProduct != null) {
        int Serial = userProduct.getSerial();
        String ProductName = userProduct.getProductName();
        String ProductModel  = userProduct.getPriductModel();
        String ProductSize = userProduct.getProductSize();
        double price =userProduct.getPrice();
        double Discount = userProduct.getDiscount();
        int OpeningStock = userProduct.getOpeningStock();
        String Date = userProduct.getDate();
        String Time = userProduct.getTime();
        
        System.out.println("hiii");
        
        RECOVERSELECT(ProductName, ProductModel, ProductSize);
        
        tableview_DeleteDetials.getItems().remove(userProduct);

    }
}

    @FXML
    private void Back(ActionEvent event) throws Exception{
        
          Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
    }
  public void DELETEING_SELECT(String ProductName,String ProductModel,String ProductSize)throws Exception{
      
       
    String sql = "SELECT * FROM product_insert " +
                 "WHERE product_name = ? AND model = ? AND size = ?";

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ProductName);
        ps.setString(2, ProductModel);
        ps.setString(3, ProductSize);
        
        int count = 0;
        String productnsme = "";
        String productmodel = "";
        String productsize = "";
        double price = 0;
        double discount =0;
        int openingstock =0;
        String date ="";
        String time ="";

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
              
                
              productnsme = rs.getString("product_name");
              productmodel = rs.getString("model");
              productsize =  rs.getString("size");
              price = rs.getDouble("price");
              discount = rs.getDouble("discount");
              openingstock = rs.getInt("opening_stock");
              date = rs.getString("date");
              time = rs.getString("time");
              count++;
               
        }
            
            DELETEING_INSERT(count, ProductName, productmodel, productsize, price, discount, openingstock, date, time);
        }
    }  
  }
      
  
 public void DELETEING_INSERT(int serial, String productname, String model,
                                String size, double price, double discount,
                                int stock, String date, String time) throws Exception {

    String sql =
        "INSERT INTO product_deleteing " +
        "(serial_number, productname, model, size, price, discount, openingstock, date, time) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, serial);
        ps.setString(2, productname);
        ps.setString(3, model);
        ps.setString(4, size);
        ps.setDouble(5, price);
        ps.setDouble(6, discount);
        ps.setInt(7, stock);
        ps.setString(8, date);
        ps.setString(9, time);

    }
     DELETEING_DELETE(productname, model, size);
}

   public void DELETEING_DELETE(String productname,String model,String size)throws Exception{
  
  Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM product_insert WHERE product_name = ? AND model = ? And size =?")) {

        ps.setString(1, productname);
        ps.setString(2, model);
        ps.setString(3, size);

        int num = ps.executeUpdate();

        if (num > 0) {
            deleteMsg();
        } else {
            System.out.println("USER NOT FOUND");
        }
    }
   }  
  public void RECOVERSELECT(String ProductName ,String ProductModel,String ProductSize)throws Exception{
  
          

    String sql = "SELECT * FROM product_deleteing " +
                 "WHERE Productname = ? AND model = ? AND size = ?";

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ProductName);
        ps.setString(2, ProductModel);
        ps.setString(3, ProductSize);
        
        int count = 0;
        String productnsme = "";
        String productmodel = "";
        String productsize = "";
        double price = 0;
        double discount =0;
        int openingstock =0;
        String date ="";
        String time ="";

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
              
              productnsme = rs.getString("Productname");
              productmodel = rs.getString("model");
              productsize =  rs.getString("size");
              price = rs.getDouble("price");
              discount = rs.getDouble("discount");
              openingstock = rs.getInt("openingstock");
              date = rs.getString("date");
              time = rs.getString("time");
              count++;
               
        }
            System.out.println("price : "+ price);
            RECOVERY_INSERT(ProductName, ProductModel, ProductSize, price, discount, openingstock, date, time);
        }
    }  
      
  }
  
  public void RECOVERY_INSERT(String productname ,String model,String size,double price,double discount,int stock,String date,String time)throws Exception{
      
       Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO product_insert " +
            "(product_name, model, size, price, discount,opening_stock,date,time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? ,? )")) {
        
        ps.setString(1,productname);
        ps.setString(2,model);
        ps.setString(3,size );
        ps.setDouble(4,price);
        ps.setDouble(5, discount);
        ps.setInt(6,stock);
        ps.setString(7,date);
        ps.setString(8,time);
      

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("next page price");      
            RECOVERY_DELETE(productname, model, size);
        } 
        else {
            System.out.println("Not inserted");
        }
    }
  
  
  }
  public void RECOVERY_DELETE(String productname,String model,String size)throws Exception{
  
  Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM product_insert WHERE product_name = ? AND model = ? And size =?")) {

        ps.setString(1, productname);
        ps.setString(2, model);
        ps.setString(3, size);

        int num = ps.executeUpdate();

        if (num > 0) {
            recoveryMsg();
        } else {
            System.out.println("USER NOT FOUND");
        }
    }
  }
  
  public void BLOCKSELECT(String ProductName,String ProductModel ,String ProductSize)throws Exception{
  
      String sql = "SELECT * FROM product_insert " +
                 "WHERE product_name = ? AND model = ? AND size = ?";

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ProductName);
        ps.setString(2, ProductModel);
        ps.setString(3, ProductSize);
        
        int count = 0;
        String productnsme = "";
        String productmodel = "";
        String productsize = "";
        double price = 0;
        double discount =0;
        int openingstock =0;
        String date ="";
        String time ="";

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
              
                
              productnsme = rs.getString("product_name");
              productmodel = rs.getString("model");
              productsize =  rs.getString("size");
              price = rs.getDouble("price");
              discount = rs.getDouble("discount");
              openingstock = rs.getInt("opening_stock");
              date = rs.getString("date");
              time = rs.getString("time");
              count++;
               
        }
                 System.out.println("Hiii");
   
            BLOCK_INSERT(count, ProductName, productmodel, productsize, price, discount, openingstock, date, time);
        }
    }  
  }
  
  public void BLOCK_INSERT(int serial,String productname,String model,String size,double price,double discount,int stock ,String date,String time)throws Exception{
   String sql =
        "INSERT INTO product_blocks " +
        "(serial_number, productname, model, size, price, discount, openingstock, date, time) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, serial);
        ps.setString(2, productname);
        ps.setString(3, model);
        ps.setString(4, size);
        ps.setDouble(5, price);
        ps.setDouble(6, discount);
        ps.setInt(7, stock);
        ps.setString(8, date);
        ps.setString(9, time);
        
        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("next page price");      
            BLOCK_DELETE(productname, model, size);
        } 
        else {
            System.out.println("Not block");
        }
    }
  

    
}
    
public void BLOCK_DELETE(String productname,String model ,String size)throws Exception{

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM product_insert WHERE product_name = ? AND model = ? And size =?")) {

        ps.setString(1, productname);
        ps.setString(2, model);
        ps.setString(3, size);

        int num = ps.executeUpdate();

        if (num > 0) {
            blockMsg();
        } else {
            System.out.println("USER NOT FOUND");
        }
    }

} 
public void UNBLOCKSELECT(String ProductName,String ProductModel,String ProductSize)throws Exception{

    String sql = "SELECT * FROM product_blocks " +
                 "WHERE Productname = ? AND model = ? AND size = ?";

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ProductName);
        ps.setString(2, ProductModel);
        ps.setString(3, ProductSize);
        
        int count = 0;
        String productnsme = "";
        String productmodel = "";
        String productsize = "";
        double price = 0;
        double discount =0;
        int openingstock =0;
        String date ="";
        String time ="";

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
              
              productnsme = rs.getString("Productname");
              productmodel = rs.getString("model");
              productsize =  rs.getString("size");
              price = rs.getDouble("price");
              discount = rs.getDouble("discount");
              openingstock = rs.getInt("openingstock");
              date = rs.getString("date");
              time = rs.getString("time");
              count++;
               
        }
            System.out.println("price : "+ price);
            UNBLOCK_INSERT(ProductName, productmodel, productsize, price, discount, openingstock, date, time);        }
    }  
      
}
public void UNBLOCK_INSERT(String productname ,String model,String size,double price,double discount,int stock,String date,String time)throws Exception{

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
            "INSERT INTO product_insert " +
            "(product_name, model, size, price, discount,opening_stock,date,time) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? ,? )")) {
        
        ps.setString(1,productname);
        ps.setString(2,model);
        ps.setString(3,size );
        ps.setDouble(4,price);
        ps.setDouble(5, discount);
        ps.setInt(6,stock);
        ps.setString(7,date);
        ps.setString(8,time);
      

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("next page price");      
            UNBLOCK_DELETE(productname, model, size);
        } 
        else {
            System.out.println("Not inserted");
        }
    }
}
public void UNBLOCK_DELETE(String productname,String model,String size)throws Exception{

    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "DELETE FROM product_blocks WHERE Productname = ? AND model = ? And size =?")) {

        ps.setString(1, productname);
        ps.setString(2, model);
        ps.setString(3, size);

        int num = ps.executeUpdate();

        if (num > 0) {
            unblockMsg();
        } else {
            System.out.println("USER NOT FOUND");
        }
    }
}
public void CLEANPRODUCT()throws Exception{
    
    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "TRUNCATE TABLE product_insert")) {

        int num = ps.executeUpdate();

        if (num > 0) {
        CLEANPRODUCT_Msg();
        } 
    }

}
public void CLEANBLOCK()throws Exception{
    
    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "TRUNCATE TABLE product_blocks")) {

        int num = ps.executeUpdate();

        if (num > 0) {
       CLEANBLOCKDETIALS_Msg();
        } 
    }

}  
public void CLEANDELETE()throws Exception{
    
    Class.forName(PN_Dao_Paroperty.driver);

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

         PreparedStatement ps = con.prepareStatement(
             "TRUNCATE TABLE product_deleteing")) {

        int num = ps.executeUpdate();

        if (num > 0) {
         DELETEDETIALS_Msg();
        } 
    }

}
  
   public boolean deleteMsg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("DELETE CONFIRMATION");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Do you really want to delete this data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #ff4d4d, #b30000);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("YES", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("NO", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
 public boolean recoveryMsg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("RECOVERY CONFIRMATION");
    alert.setHeaderText("Restore Product?");
    alert.setContentText("Do you want to recover this deleted data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32);" + // Green gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("RECOVER", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("CANCEL", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
    public boolean blockMsg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("BLOCK CONFIRMATION");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Do you really want to block this data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #ff4d4d, #b30000);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("YES", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("NO", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
 public boolean unblockMsg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("UNBLOCK CONFIRMATION");
    alert.setHeaderText("Restore Product?");
    alert.setContentText("Do you want to recover this unblock data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32);" + // Green gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("UNBLOCK", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("CANCEL", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;

 }
 public boolean CLEANPRODUCT_Msg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("PRODUCTS CONFIRMATION");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Do you really want to products this data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #ff4d4d, #b30000);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("YES", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("NO", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
public boolean CLEANBLOCKDETIALS_Msg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("BLOCK DETIALS CONFIRMATION");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Do you really want to block detials this data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #ff4d4d, #b30000);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("YES", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("NO", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
public boolean DELETEDETIALS_Msg() {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("DELETE DETIALS CONFIRMATION");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Do you really want to delete detials this data?");

    alert.getDialogPane().setStyle(
        "-fx-background-color: linear-gradient(to bottom, #ff4d4d, #b30000);" + // Red gradient
        "-fx-font-size: 14px;" +
        "-fx-font-weight: bold;" +
        "-fx-font-family: 'Segoe UI Semibold';" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 10;" +
        "-fx-padding: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 6, 0, 0, 2);"
    );

    ButtonType yesBtn = new ButtonType("YES", ButtonBar.ButtonData.YES);
    ButtonType noBtn  = new ButtonType("NO", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(yesBtn, noBtn);

    return alert.showAndWait().get() == yesBtn;
}
}
