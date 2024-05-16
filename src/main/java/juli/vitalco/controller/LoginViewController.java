package juli.vitalco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import juli.vitalco.AdminApp;
import juli.vitalco.PacienteApp;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.User;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton; // Cambio en el atributo fx:id del botón

    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(LoginViewController.class.getName());

    public LoginViewController() {
        userRepository = new UserRepository();
    }

    @FXML
    void initialize() {
        loginButton.setOnAction(this::handleLoginAction);
    }


    @FXML
    void handleLoginAction(ActionEvent event) {
        logger.log(Level.INFO, "Intento de inicio de sesión");
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Usuario: " + username);
        System.out.println("Contraseña: " + password);

        // Buscar el usuario en el repositorio
        User user = userRepository.buscarUsuarioPorUsuario(new User(username, password));
        System.out.println("Usuario encontrado: " + user);

        if (user != null) {
            // Cargar y mostrar la vista correspondiente
            try {
                if ("Admin".equals(user.getIdUser())) {
                    AdminApp adminApp = new AdminApp();
                    adminApp.start(new Stage());
                } else {
                    // Llamar a PacienteApp para abrir una nueva ventana con la vista del paciente
                    PacienteApp pacienteApp = new PacienteApp();
                    pacienteApp.start(new Stage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar mensaje de error
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }


    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
