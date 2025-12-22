/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinot
 */
public class VideoController implements Initializable {

    @FXML
    private MediaView mediaView;

    /**
     * Initializes the controller class.
     */
    
    @Override
public void initialize(URL url, ResourceBundle rb) {

    try {

        // Video resource load
        URL videoUrl;
        videoUrl = getClass().getResource("/Video/Your paragraph text.mp4");

        if (videoUrl == null) {
            System.out.println("Video file not found!");
            return;
        }

        Media media = new Media(videoUrl.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setAutoPlay(true);

        // Video முடிந்ததும் next page open
        mediaPlayer.setOnEndOfMedia(() -> {

            try {
                Stage currentStage = (Stage) mediaView.getScene().getWindow();
                currentStage.close();

      Parent root = FXMLLoader.load(getClass().getResource("PN.fxml"));
        
      Scene scene = new Scene(root);
        
      PN_Main.stage.setScene(scene);
        
      PN_Main. stage.show(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    }
            
