package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import juli.vitalco.controller.AgendarCitaViewController;

public class AgendarCitaApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar la vista de Agendar Cita
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendarCitaView.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            // Obtener el controlador y configurar la escena
            AgendarCitaViewController controller = loader.getController();
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
