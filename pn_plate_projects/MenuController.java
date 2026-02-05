package pn_plate_projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MenuController implements Initializable {

    @FXML
    private MenuButton menuBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        menuBtn.showingProperty().addListener((obs, wasShowing, isNowShowing) -> {

            if (!menuBtn.getItems().isEmpty()) return;

            String[] menuNames = { "Add User", "Edit User", "Delete User", "Logout", "Hii" };

            for (String name : menuNames) {
                MenuItem item = new MenuItem(name);

                item.setOnAction(ev -> {
                    System.out.println(name + " clicked");

                    // ✅ MenuButton text update
                    menuBtn.setText(name);
                });

                menuBtn.getItems().add(item);
            }
        });
    }
}


