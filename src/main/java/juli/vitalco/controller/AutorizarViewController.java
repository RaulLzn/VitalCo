package juli.vitalco.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import juli.vitalco.model.crud.repository.AutorizacionesRepository;
import juli.vitalco.model.domain.AuthExamen;
import juli.vitalco.model.domain.Estado;

public class AutorizarViewController {

    @FXML
    private Label examen;

    @FXML
    private Button autorizar;

    private final AutorizacionesRepository autorizacionesRepository = new AutorizacionesRepository();

    @FXML
    public void initialize() {
        mostrarUltimoExamen();
    }

    @FXML
    void autorizarExamen() {
        // Procesar la última autorización con el nuevo estado
        AuthExamen authExamen = autorizacionesRepository.procesarUltimaAutorizacion(Estado.AUTORIZADO);

        if (authExamen != null) {
            mostrarUltimoExamen();
        }
    }

    private void mostrarUltimoExamen() {
        // Obtener el último examen para autorizar
        AuthExamen ultimoExamen = autorizacionesRepository.obtenerUltimaAutorizacion();

        if (ultimoExamen != null) {
            examen.setText(ultimoExamen.toString());
        } else {
            examen.setText("No hay exámenes pendientes de autorización.");
        }
    }
}
