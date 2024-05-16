package juli.vitalco.controller;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.crud.repository.AuthExamenRepository;
import juli.vitalco.model.crud.repository.CitaRepository;
import juli.vitalco.model.crud.repository.MedicoRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.crud.shared.FileJsonAdapter;
import juli.vitalco.model.domain.*;

public class AgendarCitaViewController {

    @FXML
    private ComboBox<String> tipoCita;

    @FXML
    private ComboBox<Especialidad> especialidad;

    @FXML
    private ComboBox<String> medico;

    @FXML
    private ComboBox<String> motivoCita;

    @FXML
    private ComboBox<Examen> examen;

    @FXML
    private Text txtExamen;

    private final MedicoRepository medicoRepository = new MedicoRepository();
    private final UserRepository userRepository = new UserRepository();
    private final AuthExamenRepository authExamenRepository = new AuthExamenRepository();

    @FXML
    public void initialize() {
        examen.setVisible(false);
        txtExamen.setVisible(false);
        tipoCita.getItems().addAll("Cita Normal", "Cita Examen");
        tipoCita.setOnAction(event -> mostrarOcultarExamen());

        especialidad.getItems().addAll(Especialidad.values());
        especialidad.setOnAction(event -> cargarMedicos());

        motivoCita.getItems().addAll("VALORACION", "EXAMEN", "CONTROL");
        cargarExamenesUsuario();
    }

    private void cargarExamenesUsuario() {
        String idPaciente = userRepository.traerIdUsuarioLogeado();
        ListaDobleEnlazada<AuthExamen> examenesAutorizados = authExamenRepository.obtenerPorIdPaciente(idPaciente);

        examen.getItems().clear();

        // Aquí obtenemos Gson con el adaptador personalizado
        Gson gson = FileJsonAdapter.getInstance(null).getGsonWithCustomAdapters();

        for (int i = 0; i < examenesAutorizados.tamano(); i++) {
            Examen examenAutorizado = examenesAutorizados.buscarPorIndiceIterar(i).getExamen();
            examen.getItems().add(examenAutorizado);
        }
    }


    private void mostrarOcultarExamen() {
        String tipoSeleccionado = tipoCita.getValue();
        if (tipoSeleccionado != null && tipoSeleccionado.equals("Cita Examen")) {
            examen.setVisible(true);
            txtExamen.setVisible(true);
        } else {
            examen.setVisible(false);
            txtExamen.setVisible(false);
        }
    }

    private void cargarMedicos() {
        Especialidad especialidadSeleccionada = especialidad.getValue();
        if (especialidadSeleccionada != null) {
            medico.getItems().clear();
            ListaDobleEnlazada<Medico> medicosPorEspecialidad = medicoRepository.obtenerPorEspecialidad(especialidadSeleccionada);
            int tamano = medicosPorEspecialidad.tamano();
            for (int i = 0; i < tamano; i++) {
                Medico medicoActual = medicosPorEspecialidad.buscarPorIndiceIterar(i);
                medico.getItems().add(medicoActual.getNombre());
            }
        }
    }

    @FXML
    private void agendarCita() {
        String idPaciente = userRepository.traerIdUsuarioLogeado();
        Especialidad especialidadSeleccionada = especialidad.getValue();
        String idMedico = medico.getValue();
        MotivoCita motivo = MotivoCita.valueOf(motivoCita.getValue());
        String tipoSeleccionado = tipoCita.getValue();

        String idAutExamen = null;
        if (tipoSeleccionado != null && tipoSeleccionado.equals("Cita Examen")) {
            Examen examenSeleccionado = examen.getValue();
            if (examenSeleccionado != null) {
                idAutExamen = examenSeleccionado.getDescripcion();
            } else {
                // Manejar la situación si no se selecciona ningún examen
                // Por ejemplo, mostrar un mensaje de error
                return;
            }
        }

        Cita cita = new Cita(idPaciente, especialidadSeleccionada, idMedico, motivo, idAutExamen);

        CitaRepository citaRepository = new CitaRepository();
        citaRepository.agregarCita(cita);

        // Mostrar una ventana emergente de confirmación
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cita Agendada");
        alert.setHeaderText(null);
        alert.setContentText("La cita ha sido agendada correctamente.");
        alert.showAndWait();
    }
}