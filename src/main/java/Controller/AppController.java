package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Project.Connect;
import Project.ConvertURL;
import Project.SaveToFile;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AppController {
    private MainController mainController;
    @FXML
    private TextField FirstText;
    @FXML
    private Button SetButton;
    @FXML
    private TextField textUser;
    @FXML
    private Button LoadButton;
    @FXML
    private Button SetButton2;
    @FXML
    private Button NextButton;
    @FXML
    private TextField FindText;
    @FXML
    private ChoiceBox<String> userChoice;
    private ConvertURL toURL = new ConvertURL();
    public Integer position = 0;
    public String url = "";
    public Connect toConnect;
    BufferedReader plik2 = null;

    public AppController() {
    }

    @FXML
    public void initialize() throws IOException {
        File f = new File("data.txt");
        if (f.exists()) {
            this.FindText.setVisible(true);
            this.NextButton.setVisible(true);
        } else {
            this.FirstText.setVisible(true);
            this.SetButton.setVisible(true);
            this.textUser.setVisible(true);
            this.textUser.setText(this.toURL.getURL());
        }

    }

    @FXML
    public void userBarClick() {
        this.SetButton2.setDisable(false);
    }

    @FXML
    public void save() {
        this.toURL.setURL(this.textUser.getText());
        this.SetButton.setDisable(true);
        this.url = this.toURL.getURL();
        this.LoadButton.setVisible(true);
    }

    @FXML
    public void load() {
        this.FirstText.setVisible(false);
        this.SetButton.setVisible(false);
        this.textUser.setVisible(false);
        this.LoadButton.setDisable(true);
        this.LoadButton.setVisible(false);
        this.userChoice.setVisible(true);
        this.SetButton2.setVisible(true);
        this.SetButton2.setDisable(true);
        this.toConnect = new Connect(this.url);
        this.userChoice.setItems(FXCollections.observableArrayList(this.toConnect.ArrTitle));
    }

    @FXML
    public void save2() throws FileNotFoundException {
        this.position = this.userChoice.getSelectionModel().getSelectedIndex();
        new SaveToFile(this.url, this.position);
        this.ChangeScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void ChangeScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ScrapperScreen.fxml"));
        Pane pane = null;

        try {
            pane = (Pane)loader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        this.mainController.setScreen(pane);
    }

    @FXML
    public void Next() {
        this.ChangeScreen();
    }
}
