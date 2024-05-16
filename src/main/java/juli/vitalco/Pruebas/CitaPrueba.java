package juli.vitalco.Pruebas;

import juli.vitalco.model.crud.repository.CitaRepository;
import juli.vitalco.model.domain.Cita;
import juli.vitalco.model.domain.Especialidad;
import juli.vitalco.model.domain.MotivoCita;

public class CitaPrueba {

    public static void main(String[] args) {
        // Crear instancia de CitaRepository para manejar las citas
        CitaRepository citaRepository = new CitaRepository();

        // ID de paciente y médico de ejemplo
        String idPaciente = "123";
        String idMedico = "456";

        // Crear una cita normal de prueba
        Cita citaNormal = new Cita(idPaciente, Especialidad.CARDIOLOGIA, idMedico, MotivoCita.EXAMEN, null);

        // Agregar la cita normal al repositorio
        citaRepository.agregarCita(citaNormal);

        // Crear una cita de examen de prueba
        Cita citaExamen = new Cita(idPaciente, Especialidad.MEDICINA_GENERAL, idMedico, MotivoCita.CONTROL, "789");

        // Agregar la cita de examen al repositorio
        citaRepository.agregarCita(citaExamen);

        // Mostrar todas las citas agregadas
        System.out.println("Citas agregadas:");
        citaRepository.mostrarCitas();

    }
}
