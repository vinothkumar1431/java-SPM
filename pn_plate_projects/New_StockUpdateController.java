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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static pn_plate_projects.PN_Main.stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class New_StockUpdateController implements Initializable {

    @FXML
    private AnchorPane anchorpan;
    @FXML
    private TableView<Admin_Product_Deteing_pojo> tableview_stock;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> col_serial;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productname;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productmodel;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_productsize;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_price;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Double> col_discount;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, Integer> clo_opeingstock;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> col_date;
    @FXML
    private TableColumn<Admin_Product_Deteing_pojo, String> clo_time;
    @FXML
    private TextField txt_oldstock;
    @FXML
    private TextField txt_newstock;
    @FXML
    private Button bt_select;
    @FXML
    private Button bt_stockdetials;
    @FXML
    private Button bt_conform;
    @FXML
    private Button bt_back;
    
    private int Serial;
    private String ProductName; 
    private String ProductModel;
    private String ProductSize;
    private double price;
    private double Discount;
    private String Date;
    private String Time;

    private ObservableList<Admin_Product_Deteing_pojo> list = FXCollections.observableArrayList();

    private Product_Newstock_Dao dao = new Product_Newstock_Dao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
                /////-------------PRODUCT DETIALS---------------//////

        
    col_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col_productname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    col_productmodel.setCellValueFactory(new PropertyValueFactory<>("PriductModel"));
    col_productsize.setCellValueFactory(new PropertyValueFactory<>("ProductSize"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    clo_opeingstock.setCellValueFactory(new PropertyValueFactory<>("OpeningStock"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    clo_time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
        try { 
            list = dao.NEWSTOCK_SELECT();
            tableview_stock.setItems(list);  
        } catch (Exception ex) {
            Logger.getLogger(New_StockUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
         } 

    @FXML
    private void OldStock(ActionEvent event) {
    }

    @FXML
    private void NewStock(ActionEvent event) {
    }

    @FXML
    private void Select(ActionEvent event) {
        
     Admin_Product_Deteing_pojo userProduct = tableview_stock.getSelectionModel().getSelectedItem();
       
    if (userProduct != null) {
         Serial = userProduct.getSerial();
         ProductName = userProduct.getProductName();
         ProductModel= userProduct.getPriductModel();
         ProductSize = userProduct.getProductSize();
         price =userProduct.getPrice();
         Discount = userProduct.getDiscount();
         int OpeningStock = userProduct.getOpeningStock();
         Date = userProduct.getDate();
         Time = userProduct.getTime();
        
       txt_oldstock.setText(Integer.toString(OpeningStock));
        
        
        
    }
    }

    @FXML
    private void Stock_Detials(ActionEvent event) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Newstock_Detials.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
    }

    @FXML
    private void Conform(ActionEvent event)throws Exception{
        
       String oldstock = txt_oldstock.getText();
       String newstock = txt_newstock.getText();
       
       int OldStock  = Integer.valueOf(oldstock);
       int NewStock  = Integer.valueOf(newstock);
            LocalTime time = LocalTime.now();
        String currentTime =
            time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        LocalDate date = LocalDate.now();
        String currentDate =
            date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
       
        NEWSTOCK_INSERT(OldStock, NewStock,currentDate, currentTime);
    }

    @FXML
    private void Back(ActionEvent event) throws Exception{
        
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Product_Deleteing.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
    }
   
    public void NEWSTOCK_INSERT(int oldstock,int newstock,String currentDate,String currentTime)throws Exception{
        
        
    
     String sql =
        "INSERT INTO product_newstock " +
        "(serial_number, Productname, model, size, price, discount, openingstock,newstock, date, time,insertdate,inserttime) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, Serial);
        ps.setString(2, ProductName);
        ps.setString(3, ProductModel);
        ps.setString(4, ProductSize);
        ps.setDouble(5, price);
        ps.setDouble(6, Discount);
        ps.setInt(7, oldstock);
        ps.setInt(8,newstock);
        ps.setString(9, Date);
        ps.setString(10, Time);
        ps.setString(11, currentDate);
        ps.setString(12, currentTime);

                ps.executeUpdate(); 
                
                NEWSTOCK_INSERT(newstock, Serial);

    }
    }
public void NEWSTOCK_INSERT(int newstock, int id) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String sql = "UPDATE product_insert SET opening_stock = ? WHERE id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, newstock);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            list = dao.NEWSTOCK_SELECT();
            tableview_stock.setItems(list); 
        } 
        else {
        }
    }
}

}
