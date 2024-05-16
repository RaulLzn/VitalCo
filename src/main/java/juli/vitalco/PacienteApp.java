package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PacienteApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("PacienteView.fxml"));
            Scene scene = new Scene(root, 1280, 800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("VitalCo - Paciente");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
