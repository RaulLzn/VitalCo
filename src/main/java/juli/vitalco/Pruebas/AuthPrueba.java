package juli.vitalco.Pruebas;

import juli.vitalco.model.crud.repository.AuthExamenRepository;
import juli.vitalco.model.crud.repository.AutorizacionesRepository;
import juli.vitalco.model.domain.AuthExamen;
import juli.vitalco.model.domain.Estado;
import juli.vitalco.model.domain.Examen;

public class AuthPrueba {
    public static void main(String[] args) {
        // Creamos una instancia del repositorio de exámenes y del repositorio de autorizaciones
        AuthExamenRepository repository = new AuthExamenRepository();
        AutorizacionesRepository repository2 = new AutorizacionesRepository();
//
//        // Creamos algunos objetos AuthExamen para probar
//        AuthExamen examen1 = new AuthExamen("1", "1", Examen.BIOPSIA_PIEL, Estado.POR_AUTORIZAR);
//        AuthExamen examen2 = new AuthExamen("2", "2", Examen.COLONOSCOPIA, Estado.POR_AUTORIZAR);
//        AuthExamen examen3 = new AuthExamen("3", "3", Examen.ECG, Estado.POR_AUTORIZAR);
//
//        // Agregamos los exámenes al repositorio
//        repository.agregarAutExamen(examen1);
//        repository.agregarAutExamen(examen2);
//        repository.agregarAutExamen(examen3);
//
//        // Mostramos todos los exámenes del repositorio
//        System.out.println("Todos los exámenes:");
//        repository.obtenerTodos().imprimirLista();

//        // Enviamos el examen a la pila de autorizaciones
//        repository.enviarAAutorizar(repository.obtenerPorId("2"));

        // Autorizamos el examen
        repository.agregarAutExamen(repository2.procesarUltimaAutorizacion(Estado.AUTORIZADO));

        // Mostramos todos los exámenes después de la autorización
        System.out.println("\nTodos los exámenes después de autorizar el examen 2:");
        repository.obtenerTodos().imprimirLista();
    }
}
