package juli.vitalco.model.crud.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import juli.vitalco.model.crud.shared.GsonUtil;
import juli.vitalco.model.crud.shared.FileJsonAdapter;
import juli.vitalco.model.domain.Cita;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;

public class CitaRepository {
    private final FileJsonAdapter<Cita> jsonAdapterCitas;
    private final String pathFile;
    private ListaDobleEnlazada<Cita> listaCitas;


    public CitaRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/Cita.Json";
        this.jsonAdapterCitas = FileJsonAdapter.getInstance(new Gson());
        this.listaCitas = jsonAdapterCitas.getObjects(pathFile, Cita[].class);
    }

    public ListaDobleEnlazada<Cita> obtenerTodos() {
        return listaCitas;
    }

    public void agregarCita(Cita cita) {
        listaCitas.agregarAlFinal(cita);
        jsonAdapterCitas.writeObjects(pathFile, listaCitas);
    }

    public void eliminarCita(Cita cita) {
        listaCitas.eliminarElemento(cita);
        jsonAdapterCitas.writeObjects(pathFile, listaCitas);
    }

    public Cita obtenerPorId(String idCita) {
        for (int i = 0; i < listaCitas.tamano(); i++) {
            Cita cita = listaCitas.buscarPorIndiceIterar(i);
            if (cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }

    public ListaDobleEnlazada<Cita> obtenerPorPaciente(String idPaciente) {
        ListaDobleEnlazada<Cita> citasPorPaciente = new ListaDobleEnlazada<>();
        for (int i = 0; i < listaCitas.tamano(); i++) {
            Cita cita = listaCitas.buscarPorIndiceIterar(i);
            if (cita.getIdPaciente().equals(idPaciente)) {
                citasPorPaciente.agregarAlFinal(cita);
            }
        }
        return citasPorPaciente;
    }

    //Obtener Cita por id paciente
    public Cita obtenerPorIdPaciente(String idPaciente) {
        for (int i = 0; i < listaCitas.tamano(); i++) {
            Cita cita = listaCitas.buscarPorIndiceIterar(i);
            if (cita.getIdPaciente().equals(idPaciente)) {
                return cita;
            }
        }
        return null;
    }

    public ListaDobleEnlazada<Cita> obtenerPorEspecialidad(String especialidad) {
        ListaDobleEnlazada<Cita> citasPorEspecialidad = new ListaDobleEnlazada<>();
        for (int i = 0; i < listaCitas.tamano(); i++) {
            Cita cita = listaCitas.buscarPorIndiceIterar(i);
            if (cita.getEspecialidad().name().equals(especialidad)) {
                citasPorEspecialidad.agregarAlFinal(cita);
            }
        }
        return citasPorEspecialidad;
    }

    // Mostrar todas las citas agregadas
    public void mostrarCitas() {
        for (int i = 0; i < listaCitas.tamano(); i++) {
            Cita cita = listaCitas.buscarPorIndiceIterar(i);
            System.out.println(cita);
        }
    }
}
