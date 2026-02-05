
package pn_plate_projects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PN_Main extends Application{
    
       public static Stage stage=new Stage();


    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Intro_Video.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        
        launch(args);
    }
        
}
