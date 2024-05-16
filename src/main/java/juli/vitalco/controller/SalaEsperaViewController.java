package juli.vitalco.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import juli.vitalco.model.crud.repository.CitaRepository;
import juli.vitalco.model.domain.Cita;
import juli.vitalco.misEstructuras.Cola;

public class SalaEsperaViewController {

    @FXML
    private Label cita1;

    @FXML
    private Label cita2;

    @FXML
    private Label cita3;

    private final CitaRepository citaRepository = new CitaRepository();
    private final Cola<Cita> colaCitas = new Cola<>();

    @FXML
    public void initialize() {
        obtenerCitasParaSalaEspera();
        mostrarCitasEnEspera();
    }

    private void obtenerCitasParaSalaEspera() {
        colaCitas.vaciar(); // Vaciar la cola por si acaso

        // Obtener todas las citas y agregarlas a la cola
        int totalCitas = citaRepository.obtenerTodos().tamano();
        for (int i = 0; i < totalCitas; i++) {
            Cita cita = citaRepository.obtenerTodos().buscarPorIndiceIterar(i);
            colaCitas.enqueue(cita);
        }
    }

    private void mostrarCitasEnEspera() {
        // Sacar las citas de la cola y mostrar sus IDs en los labels correspondientes
        cita1.setText(colaCitas.estaVacia() ? "" : colaCitas.dequeue().getIdCita());
        cita2.setText(colaCitas.estaVacia() ? "" : colaCitas.dequeue().getIdCita());
        cita3.setText(colaCitas.estaVacia() ? "" : colaCitas.dequeue().getIdCita());
    }
}
