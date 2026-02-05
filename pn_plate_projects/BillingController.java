/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
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
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PrintColor;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import static pn_plate_projects.PN_Main.stage;


/**
 * FXML Controller class
 *
 * @author vinot
 */
public class BillingController implements Initializable {
    @FXML
    private TableView<Billing_Data> table_view;
    @FXML
    private TableColumn<Billing_Data, String> table_name;
    @FXML
    private TableColumn<Billing_Data, String> table_prodact;
    @FXML
    private TableColumn<Billing_Data, String> table_platesize;
    @FXML
    private TableColumn<Billing_Data, Integer> table_quntity;
    @FXML
    private TableColumn<Billing_Data, Double> table_price;
    @FXML
    private TableColumn<Billing_Data, Double> table_discount;
    @FXML
    private TableColumn<Billing_Data, Double> table_amount;
    @FXML
    private TextField txt_quntity;
    @FXML
    private TextField txt_paid_amount;
    @FXML
    private TextField txt_customer;
    @FXML
    private TextField txt_contact;
    
   @FXML 
    private AnchorPane anchor_pane;
 @FXML 
    private AnchorPane anchor_top;
 @FXML 
    private AnchorPane anchor_senter;


   @FXML 
   private Label lable_bill;
   @FXML 
   private Label lable_date;
   @FXML 
   private Label lable_tamie;
   @FXML 
   private Label lable_total;
   @FXML 
   private Label labele_balance_amount;

   
    @FXML
    private Button bt_save;
    @FXML
    private Button bt_add;
    @FXML
    private Button bt_receipt;
    @FXML
    private Button bt_pay;
    @FXML
    private Button bt_close;
    
     @FXML
    private Button bt_home;
      @FXML
    private Button bt_edit;
       @FXML
    private Button bt_view;
        @FXML
    private Button bt_exit;
        
    @FXML
    private MenuButton  menu_product;
    @FXML
    private MenuButton  menu_model;
    @FXML
    private MenuButton  menu_size;
    
    private String product_name;
    private String product_model;
    private String product_size;


            
    private double totals = 0;            // Total amount
    private String currentTime = "";       // Time
    private String currentDate = "";       // Date
    private int Count_Bill =0;       // Bill number
    private int counts = 0;
    private int quntitys = 0;
    private int Opening_Stock = 0;

    
   @FXML 
    private TableView<Billing_pojo> tableView;  // MyData = your model class



    /**
     * Initializes the controller class.
     */
    
   @FXML 
    private ObservableList<Billing_Data> billdata = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
                 Bill_Dao bills = new Bill_Dao();
                 
        try {
            bills.creat();
        } catch (Exception ex) {
            Logger.getLogger(BillingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            count();
        } catch (Exception ex) {
            Logger.getLogger(BillingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table_name.setCellValueFactory(new PropertyValueFactory<>("product"));
        table_prodact.setCellValueFactory(new PropertyValueFactory<>("pro_name"));
        table_platesize.setCellValueFactory(new PropertyValueFactory<>("pro_size"));
        table_quntity.setCellValueFactory(new PropertyValueFactory<>("quntity"));
        table_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

              table_view.setItems(billdata);
              
        try {
            PRODUCTS();
        } catch (Exception ex) {
            Logger.getLogger(BillingController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
}
      @FXML
     private void ProductName(ActionEvent event) throws Exception {
         
     }
      @FXML
     private void productModel(ActionEvent event) throws Exception {
         
     }
      @FXML
     private void ProductSize(ActionEvent event) throws Exception {
         
     }
    
    
 
    @FXML
      private void add(ActionEvent event) throws Exception {
       
   
        counts=counts+1;
        
        System.out.print(counts);
        
        int Count_Bill1 = Count_Bill;
        
        
        
            Bill_Dao bills =new Bill_Dao();
 
        
       String ProductName = menu_product.getText();
       String ProductModel = menu_model.getText();
       String ProductSize = menu_size.getText();
        String qnt1 = txt_quntity.getText();
        String times = lable_tamie.getText();
        String dates =lable_date.getText();
        String totall = lable_total.getText();
        String bills_name = lable_bill.getText();
        
       int quntity= Integer.parseInt(qnt1);
       
       
        
        
   Select_amount_pojo pricesed = bills.select_data(ProductName, ProductModel, ProductSize, quntity);
    
        
   double price = pricesed.getPrice();
double discountPercent = pricesed.getDiscount();

double totalPrice = price * quntity;
double discountAmount = totalPrice * discountPercent / 100;
double finalAmount = totalPrice - discountAmount;

// 👉 ADD ITEM FIRST
Billing_Data tableda = new Billing_Data(
        ProductName,
        ProductModel,
        ProductSize,
        quntity,
        price,
        discountAmount,
        finalAmount,
        currentDate,
        currentTime,
        0
);

billdata.add(tableda);

totals = 0;
for (Billing_Data item : billdata) {
    totals += item.getAmount();
}

lable_total.setText(new DecimalFormat("#,##0.00").format(totals));

    
    
    LocalTime time = LocalTime.now();
   currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
   
       System.out.println(currentTime);

    
    lable_tamie.setText(currentTime);
    
    
LocalDate date = LocalDate.now();

currentDate= date.format(DateTimeFormatter.ISO_DATE);
lable_date.setText(currentDate);



//lable_total.setText(String.valueOf(totals));

//String sdi-
//
//String discountAmount = (discountAmount+"%");


//String discount = (discountRate * 100) + "%";
 
//      double price = priceed;
//      String discount = discouted      
            
         
       Billing_pojo bill = new Billing_pojo();
  
       bill.setProduct(ProductName);
       bill.setPro_name(ProductModel);
       bill.setPro_size(ProductSize);
       bill.setQuntity(quntity);
       bill.setPrice(price);
       bill.setDiscount(discountAmount);
       bill.setAmount(finalAmount);
       bill.setDate(currentDate);
       bill.setTime(currentTime);
       bill.setTotal(totals);
       
                

   bills.Items_Add(counts,Count_Bill1,currentDate,currentTime,ProductName,ProductModel,ProductSize,quntity,price,finalAmount, finalAmount,totals);
    }
     @FXML
private void quntity(ActionEvent event) {
    
}
      @FXML 
    private void paid_amount(ActionEvent event) {
    
    }
      @FXML 
    private void customer(ActionEvent event) {
    
    }
      @FXML 
    private void contact(ActionEvent event) {
    
    }
    
   @FXML 
    private void close(ActionEvent event) throws Exception{
          
        int select = table_view.getSelectionModel().getSelectedIndex();
        table_view.getItems().remove(select);
    }
     @FXML 
    private void pay(ActionEvent event) throws Exception {
        
    PrinterJob job = PrinterJob.createPrinterJob();
    if (job == null) {
        System.out.println("❌ No printer found");
        return;
    }

    Stage stage = (Stage) anchor_pane.getScene().getWindow();

    if (job.showPrintDialog(stage)) {

        WritableImage snapshot = anchor_pane.snapshot(null, null);
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
        @FXML 
    private void receipt(ActionEvent event) throws Exception {

    next_new();
}    

@FXML 
private void save(ActionEvent event) throws Exception{
    
String customer_name = txt_customer.getText();

String c_number = txt_contact.getText();

long customer_Number = Long.parseLong(c_number);
    
String p_a = txt_paid_amount.getText();

double p_amt = Double.parseDouble(p_a);

double balance = totals - p_amt;

double sub_total = totals;

double received = 0;

DecimalFormat df = new DecimalFormat("#0");

labele_balance_amount.setText(df.format(balance));

Bill_Dao bills = new Bill_Dao();

bills.Bill_AMT(Count_Bill, currentDate, currentTime, customer_name, customer_Number, totals, sub_total, p_amt, balance, received);

    clearBillData();

    }
          
public void count() throws Exception {
   
    
        Class.forName(PN_Dao_Paroperty.driver);
        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);
             PreparedStatement ps = con.prepareStatement(
                     "select count_number from count_table order by count_number DESC limit 1");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
               Count_Bill= rs.getInt(1);
           lable_bill.setText(String.format("%03d", Count_Bill));
           
          inset_bill_id();
                       


    
}
        }
}
 public void images_creat() throws Exception {
        
        
// AnchorPane snapshot
WritableImage snapshot = anchor_pane.snapshot(null, null);
File imageFile = new File("snapshot.png");
ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", imageFile);

// Create PDF
Document document = new Document();
PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\vinot\\OneDrive\\Documents\\NetBeansProjects\\PN_Plate_Projects\\AnchorPane.pdf"));
document.open();

// Add snapshot image to PDF
Image img = Image.getInstance("snapshot.png");
img.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getHeight());
document.add(img);

document.close();
        
    }
 public void pdf_create()throws Exception{


    try {
        // 1️⃣ Take snapshot of AnchorPane
        WritableImage snapshot = anchor_pane.snapshot(null, null);
        File imageFile = new File("snapshot.png");
        ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", imageFile);

        // 2️⃣ Create PDF
        String pdfPath = "C:\\Users\\vinot\\Documents\\AnchorPane.pdf";
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        document.open();

        // 3️⃣ Add image to PDF and scale to fit
        Image img = Image.getInstance("snapshot.png");
        img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
        img.setAlignment(Image.ALIGN_CENTER);
        document.add(img);

        document.close();

        System.out.println("PDF created successfully at: " + new File(pdfPath).getAbsolutePath());

        // 4️⃣ Auto open PDF
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }


}
    public void image_create(){
        
    try {
        // 1️⃣ Take snapshot of AnchorPane
        WritableImage snapshot = anchor_pane.snapshot(null, null);
        File imageFile = new File("snapshot.png");
        ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", imageFile);

        // 2️⃣ Create PDF
        String pdfPath = "";
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        document.open();

        // 3️⃣ Add image to PDF and scale to fit
        Image img = Image.getInstance("snapshot.png");
        img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
        img.setAlignment(Image.ALIGN_CENTER);
        document.add(img);

        document.close();

        System.out.println("PDF created successfully at: " + new File(pdfPath).getAbsolutePath());

        // 4️⃣ Auto open PDF
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }


}
     public void inset_bill_id() throws Exception{
      
   
    Class.forName(PN_Dao_Paroperty.driver);
    try (Connection con = DriverManager.getConnection(
             PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
             PN_Dao_Paroperty.user,
             PN_Dao_Paroperty.pass);
        PreparedStatement ps = con.prepareStatement("INSERT INTO bills_id(bill_id) VALUES (?)")) {

        ps.setInt(1,Count_Bill);
        int num = ps.executeUpdate();

        if (num > 0){
            System.out.println("✅ Bill name inserted:"+Count_Bill);
        }   else{
            System.out.println("❌ Not inserted");
        }
    }
    
}
       public void next_new() throws Exception{
     
      Parent root = FXMLLoader.load(getClass().getResource("New_Bill_Model.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
     
     }
      @FXML 
    private void home(ActionEvent event) {
        
    
}
      @FXML 
    private void edit(ActionEvent event) throws Exception{
        
     Parent root = FXMLLoader.load(getClass().getResource("Bills_edit.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
}    
      @FXML 
    private void view(ActionEvent event) {
        
    
}     
      @FXML 
    private void exit(ActionEvent event) throws Exception{
        
   LocalTime time = LocalTime.now();
   String Out_time= time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
   
       System.out.println("Out_Time: "+Out_time);
        
    LocalDate date = LocalDate.now();
    String Out_date = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
             
    String user = PN_Dao.name;
    String pass = PN_Dao.pass1;

 Class.forName(PN_Dao_Paroperty.driver);

    String sql = "INSERT INTO user_working(username, password ,out_time,out_date) VALUES (?,?,?,?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        // set values
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setString(3, Out_time);
        ps.setString(4, Out_date);

        int num = ps.executeUpdate();

        if (num > 0) {
            System.out.println("✅ Intime inserted");
        } else {
            System.out.println("❌ Not inserted");
        }
    }
}
    
  public void PRODUCTS() {

    String sql = "SELECT DISTINCT product_name FROM product_insert";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        menu_product.getItems().clear();

        while (rs.next()) {
            String product = rs.getString("product_name");

            MenuItem item = new MenuItem(product);
            item.setOnAction(e -> {
                menu_product.setText(product);
                product_name = product;

                MODELS(product); // load models
            });

            menu_product.getItems().add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public void MODELS(String selectedProduct) {

    String sql = "SELECT DISTINCT model FROM product_insert WHERE product_name = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, selectedProduct);
        ResultSet rs = ps.executeQuery();

        menu_model.getItems().clear();
        menu_size.getItems().clear(); // reset size

        while (rs.next()) {
            String model = rs.getString("model");

            MenuItem item = new MenuItem(model);
            item.setOnAction(e -> {
                menu_model.setText(model);
                product_model = model;

                SIZE(selectedProduct, model); // load sizes ONLY on click
            });

            menu_model.getItems().add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void SIZE(String product, String model) {

    String sql = "SELECT DISTINCT size FROM product_insert WHERE product_name = ? AND model = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, product);
        ps.setString(2, model);

        ResultSet rs = ps.executeQuery();

        menu_size.getItems().clear();

        while (rs.next()) {
            String size = rs.getString("size");

            MenuItem item = new MenuItem(size);
            item.setOnAction(e -> {
                menu_size.setText(size);
                product_size = size;
            });

            menu_size.getItems().add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void clearBillData() {

    // Table clear
    billdata.clear();

    // Reset totals
    totals = 0;
    lable_total.setText("0");
    labele_balance_amount.setText("0");

    // Clear text fields
    txt_quntity.clear();
    txt_paid_amount.clear();
    txt_customer.clear();
    txt_contact.clear();

    menu_product.setText("Product");
    menu_model.setText("Model");
    menu_size.setText("Size");

    menu_model.getItems().clear();
    menu_size.getItems().clear();

    counts = 0;
}


}
