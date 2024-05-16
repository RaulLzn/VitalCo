package juli.vitalco.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import juli.vitalco.misEstructuras.Generador;
import juli.vitalco.model.crud.repository.AuthExamenRepository;
import juli.vitalco.model.crud.repository.AutorizacionesRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.AuthExamen;
import juli.vitalco.model.domain.Estado;
import juli.vitalco.model.domain.Examen;

public class AgendarExamenViewController {
    UserRepository userRepository = new UserRepository();

    @FXML
    private ComboBox<Examen> examenComboBox;

    @FXML
    private Button agendarButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        // Añade todos los exámenes al ComboBox
        examenComboBox.getItems().addAll(Examen.values());
    }

    @FXML
    public void agendarExamen() {
        Examen examenSeleccionado = examenComboBox.getValue();
        if (examenSeleccionado != null) {
            // Crea un objeto AuthExamen
            AuthExamen authExamen = new AuthExamen(Generador.generarCodigo(), userRepository.traerIdUsuarioLogeado(), examenSeleccionado, Estado.POR_AUTORIZAR);
            AuthExamenRepository authExamenRepository = new AuthExamenRepository();
            authExamenRepository.agregarAutExamen(authExamen);
            statusLabel.setText("Examen agendado: " + authExamen.getDescripcion());
            System.out.println("Examen agendado: " + authExamen);
        } else {
            statusLabel.setText("No se ha seleccionado ningún examen.");
            System.out.println("No se ha seleccionado ningún examen.");
        }
    }
}
