/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class Intro_pageController implements Initializable {

    @FXML
    private ScrollPane Scroll_pane;
    @FXML
    private ImageView round_id1;
    @FXML
    private Button txt_round12;
    @FXML
    private ImageView round_id11;
    @FXML
    private ImageView round_id111;
    @FXML
    private ImageView round_id112;
    @FXML
    private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        for(int i=1;i<=5;i++){
        
            Label lbl = new Label("Item"+i);
            
            lbl.setStyle("-fx-font-size:16px;-fx-padding:5px;");
            
           vbox.getChildren().add(lbl);
        }
        Scroll_pane.addEventFilter(ScrollEvent.SCROLL, event ->{
        
        double deltay = event .getDeltaY()*0.003;
       
        Scroll_pane.setVvalue(Scroll_pane.getVvalue() -deltay);});
        
        Scroll_pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }    

    @FXML
    private void round12(ActionEvent event) {
        int count = vbox.getChildren().size()+1;
        
        Label newlabel =new Label("new item"+count);
        
        newlabel.setStyle("-fx-font-size:16px;-fx-padding :5px");
        
        vbox.getChildren().add(newlabel);
    }

    @FXML
    private void initialize(ScrollEvent event) {
 
    }
    
}
