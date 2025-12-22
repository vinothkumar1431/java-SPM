package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LinechartController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadLineChart();
    }

    private void loadLineChart() {

        // X Axis months order
        xAxis.setCategories(FXCollections.observableArrayList(
                "Jan","Feb","Mar","Apr","May","Jun",
                "Jul","Aug","Sep","Oct","Nov","Dec"
        ));

        xAxis.setTickLabelRotation(45);
        xAxis.setTickLabelFont(javafx.scene.text.Font.font(14));

        // Y Axis settings
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);

        // Data series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sales");

        series.getData().add(new XYChart.Data<>("Jan", 10));
        series.getData().add(new XYChart.Data<>("Feb", 20));
        series.getData().add(new XYChart.Data<>("Mar", 35));
        series.getData().add(new XYChart.Data<>("Apr", 40));
        series.getData().add(new XYChart.Data<>("May", 50));
        series.getData().add(new XYChart.Data<>("Jun", 60));
        series.getData().add(new XYChart.Data<>("Jul", 70));
        series.getData().add(new XYChart.Data<>("Aug", 75));
        series.getData().add(new XYChart.Data<>("Sep", 80));
        series.getData().add(new XYChart.Data<>("Oct", 65));
        series.getData().add(new XYChart.Data<>("Nov", 90));
        series.getData().add(new XYChart.Data<>("Dec", 95));

        lineChart.getData().clear();
        lineChart.getData().add(series);
    }
}

