package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import juli.vitalco.controller.AgendarExamenViewController;

import java.io.IOException;

public class AgendarExamenApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            // Cargar la vista de Agendar Examen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendarExamenView.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            // Obtener el controlador y configurar la escena
            AgendarExamenViewController controller = loader.getController();
            controller.initialize();

            Scene scene = new Scene(root, 1280, 800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("VitalCo - Paciente");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
