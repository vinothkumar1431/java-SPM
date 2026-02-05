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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
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
public class Users_Detials_PrinterController implements Initializable {

    @FXML
    private AnchorPane anchorpane_pane;
    @FXML
    private Label label_username;
    @FXML
    private Label labele_total_bill_count;
    @FXML
    private Label labele_date;
    @FXML
    private Label labele_password;
    @FXML
    private Label labele_time;
    @FXML
    private TableView<Detials_printer_pojo> table_view;
    @FXML
    private TableColumn<Detials_printer_pojo, Integer> clo_serial;
    @FXML
    private TableColumn<Detials_printer_pojo, Integer> clo_billsid;
    @FXML
    private TableColumn<Detials_printer_pojo, Double> clo_totalamount;
    @FXML
    private TableColumn<Detials_printer_pojo, Double> clo_paidamount;
    @FXML
    private TableColumn<Detials_printer_pojo, Double> clo_blances;
    @FXML
    private TableColumn<Detials_printer_pojo, String> clo_date;
    @FXML
    private TableColumn<Detials_printer_pojo, String> clo_time;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clo_serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        clo_billsid.setCellValueFactory(new PropertyValueFactory<>("billid"));
        clo_totalamount.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
        clo_paidamount.setCellValueFactory(new PropertyValueFactory<>("paidamount"));
        clo_blances.setCellValueFactory(new PropertyValueFactory<>("balancesamount"));
        clo_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        clo_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    public void loadTable(String username, String password) throws Exception {
        
    LocalTime time = LocalTime.now();
   String currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

   
LocalDate date = LocalDate.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  String currentDate = date.format(formatter);
  


        // Set labels
        label_username.setText(username);
        labele_password.setText(password);

        // Get all billIds
        String sql = "SELECT billId FROM user_working "
                   + "WHERE username = ? AND password = ? "
                   + "AND billId IS NOT NULL AND billId ~ '^[0-9]+$'";

        Class.forName(PN_Dao_Paroperty.driver);

        List<Integer> billIds = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    billIds.add(rs.getInt("billId")); 
                    
                    System.out.println("BillId :"+billIds);
                }
            }
        }

        // DAO call – fetch all bill details in one query
        Detials_printer_Dao dao = new Detials_printer_Dao();
        ObservableList<Detials_printer_pojo> list = dao.UsersDetials(billIds);

        // Update TableView & total bills
        table_view.setItems(list);
        labele_total_bill_count.setText(String.format("%02d", list.size()));
        labele_time.setText(currentTime);
        labele_date.setText(currentDate);
        
     
      autoPrintA4();
        
    }
  
private void autoPrintA4() {

    Printer printer = Printer.getDefaultPrinter();
    if (printer == null) {
        System.out.println("❌ No printer found");
        return;
    }

    PrinterJob job = PrinterJob.createPrinterJob(printer);
    if (job == null) {
        System.out.println("❌ Printer job failed");
        return;
    }

    PageLayout layout = printer.createPageLayout(
            Paper.A4,
            PageOrientation.PORTRAIT,
            Printer.MarginType.DEFAULT
    );

    job.getJobSettings().setPageLayout(layout);

    double scaleX = layout.getPrintableWidth()
            / anchorpane_pane.getBoundsInLocal().getWidth();
    double scaleY = layout.getPrintableHeight()
            / anchorpane_pane.getBoundsInLocal().getHeight();

    double scale = Math.min(scaleX, scaleY);

    Scale s = new Scale(scale, scale);
    anchorpane_pane.getTransforms().add(s);

    job.printPage(anchorpane_pane);
    job.endJob();

    anchorpane_pane.getTransforms().remove(s);

    System.out.println("✅ A4 printed");
}

  
}
