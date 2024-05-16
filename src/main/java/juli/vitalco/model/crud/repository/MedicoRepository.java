package juli.vitalco.model.crud.repository;

import com.google.gson.Gson;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.domain.Especialidad;
import juli.vitalco.model.domain.Medico;
import juli.vitalco.model.crud.shared.FileJsonAdapter;

public class MedicoRepository {
    private final FileJsonAdapter<Medico> jsonAdapterMedicos;
    private final String pathFile;
    private ListaDobleEnlazada<Medico> listaMedicos;

    public MedicoRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/Medico.Json";
        this.jsonAdapterMedicos = FileJsonAdapter.getInstance(new Gson());
        this.listaMedicos = jsonAdapterMedicos.getObjects(pathFile, Medico[].class);
    }

    public ListaDobleEnlazada<Medico> obtenerTodos() {
        return listaMedicos;
    }

    public void agregarMedico(Medico medico) {
        listaMedicos.agregarAlFinal(medico);
        jsonAdapterMedicos.writeObjects(pathFile, listaMedicos);
    }

    public void eliminarMedico(Medico medico) {
        listaMedicos.eliminarElemento(medico);
        jsonAdapterMedicos.writeObjects(pathFile, listaMedicos);
    }

    // Método para obtener un medico por su ID
    public Medico obtenerPorId(String idMedico) {
        for (int i = 0; i < listaMedicos.tamano(); i++) {
            Medico medico = listaMedicos.buscarPorIndiceIterar(i);
            if (medico.getIdeMedico().equals(idMedico)) {
                return medico;
            }
        }
        return null;
    }

    // Obtener medicos por Especialidad
    public ListaDobleEnlazada<Medico> obtenerPorEspecialidad(Especialidad especialidad) {
        ListaDobleEnlazada<Medico> medicosPorEspecialidad = new ListaDobleEnlazada<>();
        for (int i = 0; i < listaMedicos.tamano(); i++) {
            Medico medico = listaMedicos.buscarPorIndiceIterar(i);
            if (medico.getEspecialidad().equals(especialidad)) {
                medicosPorEspecialidad.agregarAlFinal(medico);
            }
        }
        return medicosPorEspecialidad;
    }


    //obtener idMedico por Medico
    public String obtenerIdMedicoPorMedico(Medico medico) {
        for (int i = 0; i < listaMedicos.tamano(); i++) {
            Medico medico1 = listaMedicos.buscarPorIndiceIterar(i);
            if (medico1.equals(medico)) {
                return medico1.getIdeMedico();
            }
        }
        return null;
    }



}
