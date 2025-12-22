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
    private SplitMenuButton view_product;
    @FXML
    private MenuItem menu_plate;
    @FXML
    private MenuItem menu_cup;
    @FXML
    private MenuItem menu_bowls;
    @FXML
    private MenuItem menu_container;
    @FXML
    private MenuItem menu_trays;
    @FXML
    private MenuItem menu_box;
    @FXML
    private MenuItem menu_spoon;
    @FXML
    private MenuItem menu_straws;
    @FXML
    private MenuItem menu_glass;
    @FXML
    private SplitMenuButton view_productname;
    @FXML
    private MenuItem menu_plainsuper;
    @FXML
    private MenuItem menu_plainpizza;
    @FXML
    private MenuItem menu_squareplain;
    @FXML
    private MenuItem menu_square;
    @FXML
    private MenuItem menu_roundcup;
    @FXML
    private MenuItem menu_squarecup;
    @FXML
    private MenuItem menu_roundcupsuper;
    @FXML
    private MenuItem menu_squarecupsuper;
    @FXML
    private MenuItem menu_classibio;
    @FXML
    private MenuItem menu_tea;
    @FXML
    private MenuItem menu_clamshell;
    @FXML
    private MenuItem menu_wooden;
    @FXML
    private MenuItem menu_round3cup;
    @FXML
    private MenuItem menu_square3cup;
    @FXML
    private MenuItem menu_square4cup;
    @FXML
    private MenuItem menu_round4cup;
    @FXML
    private MenuItem menu_roundplain3cup;
    @FXML
    private MenuItem menu_roundplain4cup;
    @FXML
    private MenuItem menu_squareplain3cup;
    @FXML
    private MenuItem menu_squareplain4cup;
    @FXML
    private MenuItem menu_lid;
    @FXML
    private MenuItem menu_3cup;
    @FXML
    private MenuItem menu_4cup;
   @FXML 
    private MenuItem menu_5cup;
   @FXML 
    private MenuItem menu_8cup;
   @FXML 
    private SplitMenuButton view_productsize;
   @FXML 
    private MenuItem menu_12inch;
   @FXML 
    private MenuItem menu_12inchxl;
   @FXML 
    private MenuItem menu_10inch;
   @FXML 
    private MenuItem menu_9inch;
   @FXML 
    private MenuItem menu_7inch;
   @FXML 
    private MenuItem menu_6inch;
   @FXML 
    private MenuItem menu_5inch;
   @FXML 
    private MenuItem menu_4inch;
   @FXML 
    private MenuItem menu_480ml;
   @FXML 
    private MenuItem menu_360ml;
   @FXML 
    private MenuItem menu_340ml;
   @FXML 
    private MenuItem menu_240ml;
   @FXML 
    private MenuItem menu_210ml;
   @FXML 
    private MenuItem menu_180ml;
   @FXML 
    private MenuItem menu_150ml;
   @FXML 
    private MenuItem menu_120ml;
   @FXML 
    private MenuItem menu_110ml;
   @FXML 
    private MenuItem menu_90ml;
   @FXML 
    private MenuItem menu_60ml;
   @FXML 
    private MenuItem menu_55ml;
   @FXML 
    private MenuItem menu_30ml;
   @FXML 
    private MenuItem menu_500ml;
   @FXML 
    private MenuItem menu_750ml;
   @FXML 
    private MenuItem menu_b2b;
   @FXML 
    private MenuItem menu_1d;
   @FXML 
    private MenuItem menu_2d;
   @FXML 
    private MenuItem menu_3d;
   @FXML 
    private MenuItem menu_5d;
   @FXML 
    private MenuItem menu_size66;
   @FXML 
    private MenuItem menu_size96;
   @FXML 
    private MenuItem menu_size99;
   @FXML 
    private MenuItem menu_size993;
   @FXML 
    private MenuItem menu_smart;
   @FXML 
    private MenuItem menu_300ml;
   @FXML 
    private MenuItem menu_size883;
   @FXML 
    private MenuItem menu_2cup;
   @FXML 
    private MenuItem menu_80mm;
   @FXML 
    private MenuItem menu_90mm;
   @FXML 
    private MenuItem menu_normelspoon;
   @FXML 
    private MenuItem menu_fork;
   @FXML 
    private MenuItem menu_knife;
   @FXML 
    private MenuItem menu_55mm210mm;
   @FXML 
    private MenuItem menu_7mm210mm;
   @FXML 
    private MenuItem menu_10mm210mm;
   @FXML 
    private MenuItem menu_7mm230mm;
   @FXML 
    private MenuItem menu_14cms16cms;
   @FXML 
    private MenuItem menu_11cm;  
    
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
            
    private double totals = 0;            // Total amount
    private String currentTime = "";       // Time
    private String currentDate = "";       // Date
    private int Count_Bill =0;       // Bill number
    private int counts = 0;
    
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


 
    }
      @FXML 
    private void product1(ActionEvent event) {
        
    
}


   @FXML 
    private void plate(ActionEvent event) {
        
        String menuplate = menu_plate.getText();
        
        view_product.setText(menuplate);
          
    }

   @FXML 
    private void cup(ActionEvent event) {
        
        String menucup = menu_cup.getText();
        
        view_product.setText(menucup);

    }

   @FXML 
    private void bowls(ActionEvent event) {
        
      String menubowls = menu_bowls.getText();
       
       view_product.setText(menubowls);

    }

   @FXML 
    private void container(ActionEvent event) {
        
        String menucontainer = menu_container.getText();
        
        view_product.setText(menucontainer);;
    }

   @FXML 
    private void trays(ActionEvent event) {
        
        String menutrays = menu_trays.getText();
        
        view_product.setText(menutrays);
    }

   @FXML 
    private void box(ActionEvent event) {
        
        String menubox = menu_box.getText();
        view_product.setText(menubox);
    }

   @FXML 
    private void spoon(ActionEvent event) {
        
        String menuspoon =  menu_spoon.getText();
       
       view_product.setText(menuspoon);
    }

   @FXML 
    private void straws(ActionEvent event) {
        
         String menustraws = menu_straws.getText();
        
        view_product.setText(menustraws);
    }

   @FXML 
    private void glass(ActionEvent event) {
        
         String menuglass = menu_glass.getText();
        
        view_product.setText(menuglass);
    }


   @FXML 
    private void add(ActionEvent event) throws Exception {
        
        counts=counts+1;
        
        System.out.print(counts);
        
        int Count_Bill1 = Count_Bill;
        
        
        
            Bill_Dao bills =new Bill_Dao();
 
        
        String products = view_product.getText();
        String pro_name = view_productname.getText();
        String pro_size = view_productsize.getText();
        String qnt1 = txt_quntity.getText();
        String times = lable_tamie.getText();
        String dates =lable_date.getText();
        String totall = lable_total.getText();
        String bills_name = lable_bill.getText();
        
        int quntity= Integer.parseInt(qnt1);
        
        
    Select_amount_pojo pricesed = bills.select_data(products, pro_name, pro_size, quntity);
    

        
     double price = pricesed.getPrice();
    
     double discountamount =0;
    
     double amount = 0;
     
   

 if (quntity <= 1000) {
        discountamount = price * quntity * 1 / 100.0;
    } else if (quntity <= 3000) {
        discountamount = price * quntity * 3 / 100.0;
    } else if (quntity <= 5000) {
        discountamount = price * quntity * 5 / 100.0;
    } else if (quntity <= 7000) {
        discountamount = price * quntity * 8 / 100.0;
    } else if (quntity <= 9000) {
        discountamount = price * quntity * 10 / 100.0;
    } else if (quntity <= 11000) {
        discountamount = price * quntity * 12 / 100.0;
    } else {
        discountamount = price * quntity * 15 / 100.0;
    }

    amount = (price * quntity) - discountamount;
    
   Billing_Data tableda = new Billing_Data(products, pro_name, pro_size, quntity, price, discountamount, amount, currentDate, currentTime, totals);

   billdata.add(tableda);


    // accumulate totals
     totals = 0;
    for (Billing_Data item : billdata) {
        totals += item.getAmount();
    }  
    DecimalFormat df = new DecimalFormat("#,##0");
    lable_total.setText(df.format(totals));
   //  lable_total.setText(String.valueOf(totals));

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
  
       bill.setProduct(products);
       bill.setPro_name(pro_name);
       bill.setPro_size(pro_size);
       bill.setQuntity(quntity);
       bill.setPrice(price);
       bill.setDiscount(discountamount);
       bill.setAmount(amount);
       bill.setDate(currentDate);
       bill.setTime(currentTime);
       bill.setTotal(totals);
       
        
     
    System.out.println(products+" , "+ "Hii kumar "+price+"  "+discountamount+"  "+amount);
        
//    Billing_Data tableda = new Billing_Data(products, pro_name, pro_size, quntity, price, discountamount, amount);
      
//    billdata.add(tableda);
    
   bills.Items_Add(counts,Count_Bill1,currentDate,currentTime,products,pro_name,pro_size,quntity,price,discountamount,amount,totals);
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
    private void close(ActionEvent event) {
        
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

      PrinterJob job = PrinterJob.createPrinterJob();
    if (job == null) {
        System.out.println("❌ No printer found");
        return;
    }

    Stage stage = (Stage) anchor_pane.getScene().getWindow();

    if (job.showPrintDialog(stage)) {

        PageLayout pageLayout = job.getPrinter()
                .getDefaultPageLayout();

        double scaleX = pageLayout.getPrintableWidth() / anchor_pane.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / anchor_pane.getBoundsInParent().getHeight();
        double scale = Math.min(scaleX, scaleY);

        Scale scaleTransform = new Scale(scale, scale);
        anchor_pane.getTransforms().add(scaleTransform);

        boolean success = job.printPage(anchor_pane);

        if (success) {
            job.endJob();
            System.out.println("✅ Full receipt printed");
        }

        anchor_pane.getTransforms().remove(scaleTransform);
    }
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

next_new();
    
    }
           @FXML 
    private void productname(ActionEvent event) {
    
    }

   @FXML 
    private void plainsuper(ActionEvent event) {
        
       
        String menuplainsuper =  menu_plainsuper.getText();
      
      view_productname.setText(menuplainsuper);
    }

   @FXML 
    private void plainpizza(ActionEvent event) {
        
        String menuplainpizza =  menu_plainpizza.getText();
       
       view_productname.setText(menuplainpizza);
    }

   @FXML 
    private void squareplain(ActionEvent event) {
        
          
       String menusquareplain =  menu_squareplain.getText();
       
       view_productname.setText(menusquareplain);
    }

   @FXML 
    private void square(ActionEvent event) {
        
         
        String menusquare = menu_square.getText();
        
        view_productname.setText(menusquare);
    }

   @FXML 
    private void roundcup(ActionEvent event) {
        
        String menuroundcup = menu_roundcup.getText();
        
        view_productname.setText(menuroundcup);
    }

   @FXML 
    private void squarecup(ActionEvent event) {
        
         String menusquarecup =  menu_squarecup.getText();
       
       view_productname.setText(menusquarecup);
    }

   @FXML 
    private void roundcupsuper(ActionEvent event) {
        
         String menuroundcupsuper =   menu_roundcupsuper.getText();
      
      view_productname.setText(menuroundcupsuper);
    }

   @FXML 
    private void squarecupsuper(ActionEvent event) {
        
        String menusquarecupsuper =  menu_squarecupsuper.getText();
       
       view_productname.setText(menusquarecupsuper);
    }

   @FXML 
    private void classibio(ActionEvent event) {
        
         String menuclassibio =  menu_classibio.getText();
      
      view_productname.setText(menuclassibio);
    }

   @FXML 
    private void tea(ActionEvent event) {
        
         String menutea = menu_tea.getText();
      
      view_productname.setText(menutea);
    }

   @FXML 
    private void clamshell(ActionEvent event) {
        
      String menuclamshell = menu_clamshell.getText();
        
        view_productname.setText(menuclamshell);
    }

   @FXML 
    private void wooden(ActionEvent event) {
        
         String menuwooden = menu_wooden.getText();
        
        view_productname.setText(menuwooden);
    }

   @FXML 
    private void round3cup(ActionEvent event) {
        
         String menuround3cup = menu_round3cup.getText();
       
       view_productname.setText(menuround3cup);
    }

   @FXML 
    private void square3cup(ActionEvent event) {
        
          String menusquare3cup = menu_square3cup.getText();
        
        view_productname.setText(menusquare3cup);
    }

   @FXML 
    private void square4cup(ActionEvent event) {
        
        String menusquare4cup =   menu_square4cup.getText();
      
      view_productname.setText(menusquare4cup);
    }

   @FXML 
    private void reound4cup(ActionEvent event) {
        
        
        String menuround4cup = menu_round4cup.getText();
        
        view_productname.setText(menuround4cup);
    }

   @FXML 
    private void roundplain3cup(ActionEvent event) {
        
         String menuroundplain3cup = menu_roundplain3cup.getText();
       
       view_productname.setText(menuroundplain3cup);
    }

   @FXML 
    private void reoundplain4cup(ActionEvent event) {
        
         String menuroundplain4cup =  menu_roundplain4cup.getText();
       
       view_productname.setText(menuroundplain4cup);
    }

   @FXML 
    private void squareplain3cup(ActionEvent event) {
        
        String menusqareplain3cup =  menu_squareplain3cup.getText();
      
      view_productname.setText(menusqareplain3cup);
    }
    @FXML 
    private void squareplain4cup(ActionEvent event) {
        
        String menusquareplain4cup =  menu_squareplain4cup.getText();
      
      view_productname.setText(menusquareplain4cup); 
    }

    @FXML 
   private void lid(ActionEvent event) {
        
        String menulid = menu_lid.getText();
       
       view_productname.setText(menulid);
    }

    @FXML 
   private void cup3(ActionEvent event) {
        
        String menu3cup =  menu_3cup.getText();
       
       view_productname.setText(menu3cup);
    }

    @FXML 
   private void cup4(ActionEvent event) {
        
         String menu4cup =  menu_4cup.getText();
       
       view_productname.setText(menu4cup);
    }

    @FXML 
   private void cup5(ActionEvent event) {
        
        String menu5cup = menu_5cup.getText();
        
        view_productname.setText(menu5cup);
    }

    @FXML 
   private void cup8(ActionEvent event) {
        
        String menu8cup =  menu_8cup.getText();
       
       view_productname.setText(menu8cup);
    }
       @FXML 
    private void productsize(ActionEvent event) {
    
    }

    @FXML 
   private void inch12(ActionEvent event) {
        
        String menu12inch =  menu_12inch.getText();
       
       view_productsize.setText(menu12inch);
    }

    @FXML 
   private void xl12inch(ActionEvent event) {
        
        String menu12inchxl =  menu_12inchxl.getText();
       
       view_productsize.setText(menu12inchxl);
    }

    @FXML 
   private void inch10(ActionEvent event) {
        
               
              String menu10inch =  menu_10inch.getText();
              
              view_productsize.setText(menu10inch);

    }

    @FXML 
   private void inch9(ActionEvent event) {
        
        String menu9inch =  menu_9inch.getText();
      
      view_productsize.setText(menu9inch);
    }

    @FXML 
   private void inch7(ActionEvent event) {
        
        String menu7inch = menu_7inch.getText();
        
        view_productsize.setText(menu7inch);
    }

    @FXML 
   private void inch6(ActionEvent event) {
        
        String menu6inch =  menu_6inch.getText();
       
       view_productsize.setText(menu6inch);
    }

    @FXML 
   private void inch5(ActionEvent event) {
        
        String menu5inch = menu_5inch.getText();
        
        view_productsize.setText(menu5inch);
    }

    @FXML 
   private void inch4(ActionEvent event) {
        
        String menu4inch =   menu_4inch.getText();
      
      view_productsize.setText(menu4inch);
    }

    @FXML 
   private void ml480(ActionEvent event) {
        
         String menu480ml =  menu_480ml.getText();
       
       view_productsize.setText(menu480ml);
    }

    @FXML 
   private void ml360(ActionEvent event) {
        
        String menu360ml =  menu_360ml.getText();
       
       view_productsize.setText(menu360ml);
    }

    @FXML 
   private void ml340(ActionEvent event) {
        
         String menu340ml =  menu_340ml.getText();
       
       view_productsize.setText(menu340ml);
    }

    @FXML 
   private void ml240(ActionEvent event) {
        
         String menui240ml = menu_240ml.getText();
        
        view_productsize.setText(menui240ml);
    }

    @FXML 
   private void ml210(ActionEvent event) {
        
        String menu210ml =  menu_210ml.getText();
      
      view_productsize.setText(menu210ml);
    }

    @FXML 
   private void ml180(ActionEvent event) {
        
         String menu180ml =  menu_180ml.getText();
       
       view_productsize.setText(menu180ml);
    }

    @FXML 
   private void ml150(ActionEvent event) {
        
        String menu150ml = menu_150ml.getText();
       
       view_productsize.setText(menu150ml);
    }

    @FXML 
   private void ml120(ActionEvent event) {
        
        String menu120ml = menu_120ml.getText();
       
       view_productsize.setText(menu120ml);
    }

    @FXML 
   private void ml110(ActionEvent event) {
        
         String menu110ml = menu_110ml.getText();
       
       view_productsize.setText(menu110ml);
    }

    @FXML 
   private void ml90(ActionEvent event) {
        
         String menu90ml = menu_90ml.getText();
        
        view_productsize.setText(menu90ml);
    }

    @FXML 
   private void ml60(ActionEvent event) {
        
          
       String menu60ml = menu_60ml.getText();
       
       view_productsize.setText(menu60ml);
    }

    @FXML 
   private void ml55(ActionEvent event) {
        
         String menu55ml =  menu_55ml.getText();
       
       view_productsize.setText(menu55ml);
    }

    @FXML 
   private void ml30(ActionEvent event) {
        
         String menu30ml =  menu_30ml.getText();
       
       view_productsize.setText(menu30ml);
    }

    @FXML 
   private void ml500(ActionEvent event) {
        
          String menu500ml = menu_500ml.getText();
       
       view_productsize.setText(menu500ml);
    }

    @FXML 
   private void ml750(ActionEvent event) {
        
         String menu750ml = menu_750ml.getText();
       
       view_productsize.setText(menu750ml);
    }

    @FXML 
   private void b2b(ActionEvent event) {
        
         String menub2b =  menu_b2b.getText();
       
       view_productsize.setText(menub2b);
    }

    @FXML 
   private void d1(ActionEvent event) {
        
         String menu1d =  menu_1d.getText();
       
       view_productsize.setText(menu1d);
    }

    @FXML 
   private void d2(ActionEvent event) {
        
         String menu2d = menu_2d.getText();
       
       view_productsize.setText(menu2d);
    }

    @FXML 
   private void d3(ActionEvent event) {
        
        String menu3d =  menu_3d.getText();
       
       view_productsize.setText(menu3d);
    }

    @FXML 
   private void d5(ActionEvent event) {
        
         String menu5d =  menu_5d.getText();
       
       view_productsize.setText(menu5d);
    }

    @FXML 
   private void size66(ActionEvent event) {
        
        String menusize66 =  menu_size66.getText();
      
      view_productsize.setText(menusize66);
    }

    @FXML 
   private void size96(ActionEvent event) {
        
         String menusize96 =  menu_size96.getText();
       
       view_productsize.setText(menusize96);
    }

    @FXML 
   private void size99(ActionEvent event) {
        
         String menusize99 =  menu_size99.getText();
       
       view_productsize.setText(menusize99);
    }

    @FXML 
   private void size993(ActionEvent event) {
        
         String menusize993 = menu_size993.getText();
       
       view_productsize.setText(menusize993);
    }

    @FXML 
   private void smart(ActionEvent event) {
        
         String menusmart =  menu_smart.getText();
       
       view_productsize.setText(menusmart);
    }

    @FXML 
   private void ml3000(ActionEvent event) {
        
        String menu300ml = menu_300ml.getText();
       
       view_productsize.setText(menu300ml);
    }

    @FXML 
   private void size883(ActionEvent event) {
        
         String menusize883 =  menu_size883.getText();
       
       view_productsize.setText(menusize883);
    }

    @FXML 
   private void cup2(ActionEvent event) {
        
         String menu2cup = menu_2cup.getText();
       
       view_productsize.setText(menu2cup);
    }

    @FXML 
   private void mm80(ActionEvent event) {
        
       String menu80mm = menu_80mm.getText();
       
       view_productsize.setText(menu80mm);
    }

    @FXML 
   private void mm90(ActionEvent event) {
        
     String menu90mm = menu_90mm.getText();
        
        view_productsize.setText(menu90mm);
    }

    @FXML 
   private void normelspoon(ActionEvent event) {
        
         String menunormelsppoon = menu_normelspoon.getText();
        
        view_productsize.setText(menunormelsppoon);
    }

    @FXML 
   private void fork(ActionEvent event) {
        
        String menufork = menu_fork.getText();
        
        view_productsize.setText(menufork);
    }

    @FXML 
   private void knife(ActionEvent event) {
        
         String menuknife = menu_knife.getText();
        
        view_productsize.setText(menuknife);
    }

    @FXML 
   private void mm55mm210(ActionEvent event) {
        
        String menu55mm210mm = menu_55mm210mm.getText();
       
       view_productsize.setText(menu55mm210mm);
    }

    @FXML 
   private void mm7mm210(ActionEvent event) {
        
        String menu7mm210mm = menu_7mm210mm.getText();
        
        view_productsize.setText(menu7mm210mm);
    }

    @FXML 
   private void mm10mm210(ActionEvent event) {
        
        String menu10mm210mm =  menu_10mm210mm.getText();
       
       view_productsize.setText(menu10mm210mm);
    }

    @FXML 
   private void mm7mm230(ActionEvent event) {
        
         String menu7mm230mm =  menu_7mm230mm.getText();
       
       view_productsize.setText(menu7mm230mm);
    }

    @FXML 
   private void cms14cms16(ActionEvent event) {
        
        String menu14cms16cms = menu_14cms16cms.getText();
        
        view_productsize.setText(menu14cms16cms);
    }

    @FXML 
   private void cm11(ActionEvent event) {
        
         String menu11cm = menu_11cm.getText();
        
        view_productsize.setText(menu11cm);
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
   
}
