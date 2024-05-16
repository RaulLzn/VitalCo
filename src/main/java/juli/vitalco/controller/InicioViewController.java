package juli.vitalco.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import juli.vitalco.LoginApp;
import juli.vitalco.RegistroPacienteApp;

import java.io.IOException;

public class InicioViewController {

    @FXML
    private Button registrarPacienteButton;

    @FXML
    private Button iniciarSesionUsuarioButton;

    @FXML
    private Button iniciarSesionAdminButton;

    @FXML
    private void initialize() {

        registrarPacienteButton.setOnAction(event -> {
            RegistroPacienteApp registroPacienteApp = new RegistroPacienteApp();
            try {
                registroPacienteApp.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        iniciarSesionAdminButton.setOnAction(event -> {
            LoginApp loginApp = new LoginApp();
            loginApp.start(new Stage());
        });

        iniciarSesionUsuarioButton.setOnAction(event -> {
            LoginApp loginApp = new LoginApp();
            loginApp.start(new Stage());
        });
    }
}
