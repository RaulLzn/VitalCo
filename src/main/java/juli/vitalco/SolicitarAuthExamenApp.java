package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import juli.vitalco.controller.AgendarExamenViewController;
import juli.vitalco.controller.SolicitarAuthExamenController;

import java.io.IOException;

public class SolicitarAuthExamenApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            // Cargar la vista de Agendar Examen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SolicitarAuthExamenView.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            // Obtener el controlador y configurar la escena
            SolicitarAuthExamenController controller = loader.getController();
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
