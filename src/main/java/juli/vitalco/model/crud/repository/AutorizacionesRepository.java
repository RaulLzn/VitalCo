package juli.vitalco.model.crud.repository;

import com.google.gson.Gson;
import juli.vitalco.model.domain.AuthExamen;
import juli.vitalco.model.crud.shared.FileJsonAdapter;
import juli.vitalco.misEstructuras.Pila;
import juli.vitalco.model.domain.Estado;

public class AutorizacionesRepository {
    private final FileJsonAdapter<AuthExamen> jsonAdapterAuthExamen;
    private final String pathFile;
    private Pila<AuthExamen> pilaAutorizaciones;

    public AutorizacionesRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/Autorizaciones.Json";
        this.jsonAdapterAuthExamen = FileJsonAdapter.getInstance(new Gson());
        this.pilaAutorizaciones = jsonAdapterAuthExamen.getObjectsStack(pathFile, AuthExamen[].class);
    }

    //añadir a la pila
    public void enviarAProcesoDeAutorizacion(AuthExamen authExamen) {
        pilaAutorizaciones.push(authExamen);
        jsonAdapterAuthExamen.writeObjectsStack(pathFile, pilaAutorizaciones);
    }

    public AuthExamen procesarUltimaAutorizacion(Estado nuevoEstado) {

        if (!pilaAutorizaciones.estaVacia()) {
            // Obtener el examen en la cima de la pila (último enviado para autorización)
            AuthExamen authExamen = pilaAutorizaciones.pop();
            // Actualizar el estado del examen
            authExamen.setEstado(nuevoEstado);
            // Eliminar el examen de la pila de autorizaciones
            // Guardar la pila actualizada en el archivo JSON
            jsonAdapterAuthExamen.writeObjectsStack(pathFile, pilaAutorizaciones);

            return authExamen;
        } else {
            System.out.println("No hay exámenes pendientes de autorización en la pila.");
        }
        return null;
    }

    public AuthExamen obtenerUltimaAutorizacion() {
        if (!pilaAutorizaciones.estaVacia()) {
            return pilaAutorizaciones.peek();
        }
        return null;
    }
}
