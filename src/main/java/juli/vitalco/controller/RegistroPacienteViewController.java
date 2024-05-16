package juli.vitalco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import juli.vitalco.LoginApp;
import juli.vitalco.model.crud.repository.PacienteRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.Paciente;
import juli.vitalco.model.domain.User;

import java.io.IOException;

public class RegistroPacienteViewController {

    @FXML
    private TextField documento;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;

    @FXML
    private TextField edad;

    @FXML
    private TextField telefono;

    @FXML
    private TextField correo;

    @FXML
    private PasswordField contraseña;

    @FXML
    private Button registrar;

    private final PacienteRepository pacienteRepository = new PacienteRepository();
    private final UserRepository userRepository = new UserRepository();

    @FXML
    void registrar(ActionEvent event) {
        String documentoText = documento.getText();
        String nombreText = nombre.getText();
        String apellidoText = apellido.getText();
        String edadText = edad.getText();
        String telefonoText = telefono.getText();
        String correoText = correo.getText();
        String contraseñaText = contraseña.getText();

        Paciente paciente = new Paciente(documentoText, nombreText, apellidoText, edadText, telefonoText, correoText);
        pacienteRepository.agregarPaciente(paciente);

        User user = new User(documentoText, contraseñaText);
        userRepository.agregarUser(user);

        mostrarMensaje("Registro Exitoso", "Se ha registrado con éxito.");

        abrirVentanaLogin();


    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void abrirVentanaLogin() {
        LoginApp loginApp = new LoginApp();
        loginApp.start(new Stage());
        Stage stage = (Stage) registrar.getScene().getWindow();
        stage.close();

    }
}
