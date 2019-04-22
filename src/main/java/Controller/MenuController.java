package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MenuController {
    private MainController mainController;
    @FXML
    private Button startbutton;

    public MenuController() {
    }

    @FXML
    public void start() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
        Pane pane = null;

        try {
            pane = (Pane)loader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        AppController appController = (AppController)loader.getController();
        appController.setMainController(this.mainController);
        this.mainController.setScreen(pane);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
