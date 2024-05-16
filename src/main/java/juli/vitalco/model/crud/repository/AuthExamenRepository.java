package juli.vitalco.model.crud.repository;


import com.google.gson.Gson;
import juli.vitalco.model.crud.shared.FileJsonAdapter;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.domain.AuthExamen;

public class AuthExamenRepository {
    private final FileJsonAdapter<AuthExamen> jsonAdapterAutExamenes;
    private final String pathFile;
    private ListaDobleEnlazada<AuthExamen> listaAutExamenes;
    private final AutorizacionesRepository autorizacionesRepository = new AutorizacionesRepository();

    public AuthExamenRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/AuthExamen.Json";
        this.jsonAdapterAutExamenes = FileJsonAdapter.getInstance(new Gson());
        this.listaAutExamenes = jsonAdapterAutExamenes.getObjects(pathFile, AuthExamen[].class);
    }

    public ListaDobleEnlazada<AuthExamen> obtenerTodos() {
        return listaAutExamenes;
    }

    public void agregarAutExamen(AuthExamen autExamen) {
        listaAutExamenes.agregarAlFinal(autExamen);
        jsonAdapterAutExamenes.writeObjects(pathFile, listaAutExamenes);
    }

    public void eliminarAutExamen(AuthExamen autExamen) {
        listaAutExamenes.eliminarElemento(autExamen);
        jsonAdapterAutExamenes.writeObjects(pathFile, listaAutExamenes);
    }

    public AuthExamen obtenerPorId(String idAutExamen) {
        for (int i = 0; i < listaAutExamenes.tamano(); i++) {
            AuthExamen autExamen = listaAutExamenes.buscarPorIndiceIterar(i);
            if (autExamen.getIdAuthExamen().equals(idAutExamen)) {
                return autExamen;
            }
        }
        return null;
    }

    //enviar a proceso de autorizacion
    public void enviarAAutorizar(AuthExamen autExamen) {
        // Eliminar el examen de la lista de exámenes pendientes
        listaAutExamenes.eliminarElemento(autExamen);

        autorizacionesRepository.enviarAProcesoDeAutorizacion(autExamen);

        // Guardar la lista actualizada en el archivo JSON
        jsonAdapterAutExamenes.writeObjects(pathFile, listaAutExamenes);
    }

    //obtener examen por idPatciente
    public ListaDobleEnlazada<AuthExamen> obtenerPorIdPaciente(String idPaciente) {
        ListaDobleEnlazada<AuthExamen> autExamenesPorPaciente = new ListaDobleEnlazada<>();
        for (int i = 0; i < listaAutExamenes.tamano(); i++) {
            AuthExamen autExamen = listaAutExamenes.buscarPorIndiceIterar(i);
            if (autExamen.getIdPaciente().equals(idPaciente)) {
                autExamenesPorPaciente.agregarAlFinal(autExamen);
            }
        }
        return autExamenesPorPaciente;
    }


}
