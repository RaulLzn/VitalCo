package juli.vitalco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SolicitarAuthExamenApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar la vista FXML
        Parent root = loadFXML("solicitar_auth_examen");

        // Configurar la escena
        Scene scene = new Scene(root, 1280, 800);

        // Configurar el escenario principal (Stage)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Solicitar Autorización de Examen");
        primaryStage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/juli/vitalco/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
