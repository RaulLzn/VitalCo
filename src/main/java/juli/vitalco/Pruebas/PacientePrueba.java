package juli.vitalco.Pruebas;

import juli.vitalco.model.crud.repository.PacienteRepository;
import juli.vitalco.model.domain.Paciente;

public class PacientePrueba {
    public static void main(String[] args) {
        // Creamos una instancia del repositorio
        PacienteRepository repository = new PacienteRepository();

        // Creamos algunos objetos de Paciente para probar
        Paciente paciente1 = new Paciente("1", "Juan", "García", "30", "123456789", "juan@example.com");
        Paciente paciente2 = new Paciente("2", "María", "López", "25", "987654321", "maria@example.com");

        // Agregamos los pacientes al repositorio
        repository.agregarPaciente(paciente1);
        repository.agregarPaciente(paciente2);

        // Buscamos un paciente por su ID
        String idBusqueda = "1";
        System.out.println("\nPaciente con ID " + idBusqueda + ":");
        Paciente pacienteEncontrado = repository.obtenerPorId(idBusqueda);
        if (pacienteEncontrado != null) {
            System.out.println(pacienteEncontrado);
        } else {
            System.out.println("No se encontró ningún paciente con el ID " + idBusqueda);
        }

        // Mostramos todos los pacientes después de la eliminación
        System.out.println("\nTodos los pacientes después de eliminar el paciente 1:");
        repository.obtenerTodos().imprimirLista();
    }
}
