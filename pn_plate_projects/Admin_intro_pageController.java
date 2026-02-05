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
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static pn_plate_projects.PN_Main.stage;


/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Admin_intro_pageController implements Initializable {
 @FXML
    private AnchorPane anchor_pane;
    @FXML
    private AnchorPane anchor_top_pane;
    @FXML
    private AnchorPane anchor_batom;
    @FXML
    private AnchorPane anchor_pan1;

    // PieCharts
    @FXML
    private PieChart piechart_1;
    @FXML
    private PieChart more_Sales;
   

    // AreaChart
    @FXML
    private AreaChart<String, Number> areaChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
    // BarChart
      @FXML
    private BarChart<String, Number> Bar_chart;
      

    @FXML
    private CategoryAxis bar_xAxis;

    @FXML
    private NumberAxis bar_yAxis;


    
  //--------Label------//  
     @FXML
     private Label User_count;
     @FXML
     private Label Lable_seletAmount;
     @FXML
     private Label label_totalAmount;  
     @FXML
     private Label Bills_delete;
     @FXML
     private Label Todabills;
     @FXML
     private Label label_totalsproducts;
     @FXML
     private Label newStock;
    
   //-------MenuButton-------//  
 
    @FXML
     private MenuButton menu_totalAmount;
    
    @FXML
     private MenuButton menu_areachart;
   
  //--------Button-----//
     
    @FXML
    private Button bt_add;
    @FXML
    private Button bt_detials;
    @FXML
    private Button bt_update;
    @FXML
    private Button bt_Passwordchenge;  
    @FXML
    private Button bt_adminsecurity;
    @FXML
    private Button bt_productdetials;
    @FXML
    private Button bt_newstock;
    @FXML
    private Button bt_admin;
    @FXML
    private Button bt_deletebills;
    @FXML
    private Button bt_Security;
    
    //RADIOBUTTON
     
    @FXML
    private RadioButton rd_security;
    
    @FXML
    private ToggleButton bt_ok;
    
    //Private
    
    private double Total_12Hours = 0;
    private String currentTime = "";
    private String currentDate = "";
    
    private int count = 0;
    
    Preferences prefs = Preferences.userNodeForPackage(getClass());


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
   // piechart1();
     try {
         Date_Time();
         Today_NewStock();
         Select_ProductLable();
         adminIntro();
         DELETEING_BILLS_COUNT();
         TODAY_BILLS();
          menu_Areachart();
          MM_TotalAmount();
          areaChart();
          piechart1();
          piechart2();
          loadBarChartDataFromDB();
          setupBarChart();
     loadBarChartDataFromDB();
     } catch (Exception ex) {
         Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
     }
     total_count();

     try {
         NO();
     } catch (Exception ex) {
         Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
  @FXML 
  private void securityServers(ActionEvent event)throws Exception{
        
      String value = rd_security.getText();
      
     }
 @FXML 
 private void Adminsecuritys(ActionEvent event)throws Exception{
      
      Parent root = FXMLLoader.load(getClass().getResource("Admin_Sing.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();  
      
        
 }         
  @FXML 
  private void ProductDetials(ActionEvent event) {
        
 } 
  @FXML 
  private void TotalAmounts(ActionEvent event) {
      
             
        
 
  } 
    @FXML 
  private void MenuAreaCharts(ActionEvent event) {

 
}



@FXML
private void ok(ActionEvent event)throws Exception{

    boolean status = bt_ok.isSelected();

    bt_ok.setText(status ? "ON" : "OFF");

    if (status) {
        try {
        } catch (Exception ex) {
            Logger.getLogger(Admin_intro_pageController.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }

    prefs.putBoolean("toggle_state", status);
    
    String value = String.valueOf(status);

     adminselectinsert(value);
}

public void NO() {

    boolean isOn = prefs.getBoolean("toggle_state", false);

    bt_ok.setSelected(isOn);
    bt_ok.setText(isOn ? "ON" : "OFF");

    bt_ok.selectedProperty().addListener((obs, oldVal, newVal) -> {

        bt_ok.setText(newVal ? "ON" : "OFF");

        if (newVal) {
            try {
              
            } catch (Exception ex) {
                Logger.getLogger(Admin_intro_pageController.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
        }

        prefs.putBoolean("toggle_state", newVal);
    });
}
public void adminselectinsert(String values)throws Exception{
    
    mex();
    
    int counts = count + 1;
    
    String sql = "INSERT INTO project_intro(id ,admin_select) VALUES (? , ?)";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1,counts);
    ps.setString(2,values);


    int rows = ps.executeUpdate();

    if (rows > 0) {
        System.out.println("Data Inserted Successfully");
    }

} catch (Exception e) {
    e.printStackTrace();
}

}
public void mex()throws Exception{


String sql = "SELECT id FROM project_intro ORDER BY id DESC LIMIT 1";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery(sql)) {

    if (rs.next()) {
        count = rs.getInt("id");  // get the last value
    }

    System.out.println("Last admin_select: " + count);

} catch (Exception e) {
    e.printStackTrace();
}

}

  
  private void setupBarChart() {
    bar_xAxis.setLabel("Product");

    bar_yAxis.setLabel("Quantity (%)");
    bar_yAxis.setAutoRanging(false);
    bar_yAxis.setLowerBound(0);
    bar_yAxis.setUpperBound(100);
    bar_yAxis.setTickUnit(10);
}


   private void loadBarChartDataFromDB() {

    XYChart.Series<String, Number> series =
            new XYChart.Series<>();
    series.setName("Product Quantity (%)");

    String query =
        "SELECT product_name, " +
        "ROUND(SUM(opening_stock) * 100.0 / (SELECT SUM(opening_stock) FROM product_insert), 2) AS opening_stock " +
        "FROM product_insert GROUP BY product_name";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            String product = rs.getString("product_name");
            double percent = rs.getDouble("opening_stock");

            series.getData().add(
                new XYChart.Data<>(product, percent)
            );
        }

        Bar_chart.getData().clear();
        Bar_chart.getData().add(series);

    } catch (Exception e) {
        e.printStackTrace();
    }
}


 public void areaChart(){
 
    areaChart.getData().clear();

    XYChart.Series<String, Number> series =
            new XYChart.Series<>();

    series.setName("Sales");

    series.getData().add(new XYChart.Data<>("Jan", 120));
    series.getData().add(new XYChart.Data<>("Feb", 150));
    series.getData().add(new XYChart.Data<>("Mar", 100));
    series.getData().add(new XYChart.Data<>("Apr", 180));

    areaChart.getData().add(series);
 
 } 
    @FXML 
    private void Admin(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Detials.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show(); 
        
              
 }    @FXML 
    private void DeleteBills(ActionEvent event) throws Exception{
      
       Parent root = FXMLLoader.load(getClass().getResource("Deleteing_Bills_view.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();        
 }
   
    @FXML 
    private void Add(ActionEvent event) throws Exception{
        
         Parent root = FXMLLoader.load(getClass().getResource("Product_insert.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
        
 }
    @FXML 
    private void ProductDetial(ActionEvent event) throws Exception{
        
         Parent root = FXMLLoader.load(getClass().getResource("Admin_Product_Deleteing.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
        
 }  
     @FXML 
    private void NewStock(ActionEvent event) throws Exception{
        
         Parent root = FXMLLoader.load(getClass().getResource("New_StockUpdate.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
        
 }   
    
    @FXML 
    private void Update(ActionEvent event) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Product_Updates.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
        
 }   
       @FXML 
    private void PasswordChenge(ActionEvent event)throws Exception{
        
            Parent root = FXMLLoader.load(getClass().getResource("Admin_PasswordChege.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
 }
         @FXML 
    private void Adminsecurity(ActionEvent event) throws Exception{
       
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Sing.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();  
      
 }
    
    
 
    @FXML 
    private void User_detials(ActionEvent event)throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("User_Detials.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
 }
public void piechart1() throws Exception{

    String sql = "SELECT product_name, COUNT(*) AS total " +
                 "FROM product_insert GROUP BY product_name";

    ObservableList<PieChart.Data> pieData =FXCollections.observableArrayList();

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            String product = rs.getString("product_name");
            int total = rs.getInt("total");

            pieData.add(new PieChart.Data(product, total));
        }

        piechart_1.setData(pieData);
        piechart_1.setTitle("Product Distribution");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void piechart2() throws Exception{

    String sql = "SELECT product_name, COUNT(*) AS total " +
                 "FROM rr_table GROUP BY product_name";

    ObservableList<PieChart.Data> pieData =FXCollections.observableArrayList();

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            String product = rs.getString("product_name");
            int total = rs.getInt("total");

            pieData.add(new PieChart.Data(product, total));
        }

        more_Sales.setData(pieData);
        more_Sales.setTitle("Fast Selling Products");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void total_count() {

    String sql = "SELECT COUNT(*) AS total FROM pn_sign";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            User_count.setText(String.valueOf(rs.getInt("total")));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void ONEDAYBILLS_AMOUNT() throws Exception{
    
   
}
public void MM_TotalAmount() throws Exception{

    menu_totalAmount.getItems().clear();

    String[] menuNames = { "Today", "Month", "Year" };

    for (String day : menuNames) {

        MenuItem item = new MenuItem(day);

        item.setOnAction(ev -> {

            menu_totalAmount.setText(day);
          Lable_seletAmount.setText(String.valueOf(day));


            if (day.equals("Today")) {
                try {
                        
        
         LocalDate date = LocalDate.now();
         String Date = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    Today(Date);

                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
                    else if (day.equals("Month")) {
                try {
         int currentMonth = LocalDate.now().getMonthValue();

         int currentYear = LocalDate.now().getYear();

                    Month(currentMonth,currentYear);
                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if (day.equals("Year")) {
                try {
                   int currentYear = LocalDate.now().getYear();

                    Year(currentYear);
                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
 }

        });

        menu_totalAmount.getItems().add(item);
    }
}

public void Today(String date) {

    String query = "SELECT SUM(total) AS total_amount FROM bill_amounts WHERE date = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setString(1,date); 

        ResultSet rs = ps.executeQuery();

        double values = 0;

        if (rs.next()) {
            values = rs.getDouble("total_amount");
        }

        label_totalAmount.setText(String.valueOf(values));
        System.out.println("Selected Day Bill Amount: " + values);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void Month(int month, int year) {
    String query =
        "SELECT COALESCE(SUM(total),0) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE EXTRACT(MONTH FROM TO_DATE(date,'YYYY-MM-DD')) = ? " +
        "AND EXTRACT(YEAR FROM TO_DATE(date,'YYYY-MM-DD')) = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, month);
        ps.setInt(2, year);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double value = rs.getDouble("total_amount");
            label_totalAmount.setText(String.valueOf(value));
            System.out.println("Selected Month Bill Amount: " + value);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }



}    
    public void Year(int year) {
    String query =
        "SELECT COALESCE(SUM(total),0) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE EXTRACT(YEAR FROM TO_DATE(date,'YYYY-MM-DD')) = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, year);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double value = rs.getDouble("total_amount");
            label_totalAmount.setText(String.valueOf(value));
            System.out.println("Selected Year Bill Amount: " + value);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }




}
public void Date_Time () throws Exception{

    
        LocalTime time = LocalTime.now();
   currentTime  = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
   
       System.out.println(currentTime);
    
    
LocalDate date = LocalDate.now();

 currentDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));



int currentMonth = LocalDate.now().getMonthValue();
    System.out.println("Current Month: " + currentMonth);

}
public void menu_Areachart(){

     menu_areachart.getItems().clear();

    String[] menuNames = { "Today","Week", "Month", "Year" };

    for (String day : menuNames) {

        MenuItem item = new MenuItem(day);

        item.setOnAction(ev -> {

            System.out.println(day + " clicked");

            menu_areachart.setText(day);


            if (day.equals("Today")) {
                try {
                    Todays();

                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                   else if (day.equals("Week")) {
                try {
                       Week();
                     } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
 
            else if (day.equals("Month")) {
                try {
                 
                    Month();
                    
                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if (day.equals("Year")) {
                try {
                
                    Year();
                    
                } catch (Exception ex) {
                    Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
                }
 }

        });

        menu_areachart.getItems().add(item);
    }


}

public void Todays() {

    String query =
        "SELECT EXTRACT(HOUR FROM TO_TIMESTAMP(date || ' ' || time, " +
        "'YYYY-MM-DD HH24:MI:SS')) AS hour, " +
        "SUM(total) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE TO_TIMESTAMP(date || ' ' || time, 'YYYY-MM-DD HH24:MI:SS') " +
        ">= NOW() - INTERVAL '24 HOURS' " +
        "GROUP BY hour " +
        "ORDER BY hour";

    areaChart.getData().clear();

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Last 24 Hours Sales");

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String hour = rs.getInt("hour") + ":00";
            double total = rs.getDouble("total_amount");

            series.getData().add(
                new XYChart.Data<>(hour, total)
            );
        }

        areaChart.getData().add(series);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void Week() {

    String query =
        "SELECT TO_CHAR(TO_DATE(date,'YYYY-MM-DD'), 'DD-Mon') AS day_name, " +
        "SUM(total) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE TO_DATE(date,'YYYY-MM-DD') >= CURRENT_DATE - INTERVAL '7 DAYS' " +
        "GROUP BY TO_CHAR(TO_DATE(date,'YYYY-MM-DD'), 'DD-Mon'), " +
        "TO_DATE(date,'YYYY-MM-DD') " +
        "ORDER BY TO_DATE(date,'YYYY-MM-DD')";

    areaChart.getData().clear();

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Last 7 Days Sales");

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String day = rs.getString("day_name");   // 10-Jan
            double total = rs.getDouble("total_amount");

            series.getData().add(
                new XYChart.Data<>(day, total)
            );
        }

        areaChart.getData().add(series);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void Month() {

    String query =
        "SELECT TO_CHAR(TO_DATE(date,'YYYY-MM-DD'), 'Mon YYYY') AS month_name, " +
        "SUM(total) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE TO_DATE(date,'YYYY-MM-DD') >= CURRENT_DATE - INTERVAL '12 MONTHS' " +
        "GROUP BY TO_CHAR(TO_DATE(date,'YYYY-MM-DD'), 'Mon YYYY'), " +
        "EXTRACT(YEAR FROM TO_DATE(date,'YYYY-MM-DD')), " +
        "EXTRACT(MONTH FROM TO_DATE(date,'YYYY-MM-DD')) " +
        "ORDER BY EXTRACT(YEAR FROM TO_DATE(date,'YYYY-MM-DD')), " +
        "EXTRACT(MONTH FROM TO_DATE(date,'YYYY-MM-DD'))";

    areaChart.getData().clear();

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Last 12 Months Sales");

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String month = rs.getString("month_name");   // Jan 2025
            double total = rs.getDouble("total_amount");

            series.getData().add(
                new XYChart.Data<>(month, total)
            );
        }

        areaChart.getData().add(series);

    } catch (Exception e) {
        e.printStackTrace();
    
    }
    }

public void Year() {

    String query =
        "SELECT TO_CHAR(TO_DATE(date,'YYYY-MM-DD'), 'Mon') AS month_name, " +
        "SUM(total) AS total_amount " +
        "FROM bill_amounts " +
        "WHERE EXTRACT(YEAR FROM TO_DATE(date,'YYYY-MM-DD')) = " +
        "EXTRACT(YEAR FROM CURRENT_DATE) - 1 " +
        "GROUP BY month_name, EXTRACT(MONTH FROM TO_DATE(date,'YYYY-MM-DD')) " +
        "ORDER BY EXTRACT(MONTH FROM TO_DATE(date,'YYYY-MM-DD'))";

    areaChart.getData().clear();
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Last Year Sales");

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            series.getData().add(
                new XYChart.Data<>(
                    rs.getString("month_name"),
                    rs.getDouble("total_amount")
                )
            );
        }
        areaChart.getData().add(series);

    } catch (Exception e) {
        e.printStackTrace();
    }
     

}

public void DELETEING_BILLS_COUNT()throws Exception{

 String sql = "SELECT COUNT(*) AS total FROM usert_bill_delete";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            Bills_delete.setText(String.valueOf(rs.getInt("total")));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void TODAY_BILLS() {

    String sql = "SELECT COUNT(*) AS total FROM bill_amounts WHERE date = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, currentDate);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Todabills.setText(rs.getString("total"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void adminIntro()throws Exception{
    
    String sql = "SELECT(u_name) FROM admin_data";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {
        try (ResultSet rs = ps.executeQuery()) {
            
            String name = "ADMIN";
            
            if (rs.next()) {
               name = rs.getString("u_name");
            }
               bt_admin.setText(name);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}
public void Select_ProductLable()throws Exception{
    
int count = 0;

String sql = "SELECT COUNT(*) AS total FROM product_insert WHERE opening_stock < 2000";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    if (rs.next()) {
        count = rs.getInt("total");
    }
    label_totalsproducts.setText(String.valueOf(count));
    System.out.println("Date :" + currentDate);
} catch (Exception e) {
    e.printStackTrace();
}

}
public void Today_NewStock()throws Exception{

int totalQty = 0;
   LocalDate date = LocalDate.now();

 String Dates = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));



String sql = "SELECT SUM(newstock) AS total_qty FROM product_newstock WHERE insertdate = ?";

try (Connection con = DriverManager.getConnection(
        PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
        PN_Dao_Paroperty.user,
        PN_Dao_Paroperty.pass);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1, Dates);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        totalQty = rs.getInt("total_qty"); 
    }

    newStock.setText(String.valueOf(totalQty));
    System.out.println("Date : " + Dates + " Total Qty : " + totalQty);

} catch (Exception e) {
    e.printStackTrace();
}

}
}





    


