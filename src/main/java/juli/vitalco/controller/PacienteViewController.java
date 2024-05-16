package juli.vitalco.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import juli.vitalco.AgendarCitaApp;
import juli.vitalco.AgendarExamenApp;
import juli.vitalco.CancelarCitaApp;
import juli.vitalco.SolicitarAuthExamenApp;

import java.io.IOException;

public class PacienteViewController {

    @FXML
    private Button agendarCitaButton;

    @FXML
    private Button agendarExamenButton;

    @FXML
    private Button autorizarExamenButton;

    @FXML
    private Button modificarCitaButton;

    @FXML
    private Button historialCitaButton;

    @FXML
    private Button cancelarCitaButton;

    @FXML
    private ImageView imageView;

    @FXML
    void initialize() {
        // Configurar acciones de los botones (si es necesario)
        agendarCitaButton.setOnAction(event -> {
            AgendarCitaApp agendarCitaApp = new AgendarCitaApp();
            agendarCitaApp.start(new Stage());
        });

        agendarExamenButton.setOnAction(event -> {
            AgendarExamenApp agendarExamenApp = new AgendarExamenApp();
            try {
                agendarExamenApp.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        autorizarExamenButton.setOnAction(event -> {
            SolicitarAuthExamenApp solicitarAuthExamenApp = new SolicitarAuthExamenApp();
            try {
                solicitarAuthExamenApp.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        modificarCitaButton.setOnAction(event -> {
            // Lógica para la acción de modificar cita
        });

        historialCitaButton.setOnAction(event -> {
            // Lógica para la acción de historial de cita
        });

        cancelarCitaButton.setOnAction(event -> {
            CancelarCitaApp cancelarCitaApp = new CancelarCitaApp();
            cancelarCitaApp.start(new Stage());
        });
    }
}
