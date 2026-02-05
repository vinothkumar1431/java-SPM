/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Newstock_DetialsController implements Initializable {

    @FXML
    private AnchorPane anchor_pane;
    @FXML
    private TableView<NewStock_Detials_pojo> tableview_newstock;
    @FXML
    private TableColumn<NewStock_Detials_pojo, Integer> clo_serial;
    @FXML
    private TableColumn<NewStock_Detials_pojo, String> col_productname;
    @FXML
    private TableColumn<NewStock_Detials_pojo, String> clo_model;
    @FXML
    private TableColumn<NewStock_Detials_pojo, String> col_size;
    @FXML
    private TableColumn<NewStock_Detials_pojo, Double> col_price;
    @FXML
    private TableColumn<NewStock_Detials_pojo, Double> col_discount;
    @FXML
    private TableColumn<NewStock_Detials_pojo, Integer> col_oldstock;
    @FXML
    private TableColumn<NewStock_Detials_pojo, Integer> col_newstock;
    @FXML
    private TableColumn<NewStock_Detials_pojo, String> col_date;
    @FXML
    private TableColumn<NewStock_Detials_pojo, String> col_time;
    @FXML
    private Button bt_back;
    @FXML
    private Button bt_delete;
    
    private ObservableList<NewStock_Detials_pojo> list = FXCollections.observableArrayList();

    private NewStock_Dao dao = new NewStock_Dao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    clo_serial.setCellValueFactory(new PropertyValueFactory<>("Serial"));
    col_productname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
    clo_model.setCellValueFactory(new PropertyValueFactory<>("Model"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("Size"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
    col_discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
    col_oldstock.setCellValueFactory(new PropertyValueFactory<>("OldStock"));
    col_newstock.setCellValueFactory(new PropertyValueFactory<>("NewStock"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    
       try { 
            list = dao.NEWSTOCk_SELECTED();
            tableview_newstock.setItems(list);  
        } catch (Exception ex) {
            Logger.getLogger(New_StockUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    

    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void Delete(ActionEvent event)throws Exception{
        
     NewStock_Detials_pojo user = tableview_newstock.getSelectionModel().getSelectedItem();
     
     int id = user.getSerial();
        
       
       NewStock_Dao value = new NewStock_Dao();
       
       value.STOCK_DELETE(id);
       
    list = dao.NEWSTOCk_SELECTED();
    tableview_newstock.setItems(list);  
    }
    
}
