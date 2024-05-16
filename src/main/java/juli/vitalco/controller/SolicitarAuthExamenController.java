package juli.vitalco.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.crud.repository.AuthExamenRepository;
import juli.vitalco.model.crud.repository.AutorizacionesRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.AuthExamen;

import java.util.ArrayList;
import java.util.List;

public class SolicitarAuthExamenController {

    @FXML
    private ComboBox<AuthExamen> examenComboBox;

    private ObservableList<AuthExamen> authExamenes = FXCollections.observableArrayList();
    AuthExamenRepository authExamenRepository = new AuthExamenRepository();
    UserRepository userRepository = new UserRepository();

    public void initialize() {
        // Aquí cargarías los AuthExamen desde tu base de datos o cualquier otra fuente de datos
        // Por ahora, lo agregaremos manualmente como ejemplo
        ListaDobleEnlazada<AuthExamen> authExamenes = new ListaDobleEnlazada<>();
        authExamenes.agregarLista(authExamenRepository.obtenerPorIdPaciente(userRepository.traerIdUsuarioLogeado()));

        // Convertir la ListaDobleEnlazada a una lista estándar de Java
        List<AuthExamen> authExamenList = new ArrayList<>();
        int size = authExamenes.tamano();
        for (int i = 0; i < size; i++) {
            AuthExamen authExamen = authExamenes.buscarPorIndiceIterar(i);
            if (authExamen != null) {
                authExamenList.add(authExamen);
            }
        }

        // Configurar el ComboBox para mostrar los AuthExamen
        examenComboBox.setItems(FXCollections.observableArrayList(authExamenList));
    }


    @FXML
    private void enviarExamen() {
        // Aquí obtendrías el AuthExamen seleccionado por el usuario y realizarías la acción correspondiente
        AuthExamen selectedAuthExamen = examenComboBox.getSelectionModel().getSelectedItem();
        if (selectedAuthExamen != null) {
            AutorizacionesRepository autorizacionesRepository = new AutorizacionesRepository();
            authExamenRepository.enviarAAutorizar(selectedAuthExamen);

            // Crear una ventana emergente de confirmación
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Se ha enviado el examen a autorizar correctamente.");

            // Mostrar la ventana emergente y esperar a que el usuario haga clic en el botón OK
            alert.showAndWait();

            System.out.println("Se seleccionó el examen: " + selectedAuthExamen);
        } else {
            // Manejar el caso donde no se selecciona ningún examen
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("No se selecciono ningun examen");

            alert.showAndWait();

            System.out.println("No se seleccionó ningún examen.");
        }
    }
}
