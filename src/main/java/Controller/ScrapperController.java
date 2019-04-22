package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Project.Connect;
import Project.NewThread;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ScrapperController {
    public Connect toConnect;
    BufferedReader plik2 = null;
    @FXML
    private TextField ShowText;
    @FXML
    private Button Start;
    private String URL;
    private int position;

    public ScrapperController() {
    }

    @FXML
    public void initialize() throws IOException {
        this.Load();
        this.ShowText.setEditable(false);
    }

    public void Load() throws IOException {
        this.plik2 = new BufferedReader(new FileReader("data.txt"));
        this.URL = this.plik2.readLine();
        this.position = Integer.parseInt(this.plik2.readLine());
        this.plik2.close();
    }

    @FXML
    public void StartScrap() {
        this.Start.setVisible(false);
        NewThread Scrap = new NewThread(this.ShowText, this.URL, this.position);
        Scrap.start();
    }
}
