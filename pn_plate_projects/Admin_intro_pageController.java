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
import java.time.Year;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static pn_plate_projects.Admin_SingController.adminId;

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
    private PieChart piechart_2;
    @FXML
    private PieChart piechart_3;

    // LineChart
    @FXML
    private LineChart<String, Number> lineChart;
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
    
    
    //Private
    
    private double Total_12Hours = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    piechart1();
     try {
         // barChartData();
         hours_12_total();
     } catch (Exception ex) {
         Logger.getLogger(Admin_intro_pageController.class.getName()).log(Level.SEVERE, null, ex);
     }

    //piechart2();
    //piechart3();
   // loadLineChart_12hours();
    //loadLineChart_Days();
    //loadLineChart_Hours();
    //loadLineChart();
    //linecherat();
    }   
    public void piechart1(){
        
        
       ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                    new PieChart.Data("Plate", 40),
                    new PieChart.Data("Cups", 25),
                    new PieChart.Data("Bowls", 15),
                    new PieChart.Data("Container", 25),
                    new PieChart.Data("Trays", 15),
                    new PieChart.Data("Box", 25),
                    new PieChart.Data("Spoons", 15),
                    new PieChart.Data("glas", 20)
                );
        piechart_1.setData(pieData);
        piechart_1.setTitle("Product");
        //piechart_1.set
    }
       public void piechart2(){
        
        
       ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                    new PieChart.Data("Plate", 40),
                    new PieChart.Data("Cups", 25),
                    new PieChart.Data("Bowls", 15),
                    new PieChart.Data("Container", 25),
                    new PieChart.Data("Trays", 15),
                    new PieChart.Data("Box", 25),
                    new PieChart.Data("Spoons", 15),
                    new PieChart.Data("glas", 20)
                );
        piechart_2.setData(pieData);
        piechart_2.setTitle("Product");
    }
   public void piechart3(){
        
        
       ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                    new PieChart.Data("Plate", 40),
                    new PieChart.Data("Cups", 25),
                    new PieChart.Data("Bowls", 15),
                    new PieChart.Data("Container", 25),
                    new PieChart.Data("Trays", 15),
                    new PieChart.Data("Box", 25),
                    new PieChart.Data("Spoons", 15),
                    new PieChart.Data("glas", 20)
                );
        piechart_3.setData(pieData);
        piechart_3.setTitle("Product");
    }
 public void linecherat_Month() {

    // X Axis order
    xAxis.setCategories(FXCollections.observableArrayList(
            "Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"
    ));

    xAxis.setTickLabelFont(javafx.scene.text.Font.font("Arial", 16));
    xAxis.setTickLabelRotation(45);
    xAxis.setTickLabelGap(10);

    // Y Axis settings
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(100);
    yAxis.setTickUnit(10);
    yAxis.setTickLabelFont(javafx.scene.text.Font.font(14));

    // Series
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Monthly Sales %");

    series.getData().add(new XYChart.Data<>("Jan", 10));
    series.getData().add(new XYChart.Data<>("Feb", 20));
    series.getData().add(new XYChart.Data<>("Mar", 35));
    series.getData().add(new XYChart.Data<>("Apr", 40));
    series.getData().add(new XYChart.Data<>("May", 50));
    series.getData().add(new XYChart.Data<>("Jun", 56));
    series.getData().add(new XYChart.Data<>("Jul", 60));
    series.getData().add(new XYChart.Data<>("Aug", 75));
    series.getData().add(new XYChart.Data<>("Sep", 80));
    series.getData().add(new XYChart.Data<>("Oct", 58));
    series.getData().add(new XYChart.Data<>("Nov", 95));
    series.getData().add(new XYChart.Data<>("Dec", 90));

    lineChart.getData().clear();
    lineChart.getData().add(series);
}
private void loadLineChart_Week() {

        // ✅ X Axis – Weeks
        xAxis.setCategories(FXCollections.observableArrayList(
                "Week 1", "Week 2", "Week 3", "Week 4", "Week 5"
        ));
        xAxis.setLabel("Week");
        xAxis.setTickLabelFont(Font.font(14));
        xAxis.setTickLabelRotation(0);

        // ✅ Y Axis – Sales Amount
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);
        yAxis.setLabel("Sales Amount");

        // ✅ Data Series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Weekly Sales");

        series.getData().add(new XYChart.Data<>("Week 1", 15));
        series.getData().add(new XYChart.Data<>("Week 2", 30));
        series.getData().add(new XYChart.Data<>("Week 3", 45));
        series.getData().add(new XYChart.Data<>("Week 4", 60));
        series.getData().add(new XYChart.Data<>("Week 5", 75));

        lineChart.getData().clear();
        lineChart.getData().add(series);
    }
private void loadLineChart_Days() {

    // X Axis – 7 Days
    xAxis.setCategories(FXCollections.observableArrayList(
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    ));
    xAxis.setLabel("Days");
    xAxis.setTickLabelFont(javafx.scene.text.Font.font(14));
    xAxis.setTickLabelRotation(0);

    // Y Axis – Sales Amount
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(100);
    yAxis.setTickUnit(10);
    yAxis.setLabel("Sales Amount");

    // Data Series
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Weekly Sales");

    series.getData().add(new XYChart.Data<>("Mon", 20));
    series.getData().add(new XYChart.Data<>("Tue", 35));
    series.getData().add(new XYChart.Data<>("Wed", 40));
    series.getData().add(new XYChart.Data<>("Thu", 55));
    series.getData().add(new XYChart.Data<>("Fri", 70));
    series.getData().add(new XYChart.Data<>("Sat", 85));
    series.getData().add(new XYChart.Data<>("Sun", 60));

    lineChart.getData().clear();
    lineChart.getData().add(series);
}
private void loadLineChart_Hours() {
    

    // X Axis – 24 Hours
    xAxis.setCategories(FXCollections.observableArrayList(
            "00","01","02","03","04","05",
            "06","07","08","09","10","11",
            "12","13","14","15","16","17",
            "18","19","20","21","22","23"
    ));
    xAxis.setLabel("Hours");
    xAxis.setTickLabelFont(javafx.scene.text.Font.font(12));
    xAxis.setTickLabelRotation(0);

    // Y Axis – Sales Amount
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(100);
    yAxis.setTickUnit(10);
    yAxis.setLabel("Sales Amount");

    // Data Series
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Hourly Sales");

    series.getData().add(new XYChart.Data<>("00", 5));
    series.getData().add(new XYChart.Data<>("01", 8));
    series.getData().add(new XYChart.Data<>("02", 6));
    series.getData().add(new XYChart.Data<>("03", 4));
    series.getData().add(new XYChart.Data<>("04", 3));
    series.getData().add(new XYChart.Data<>("05", 7));

    series.getData().add(new XYChart.Data<>("06", 15));
    series.getData().add(new XYChart.Data<>("07", 25));
    series.getData().add(new XYChart.Data<>("08", 40));
    series.getData().add(new XYChart.Data<>("09", 55));
    series.getData().add(new XYChart.Data<>("10", 65));
    series.getData().add(new XYChart.Data<>("11", 70));

    series.getData().add(new XYChart.Data<>("12", 75));
    series.getData().add(new XYChart.Data<>("13", 80));
    series.getData().add(new XYChart.Data<>("14", 78));
    series.getData().add(new XYChart.Data<>("15", 70));
    series.getData().add(new XYChart.Data<>("16", 60));
    series.getData().add(new XYChart.Data<>("17", 55));

    series.getData().add(new XYChart.Data<>("18", 65));
    series.getData().add(new XYChart.Data<>("19", 85));
    series.getData().add(new XYChart.Data<>("20", 90));
    series.getData().add(new XYChart.Data<>("21", 75));
    series.getData().add(new XYChart.Data<>("22", 50));
    series.getData().add(new XYChart.Data<>("23", 30));

    lineChart.getData().clear();
    lineChart.getData().add(series);
}
private void loadLineChart_12hours() throws Exception{
    
    String date ="";
    String hour = "";
    double total = 0;
    
String query =
    "select date, to_char(time::time,'HH12 PM') as hour, " +
    "sum(total) as total_amount " +
    "from rr_table " +
    "where date = '2025-12-21' " +
    "group by date, hour " +
    "order by hour";



Class.forName(PN_Dao_Paroperty.driver);

    Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

    // LAST ADMIN ID FETCH
    String getLastIdQuery = query;
    PreparedStatement psLast = con.prepareStatement(getLastIdQuery);
    ResultSet rs = psLast.executeQuery(); 

while (rs.next()) {
    date = rs.getString("date");
    hour = rs.getString("hour");
    total = rs.getDouble("total_amount");
    


    System.out.println("date"+date);
    System.out.println("hour"+hour);
    System.out.println("total"+total);
    


    // X Axis – 12 Hours
    xAxis.setCategories(FXCollections.observableArrayList(
            "12 AM","01 AM","02 AM","03 AM","04 AM","05 AM",
            "06 AM","07 AM","08 AM","09 AM","10 AM","11 AM",
            "12 PM","01 PM","02 PM","03 PM","04 PM","05 PM",
            "06 PM","07 PM","08 PM","09 PM","10 PM","11 PM"
    ));
    xAxis.setLabel("Time");
    xAxis.setTickLabelFont(javafx.scene.text.Font.font(11));
    xAxis.setTickLabelRotation(45);

    // Y Axis – Sales Amount
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(100);
    yAxis.setTickUnit(10);
    yAxis.setLabel("Sales Amount");

    // Data Series
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("12 Hour Sales");
    
         if(hour.equals("12 AM")){
        
    series.getData().add(new XYChart.Data<>("12 AM", total / Total_12Hours*100));
                 System.out.println("Amount : "+total/Total_12Hours*100);

    }
         else if(hour.equals("01 AM")){
        
    series.getData().add(new XYChart.Data<>("01 AM", total / Total_12Hours*100));
                 System.out.println("Amount : "+total/Total_12Hours*100);

    }
         else if(hour.equals("02 AM")){
        
    series.getData().add(new XYChart.Data<>("02 AM", total / Total_12Hours*100));
    }
         else if(hour.equals("03 AM")){
        
    series.getData().add(new XYChart.Data<>("03 AM", total / Total_12Hours*100));
    }
         else if(hour.equals("04 AM")){
        
    series.getData().add(new XYChart.Data<>("04 AM", total / Total_12Hours*100));
    }
         else if(hour.equals("05 AM")){
        
    series.getData().add(new XYChart.Data<>("05 AM", total / Total_12Hours*100));
    }   
     
         else if(hour.equals("06 AM")){
        
     series.getData().add(new XYChart.Data<>("06 AM", total / Total_12Hours*100));
    }
     
         else if(hour.equals("07 AM")){
        
    series.getData().add(new XYChart.Data<>("07 AM", total / Total_12Hours*100));
    }  
          else if(hour.equals("08 AM")){
        
    series.getData().add(new XYChart.Data<>("08 AM", total / Total_12Hours*100));
    }
          else if(hour.equals("09 AM")){
        
    series.getData().add(new XYChart.Data<>("09 AM", total / Total_12Hours*100));
    }
          else if(hour.equals("10 AM")){
        
    series.getData().add(new XYChart.Data<>("10 AM", total / Total_12Hours*100));
    }
          else if(hour.equals("11 AM")){
        
    series.getData().add(new XYChart.Data<>("11 AM", total / Total_12Hours*100));
    }  
     //-------------------PM TIME VALUE---------------------//
     
           else if(hour.equals("12 PM")){
        
    series.getData().add(new XYChart.Data<>("12 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("01 PM")){
        
    series.getData().add(new XYChart.Data<>("01 PM", total / Total_12Hours*100));
    }     
           else if(hour.equals("02 PM")){
        
    series.getData().add(new XYChart.Data<>("02 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("03 PM")){
        
    series.getData().add(new XYChart.Data<>("03 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("04 PM")){
        
    series.getData().add(new XYChart.Data<>("04 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("05 PM")){
        
    series.getData().add(new XYChart.Data<>("05 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("06 PM")){
        
    series.getData().add(new XYChart.Data<>("06 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("07 PM")){
        
    series.getData().add(new XYChart.Data<>("07 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("08 PM")){
        
    series.getData().add(new XYChart.Data<>("08 PM", total / Total_12Hours*100));
    }
           else if(hour.equals("09 PM")){
                         
        
    series.getData().add(new XYChart.Data<>("09 PM",total/Total_12Hours*100));
    
    }
           else if(hour.equals("10 PM")){
        
    series.getData().add(new XYChart.Data<>("10 PM", total / Total_12Hours*100));
    }
            else if(hour.equals("11 PM")){
        
    series.getData().add(new XYChart.Data<>("11 PM", total / Total_12Hours*100));
    }
         System.out.println("date 1"+date);
    System.out.println("hour 1"+hour);
    System.out.println("total 1"+total);
                                                                        
    lineChart.getData().clear();
    lineChart.getData().add(series);
}
}
 // ------------------ BARCHART ------------------
    private void barChartData() {
        // X Axis – Months
        bar_xAxis.setLabel("Prodacut");
        bar_xAxis.setCategories(FXCollections.observableArrayList("Plate", "Cups", "Bowls", "Container", "Trays", "Box", "Spoon", "Glass"));
        bar_xAxis.setTickLabelFont(Font.font(15));
        

        // Y Axis – Sales
        bar_yAxis.setLabel("Quntity(%)");
        bar_yAxis.setAutoRanging(false);
        bar_yAxis.setLowerBound(0);
        bar_yAxis.setUpperBound(100);
        bar_yAxis.setTickUnit(10);
        bar_yAxis.setMaxWidth(10);
       


        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Prodacut");
        series1.getData().add(new XYChart.Data<>("Plate", 10));
        series1.getData().add(new XYChart.Data<>("Cups", 45));
        series1.getData().add(new XYChart.Data<>("Bowls", 3));
        series1.getData().add(new XYChart.Data<>("Container", 6));
        series1.getData().add(new XYChart.Data<>("Trays", 50));
        series1.getData().add(new XYChart.Data<>("Box", 65));
        series1.getData().add(new XYChart.Data<>("Spoon", 75));
        series1.getData().add(new XYChart.Data<>("Glass", 10));


        Bar_chart.getData().clear();
        Bar_chart.getData().add(series1);
    
    }
   public void hours_12_total() throws Exception {

    Class.forName(PN_Dao_Paroperty.driver);

    Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

    String query =
        "select sum(total) as total_amount " +
        "from rr_table " +
        "where date = '2025-12-21'";

    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        Total_12Hours = rs.getDouble("total_amount");
        if (rs.wasNull()) {
            Total_12Hours = 0;
        }
    }

    System.out.println("Total Amount : " + Total_12Hours);

    rs.close();
    ps.close();
    con.close();
    
    loadLineChart_12hours();
}



    
}


    


