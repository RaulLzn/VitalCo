package juli.vitalco.model.crud.repository;

import com.google.gson.Gson;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.domain.Paciente;
import juli.vitalco.model.crud.shared.FileJsonAdapter;

public class PacienteRepository {
    private final FileJsonAdapter<Paciente> jsonAdapterPacientes;
    private final String pathFile;
    private ListaDobleEnlazada<Paciente> listaPacientes;

    public PacienteRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/Paciente.Json";
        this.jsonAdapterPacientes = FileJsonAdapter.getInstance(new Gson());
        this.listaPacientes = jsonAdapterPacientes.getObjects(pathFile, Paciente[].class);
    }

    public ListaDobleEnlazada<Paciente> obtenerTodos() {
        return listaPacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        listaPacientes.agregarAlFinal(paciente);
        jsonAdapterPacientes.writeObjects(pathFile, listaPacientes);
    }

    public void eliminarPaciente(Paciente paciente) {
        listaPacientes.eliminarElemento(paciente);
        jsonAdapterPacientes.writeObjects(pathFile, listaPacientes);
    }

    // Método para obtener un paciente por su ID
    public Paciente obtenerPorId(String idPaciente) {
        for (int i = 0; i < listaPacientes.tamano(); i++) {
            Paciente paciente = listaPacientes.buscarPorIndiceIterar(i);
            if (paciente.getIdpaciente().equals(idPaciente)) {
                return paciente;
            }
        }
        return null;
    }

}
