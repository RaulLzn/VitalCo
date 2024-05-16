package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AutorizarExamenApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar la vista FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutorizarExamenView.fxml"));
        Parent root = loader.load();

        // Configurar la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Autorizar Examen");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
