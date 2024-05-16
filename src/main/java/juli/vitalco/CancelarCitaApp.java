package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import juli.vitalco.controller.CancelarCitaViewController;


public class CancelarCitaApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar la vista de Cancelar Cita
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CancelarCitaView.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            // Obtener el controlador y configurar la escena
            CancelarCitaViewController controller = loader.getController();
            controller.initialize();

            Scene scene = new Scene(root, 1280, 800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("VitalCo - Cancelar Cita");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
