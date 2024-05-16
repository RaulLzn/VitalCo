package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SalaEsperaApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SalaEsperaView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sala de Espera - Vitalco");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
