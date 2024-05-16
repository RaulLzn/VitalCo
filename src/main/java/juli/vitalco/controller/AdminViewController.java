package juli.vitalco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juli.vitalco.AutorizarExamenApp;
import juli.vitalco.LoginApp;
import juli.vitalco.SalaEsperaApp;

import java.io.IOException;

public class AdminViewController {

    @FXML
    private Button añadirMedico;

    @FXML
    private Button autorizarExamen;

    @FXML
    private Button salaEspera;

    @FXML
    private Button ayudar;

    @FXML
    private void initialize() {
        añadirMedico.setOnAction(event -> {
            mostrarMensaje("Añadir Médico", "Funcionalidad no implementada");
        });

        autorizarExamen.setOnAction(event -> {
            AutorizarExamenApp autorizarExamenApp = new AutorizarExamenApp();
            try {
                autorizarExamenApp.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        salaEspera.setOnAction(event -> {
            SalaEsperaApp salaEsperaApp = new SalaEsperaApp();
            try {
                salaEsperaApp.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        ayudar.setOnAction(event -> {
            LoginApp loginApp = new LoginApp();
            loginApp.start(new Stage());
        });
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
