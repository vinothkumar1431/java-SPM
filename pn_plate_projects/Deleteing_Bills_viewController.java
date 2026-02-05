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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class Deleteing_Bills_viewController implements Initializable {

    @FXML
    private AnchorPane anchorpane_billdelete;
    @FXML
    private TableView<Deleteing_Bills_view_pojo> tableview_billdelete;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Integer> col_id;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, String> col_castomername;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Long> col_mobile;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, String> col_date;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, String> col_time;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_amount;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_paidamount;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_subtotal;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_receied;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_total;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, Double> col_balance;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, String> col_deletedate;
    @FXML
    private TableColumn<Deleteing_Bills_view_pojo, String> col_daletetime;
    @FXML
    private Button bt_home;

     ObservableList<Deleteing_Bills_view_pojo> list = FXCollections.observableArrayList();

     Deleteing_Bills_view_Dao Bills = new Deleteing_Bills_view_Dao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    col_id.setCellValueFactory(new PropertyValueFactory<>("Billid"));
    col_castomername.setCellValueFactory(new PropertyValueFactory<>("CastomerName"));
    col_mobile.setCellValueFactory(new PropertyValueFactory<>("MobileNumber"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    col_amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    col_paidamount.setCellValueFactory(new PropertyValueFactory<>("PaidAmount"));
    col_subtotal.setCellValueFactory(new PropertyValueFactory<>("SubTotal"));
    col_receied.setCellValueFactory(new PropertyValueFactory<>("Receied"));
    col_total.setCellValueFactory(new PropertyValueFactory<>("Total"));
    col_balance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
    col_deletedate.setCellValueFactory(new PropertyValueFactory<>("DeleteingDate"));
    col_daletetime.setCellValueFactory(new PropertyValueFactory<>("DeleteingTime"));
    
        try {
            
            list = Bills.Deleteing_Bills_Deteals();
            tableview_billdelete.setItems(list);

        } catch (Exception ex) {
            Logger.getLogger(Deleteing_Bills_viewController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @FXML
    private void Home(ActionEvent event) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Admin_intro_page.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
    }
    
}
