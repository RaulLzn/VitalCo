package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juli.vitalco.controller.InicioViewController;

import java.io.IOException;

public class VITALCOAPP extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar la vista FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioView.fxml"));
        Parent root = loader.load();

        // Obtener el controlador
        InicioViewController controller = loader.getController();

        // Configurar la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inicio Vitalco");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
