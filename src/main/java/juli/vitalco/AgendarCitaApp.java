package juli.vitalco;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import juli.vitalco.model.crud.repository.CitaRepository;
import juli.vitalco.model.crud.repository.MedicoRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.*;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;

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

    @FXML
    private Button agendar;

    private final MedicoRepository medicoRepository = new MedicoRepository();
    UserRepository userRepository = new UserRepository();
    CitaRepository citaRepository = new CitaRepository();

    @FXML
    public void initialize() {
        examen.setVisible(false);
        txtExamen.setVisible(false);
        // Configurar el ComboBox de tipo de cita
        tipoCita.getItems().addAll("Cita Normal", "Cita Examen");
        tipoCita.setOnAction(event -> mostrarOcultarExamen());

        // Configurar el ComboBox de especialidad
        especialidad.getItems().addAll(Especialidad.values());
        especialidad.setOnAction(event -> cargarMedicos());

        motivoCita.getItems().addAll("VALORACION", "EXAMEN", "CONTROL");
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
        String tipoSeleccionado = tipoCita.getValue();
        if (tipoSeleccionado != null) {
            switch (tipoSeleccionado) {
                case "Cita Normal":
                    agendarCitaNormal();
                    break;
                case "Cita Examen":
                    agendarCitaExamen();
                    break;
                default:
                    // Manejo de un tipo de cita no reconocido (opcional)
                    break;
            }
        }
    }

    private void agendarCitaNormal() {
        // Obtener los valores seleccionados
        String idPaciente = userRepository.traerIdUsuarioLogeado(); // Obtener el ID del paciente
        Especialidad especialidadSeleccionada = especialidad.getValue();
        String idMedico = medico.getValue(); // Obtener el ID del médico seleccionado

        // Convertir el motivo de cita a enum
        MotivoCita motivo = MotivoCita.valueOf(motivoCita.getValue());

        // Crear la cita normal
        CitaNormal citaNormal = new CitaNormal(idPaciente, especialidadSeleccionada, idMedico, motivo);

        // Lógica adicional de almacenamiento o procesamiento de la cita normal
        citaRepository.agregarCita(citaNormal);

    }

    private void agendarCitaExamen() {
        // Obtener los valores seleccionados
        String idPaciente = userRepository.traerIdUsuarioLogeado(); // Obtener el ID del paciente
        Especialidad especialidadSeleccionada = especialidad.getValue();
        String idMedico = medico.getValue(); // Obtener el ID del médico seleccionado
        Examen examenSeleccionado = examen.getValue(); // Obtener el examen seleccionado
        String idExamen = examenSeleccionado.getDescripcion(); // Obtener el ID del examen

        // Convertir el motivo de cita a enum
        MotivoCita motivo = MotivoCita.valueOf(motivoCita.getValue());

        // Crear la cita de examen
        CitaExamen citaExamen = new CitaExamen(idPaciente, especialidadSeleccionada, idMedico, motivo, idExamen);

        // Lógica adicional de almacenamiento o procesamiento de la cita de examen
        citaRepository.agregarCita(citaExamen);;
    }
    }