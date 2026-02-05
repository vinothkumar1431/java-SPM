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
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class New_Bill_ModelController implements Initializable {

    @FXML
    private AnchorPane anchorpane_pane;
    @FXML
    private Label label_customer;
    @FXML
    private Label labele_bill_id;
    @FXML
    private Label labele_date;
    @FXML
    private Label labele_c_contact;
    @FXML
    private Label labele_time;
    @FXML
    private CheckBox check_box;
    @FXML
    private TableView<New_model_table_1_pojo> table_view;
    @FXML
    private TableColumn<New_model_table_1_pojo, Integer> tableview_s_no;
    @FXML
    private TableColumn<New_model_table_1_pojo, String> tableview_product_name;
    @FXML
    private TableColumn<New_model_table_1_pojo, String> tableview_productmodel;
    @FXML
    private TableColumn<New_model_table_1_pojo, String> tableview_productsize;
    @FXML
    private TableColumn<New_model_table_1_pojo, Integer> tableview_qty;
    @FXML
    private TableColumn<New_model_table_1_pojo, Double> tableview_discount;
    @FXML
    private TableColumn<New_model_table_1_pojo, Double> tableview_price;
    @FXML
    private TableColumn<New_model_table_1_pojo, Double> tableview_amount;
    
      private ObservableList<New_model_table_1_pojo> billList =
            FXCollections.observableArrayList();
    @FXML
    private Label lable_sub_total;
    @FXML
    private Label labele_total;
    @FXML
    private Label tableview_received;
    @FXML
    private Label tableview_paidamount;
    @FXML
    private Label tableview_balance;
    
    private int billId;
    private String time_1;
    private String date_1;
    private double total_amount;
    private int Opening_Stock;
    private int Quntity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         tableview_s_no.setCellValueFactory(
                new PropertyValueFactory<>("serial"));
        tableview_product_name.setCellValueFactory(
                new PropertyValueFactory<>("product_name"));
        tableview_productmodel.setCellValueFactory(
                new PropertyValueFactory<>("product_model"));
        tableview_productsize.setCellValueFactory(
                new PropertyValueFactory<>("product_size"));
        tableview_qty.setCellValueFactory(
                new PropertyValueFactory<>("qty"));
        tableview_discount.setCellValueFactory(
                new PropertyValueFactory<>("discount"));
        tableview_price.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        tableview_amount.setCellValueFactory(
                new PropertyValueFactory<>("amount"));
        
        

        table_view.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try {
            loadLastBillId();//1
            loadTableData();//2
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
 private void loadLastBillId() throws Exception {

        Class.forName(PN_Dao_Paroperty.driver);

        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT bill_id FROM bill_amounts ORDER BY bill_id DESC LIMIT 1");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                billId = rs.getInt(1);
                labele_bill_id.setText(String.valueOf(billId));
                
                loadLastamount(billId);
                
                System.out.println("Bills Id :" + billId);
            }
        }
    }  
 private void loadLastamount(int ids) throws Exception {
    Class.forName(PN_Dao_Paroperty.driver);

    String sql = "SELECT date, time, customer_name, customer_number, total, sub_total, paid_amount, balance_amount, received " +
                 "FROM bill_amounts WHERE bill_id = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, ids);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                 date_1 = rs.getString("date");
                 time_1 = rs.getString("time");
                String customerName_1 = rs.getString("customer_name");
                long customerNumber_1 = rs.getLong("customer_number");
                total_amount = rs.getDouble("total");
                double subTotal_1 = rs.getDouble("sub_total");
                double paidAmount_1 = rs.getDouble("paid_amount");
                double balanceAmount_1 = rs.getDouble("balance_amount");
                double received_1 = rs.getDouble("received");

                // Use the values as needed
               System.out.println("Customer: " + customerName_1 + ", Total: " + total_amount);
                
                labele_date.setText(date_1);
                labele_time.setText(time_1);
                label_customer.setText(customerName_1);
                labele_c_contact.setText(String.valueOf(customerNumber_1));
                labele_total.setText(String.valueOf(total_amount));
                lable_sub_total.setText(String.valueOf(subTotal_1));
                tableview_paidamount.setText(String.valueOf(paidAmount_1));
                tableview_balance.setText(String.valueOf(balanceAmount_1));
                tableview_received.setText(String.valueOf(received_1));
                  // Auto print after table load
 
              
            }
        }
    }
}

        

    // ==================================================
    // LOAD TABLE DATA
    // ==================================================
   private void loadTableData() throws Exception {

    New_Model_Bill_Dao dao = new New_Model_Bill_Dao();
    billList = dao.table_views(billId);

    table_view.setItems(billList);

    table_view.refresh();
    table_view.applyCss();
    table_view.layout();
}




 public void resipt() throws Exception {
     
     user_bill_print();

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job == null) {
        System.out.println("❌ No printer found");
        return;
    }

    Stage stage = (Stage) anchorpane_pane.getScene().getWindow();

    if (job.showPrintDialog(stage)) {

        WritableImage snapshot = anchorpane_pane.snapshot(null, null);
        ImageView imageView = new ImageView(snapshot);

        PageLayout layout = job.getPrinter().getDefaultPageLayout();

        double scaleX = layout.getPrintableWidth() / snapshot.getWidth();
        double scaleY = layout.getPrintableHeight() / snapshot.getHeight();
        double scale = Math.min(scaleX, scaleY);

        imageView.setScaleX(scale);
        imageView.setScaleY(scale);

        job.printPage(imageView);
        job.endJob();

        System.out.println("✅ Receipt printed");
    }
}
    public void printBill() throws Exception {
        
        user_bill_print();

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null) {

            // Print dialog open
            boolean proceed = printerJob.showPrintDialog(
                    anchorpane_pane.getScene().getWindow()
            );

            if (proceed) {

                // A4 page setup
                PageLayout pageLayout = printerJob.getPrinter().createPageLayout(
                        Paper.A4,
                        PageOrientation.PORTRAIT,
                        Printer.MarginType.DEFAULT
                );

                // Print AnchorPane (Bill)
                boolean printed = printerJob.printPage(pageLayout, anchorpane_pane);

                if (printed) {
                    printerJob.endJob();
                }
            }
        }
    }
    private void autoPrintThermal() throws Exception {
        
    PrinterJob job = PrinterJob.createPrinterJob();
    if (job == null) {
        System.out.println("❌ No printer found");
        return;
    }

    Stage stage = (Stage) anchorpane_pane.getScene().getWindow();

    if (job.showPrintDialog(stage)) {

        PageLayout pageLayout = job.getPrinter()
                .getDefaultPageLayout();

        double scaleX = pageLayout.getPrintableWidth() / anchorpane_pane.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / anchorpane_pane.getBoundsInParent().getHeight();
        double scale = Math.min(scaleX, scaleY);

        Scale scaleTransform = new Scale(scale, scale);
        anchorpane_pane.getTransforms().add(scaleTransform);

        boolean success = job.printPage(anchorpane_pane);

        if (success) {
            job.endJob();
            System.out.println("✅ Full receipt printed");
        }

        anchorpane_pane.getTransforms().remove(scaleTransform);
    }

    }
@FXML
private void box(ActionEvent event) throws Exception {
    user_bill_print();
    Out_bill_data();
    autoPrintThermal();
    Selects();
}
  public void user_bill_print() throws Exception{
  
    Class.forName(PN_Dao_Paroperty.driver);
    try (Connection con = DriverManager.getConnection(
             PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
             PN_Dao_Paroperty.user,
             PN_Dao_Paroperty.pass);
        PreparedStatement ps = con.prepareStatement("INSERT INTO printing_billing(bill_id,bill_time,bill_date) VALUES (?,?,?)")) {

        ps.setInt(1,billId);
        ps.setString(2,time_1);
        ps.setString(3, date_1);
        int num = ps.executeUpdate();

        if (num > 0){
            System.out.println("✅ UserBill_Printing inserted:");
        }   else{
            System.out.println("❌ Not inserted");
        }
    }
  }
   private void Out_bill_data()throws Exception{
       
  String id = String.valueOf(billId);

LocalTime time = LocalTime.now();
String Out_time = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

LocalDate date = LocalDate.now();
String Out_date = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

String user = PN_Dao.name;
String pass = PN_Dao.pass1;

Class.forName(PN_Dao_Paroperty.driver);

String sql = "INSERT INTO user_working(username, password, billId, billing_time, billing_amount) VALUES (?,?,?,?,?)";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1, user);
    ps.setString(2, pass);
    ps.setString(3, id);
    ps.setString(4, Out_time);
    ps.setDouble(5, total_amount);

    int num = ps.executeUpdate();

    if (num > 0) {
        System.out.println("✅ Data inserted successfully");
    } else {
        System.out.println("❌ Insert failed");
    }
}

}
  public void Selects() throws Exception {

        Class.forName(PN_Dao_Paroperty.driver);

        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);

             PreparedStatement ps = con.prepareStatement(
                     "SELECT product_name, product_model, product_size, " +
                     "qut FROM rr_table WHERE bill_id = ? ")) {

            ps.setInt(1, billId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                String Producname = rs.getString("product_name");
                String Producmodel = rs.getString("product_model");
                String Productsize = rs.getString("product_size");
                int quntity = rs.getInt("qut");
                         
                    openingStock_Select(Producname, Producmodel, Productsize,quntity);
                }
            }
        }


    }   
public void openingStock_Select(String ProductName,String ProductModel, String ProductSize,int qut) throws Exception {

    String sql = "SELECT opening_stock FROM product_insert " +
                 "WHERE product_name = ? AND model = ? AND size = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ProductName);
        ps.setString(2, ProductModel);
        ps.setString(3, ProductSize);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Opening_Stock = rs.getInt("opening_stock");

            Quntity = Opening_Stock - qut; 

            openingStock_Update(ProductName, ProductModel, ProductSize);
        }
    }
}

public void openingStock_Update(String productname,String ProductModel,String ProductSize) {

    String sql = "UPDATE product_insert SET opening_stock = ? " +
                 "WHERE product_name = ? AND model = ? AND size = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, Quntity);          // new opening stock
        ps.setString(2, productname);
        ps.setString(3, ProductModel);
        ps.setString(4, ProductSize);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
  public void nextpage()throws Exception{
  
  
  }
}
