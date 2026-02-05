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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Product_UpdatesController implements Initializable {

    @FXML
    private AnchorPane anchor_pane;
    @FXML
    private TableView<Admin_Product_Updat_pojo> tableview_updete;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, Integer> col_serial;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, String> clo_produtname;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, String> col_model;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, String> col_size;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, Double> col_price;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, Double> col_discount;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, Integer> col_openstock;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, String> col_date;
    @FXML
    private TableColumn<Admin_Product_Updat_pojo, String> col_time;
    @FXML
    private TextField txt_productname;
    @FXML
    private TextField txt_model;
    @FXML
    private TextField txt_openingstock;
    @FXML
    private TextField txt_discount;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_date;
    @FXML
    private TextField txt_size;
    @FXML
    private TextField txt_time;
    @FXML
    private Button bt_home;
    @FXML
    private Button bt_update;
    @FXML
    private Button bt_back;
    @FXML
    private Button bt_select;
    @FXML
    private Label label_serial;
    
    private Admin_Product_update_Dao dao = new Admin_Product_update_Dao();
    
   private int  Id = 0;

    // Working table visible pannitu data load
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    col_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
    clo_produtname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    col_model.setCellValueFactory(new PropertyValueFactory<>("ProductModel"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("ProductSize"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    col_openstock.setCellValueFactory(new PropertyValueFactory<>("OpeningStock"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
        tableview_updete.setVisible(true);
       tableview_updete.setItems(dao.Admin_Product_Deteals());

    
    }    

    @FXML
    private void ProductName(ActionEvent event) {
    }

    @FXML
    private void Model(ActionEvent event) {
    }

    @FXML
    private void OpeningStock(ActionEvent event) {
    }

    @FXML
    private void Discount(ActionEvent event) {
    }

    @FXML
    private void Price(ActionEvent event) {
    }

    @FXML
    private void Date(ActionEvent event) {
    }

    @FXML
    private void Size(ActionEvent event) {
    }

    @FXML
    private void Time(ActionEvent event) {
    }

    @FXML
    private void Home(ActionEvent event) {
    }
    
    @FXML
    private void Select(ActionEvent event) {
        
   Admin_Product_Updat_pojo Product = tableview_updete.getSelectionModel().getSelectedItem();
   
   int Serial = Product.getSerial();
   String Productname = Product.getProductName();
   String Productmodel = Product.getProductModel();
   String Productsize = Product.getProductSize();
   double Price = Product.getPrice();
   double Discount = Product.getDiscount();
   int Openingstock = Product.getOpeningStock();
   String Date = Product.getDate();
   String Time = Product.getTime();
   
   label_serial.setText(String.valueOf(Serial));
   txt_productname.setText(Productname);
   txt_model.setText(Productmodel);   
   txt_size.setText(Productsize);
   txt_price.setText(String.valueOf(Price));
   txt_discount.setText(String.valueOf(Discount));
   txt_openingstock.setText(String.valueOf(Openingstock));
   txt_date.setText(Date);
   txt_time.setText(Time);
      
    }

    @FXML
    private void Update(ActionEvent event)throws Exception{
   
   int id = Integer.parseInt(label_serial.getText());
   String Productname = txt_productname.getText();
   String Productmodel = txt_model.getText();
   String Productsize = txt_size.getText();
   double price = Double.valueOf(txt_price.getText());
   double Discount = Double.valueOf(txt_discount.getText()); 
   int Openingstock = Integer.valueOf(txt_openingstock.getText());
   String Date = txt_date.getText();
   String Time =txt_time.getText();
   
        UPDATEPRODUCT(id, Productname, Productmodel, Productsize, price, Discount);

    }

    @FXML
    private void Back(ActionEvent event) {
    }
    
    public void UPDATEPRODUCT(int id,String productName, String model,String size,double price,double discount) throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    String sql ="UPDATE product_insert SET product_name = ?, model = ?, size = ?, " +
        "price = ?, discount = ? WHERE id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, productName);
        ps.setString(2, model);
        ps.setString(3, size);
        ps.setDouble(4, price);
        ps.setDouble(5, discount);
        ps.setInt(6, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            clear();

        } else {
      
        }
    }
}
    

public void clear()throws Exception{

label_serial.setText("");
txt_productname.clear();
txt_model.clear();
txt_size.clear();
txt_price.clear();
txt_discount.clear();
txt_openingstock.clear();
txt_date.clear();
txt_time.clear();
}
}
   
    

