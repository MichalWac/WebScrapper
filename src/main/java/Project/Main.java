package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        StackPane stackPane = (StackPane)loader.load();
        Scene scene = new Scene(stackPane, 300.0D, 200.0D);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WebScrapper");
        primaryStage.setOnCloseRequest((eh) -> {
            System.exit(-1);
        });
        primaryStage.show();
    }
}
