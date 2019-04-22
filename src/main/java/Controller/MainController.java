package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private StackPane mainStackPane;

    public MainController() {
    }

    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
        Pane pane = null;

        try {
            pane = (Pane)loader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        MenuController menuController = (MenuController)loader.getController();
        menuController.setMainController(this);
        this.setScreen(pane);
    }

    public void setScreen(Pane pane) {
        this.mainStackPane.getChildren().clear();
        this.mainStackPane.getChildren().add(pane);
    }
}
