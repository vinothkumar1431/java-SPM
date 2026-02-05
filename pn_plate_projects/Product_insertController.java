package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.util.converter.*;
import pn_plate_projects.Product_insert_Dao;
        
public class Product_insertController implements Initializable {

    @FXML private TableView<Product_insert_pojo> table;
    @FXML private TableColumn<Product_insert_pojo, Integer> cal_id;
    @FXML private TableColumn<Product_insert_pojo, String> cal_productname;
    @FXML private TableColumn<Product_insert_pojo, String> cal_model;
    @FXML private TableColumn<Product_insert_pojo, String> cal_size;
    @FXML private TableColumn<Product_insert_pojo, Double> cal_price;
    @FXML private TableColumn<Product_insert_pojo, Double> cal_discount;
    @FXML private TableColumn<Product_insert_pojo, Integer> cal_openingstock;

    @FXML private Button bt_home;
    @FXML private Button bt_add;
    @FXML private Button bt_update;
    
    @FXML private Label label_insertproduct;

    private ObservableList<Product_insert_pojo> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table.setEditable(true);
        table.setVisible(true);   

        // ===== PRODUCT NAME =====
        cal_productname.setCellValueFactory(d -> d.getValue().prodectNameProperty());
        cal_productname.setCellFactory(TextFieldTableCell.forTableColumn());
        cal_productname.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setProdectName(e.getNewValue());
            addNewRowIfLast(item);
        });

        // ===== MODEL =====
        cal_model.setCellValueFactory(d -> d.getValue().modelProperty());
        cal_model.setCellFactory(TextFieldTableCell.forTableColumn());
        cal_model.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setModel(e.getNewValue());
            addNewRowIfLast(item);
        });

        // ===== SIZE =====
        cal_size.setCellValueFactory(d -> d.getValue().sizeProperty());
        cal_size.setCellFactory(TextFieldTableCell.forTableColumn());
        cal_size.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setSize(e.getNewValue());
            addNewRowIfLast(item);
        });

        // ===== PRICE =====
        cal_price.setCellValueFactory(d -> d.getValue().priceProperty().asObject());
        cal_price.setCellFactory(
                TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        cal_price.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setPrice(e.getNewValue());
            addNewRowIfLast(item);
        });
        
        // ===== DISCOUNT =====
        cal_discount.setCellValueFactory(d -> d.getValue().discountProperty().asObject());
        cal_discount.setCellFactory(
                TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        cal_discount.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setDiscount(e.getNewValue());
            addNewRowIfLast(item);
        });

        // ===== OPENING STOCK =====
        cal_openingstock.setCellValueFactory(
                d -> d.getValue().openingProductProperty().asObject());
        cal_openingstock.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        cal_openingstock.setOnEditCommit(e -> {
            Product_insert_pojo item = e.getRowValue();
            item.setOpeningProduct(e.getNewValue());
            addNewRowIfLast(item);
        });

        list = FXCollections.observableArrayList();
        table.setItems(list);
        list.add(new Product_insert_pojo());
        
        System.out.println(list);

    }

    // ===== ADD BUTTON =====
@FXML
private void Add(ActionEvent event) {

    Product_insert_Dao dao = new Product_insert_Dao();

    for (Product_insert_pojo p : table.getItems()) {

        // empty row skip
        if (p.getProdectName() == null || p.getProdectName().isEmpty()) {
            continue;
        }

        try {
            dao.insertProduct(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    System.out.println("All products inserted");
}


    

 

    // ===== HOME BUTTON =====
    @FXML
    private void Home(ActionEvent event) {

    }

    // ===== UPDATE BUTTON (future use) =====
    @FXML
    private void Update(ActionEvent event) {
        System.out.println("Update clicked");
    }

    // ===== EXCEL STYLE AUTO ROW =====
    private void addNewRowIfLast(Product_insert_pojo item) {

        if (list.indexOf(item) == list.size() - 1) {
            list.add(new Product_insert_pojo());
        }
    }
    public void insert(String insert){
    
    label_insertproduct.setText(insert);
    }
}
