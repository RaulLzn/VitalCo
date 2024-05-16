package juli.vitalco.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.User;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private UserRepository userRepository;

    public LoginViewController() {
        userRepository = new UserRepository();
    }

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Buscar el usuario en el repositorio
        User user = userRepository.buscarUsuarioPorUsuario(new User(username, password));

        if (user != null) {
            // Abrir la vista de paciente
            // Aquí deberías abrir la vista correspondiente, por ejemplo:
            // abrirVistaPaciente();
            System.out.println("Usuario autenticado: " + user.getIdUser());
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
