package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class PiechartController implements Initializable {

    @FXML
    private PieChart pieChart;   // ⭐ THIS IS IMPORTANT

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<PieChart.Data> pieData =
                FXCollections.observableArrayList(
                    new PieChart.Data("Rice", 40),
                    new PieChart.Data("Oil", 25),
                    new PieChart.Data("Sugar", 15),
                    new PieChart.Data("Others", 20)
                );

        pieChart.setData(pieData);
        pieChart.setTitle("Sales Report");
    }
}

