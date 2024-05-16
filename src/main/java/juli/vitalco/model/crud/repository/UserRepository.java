package juli.vitalco.model.crud.repository;

import com.google.gson.Gson;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.domain.User;
import juli.vitalco.model.crud.shared.FileJsonAdapter;

public class UserRepository {
    private final FileJsonAdapter<User> jsonAdapterUsers;
    private final String pathFile;
    private ListaDobleEnlazada<User> listaUsers;

    /**
     * Constructor de la clase UserRepository
     */
    public UserRepository() {
        this.pathFile = "src/main/java/juli/vitalco/database/User.Json"; // Reemplaza "path/to/users.json" con la ruta real de tu archivo JSON
        this.jsonAdapterUsers = FileJsonAdapter.getInstance(new Gson());
        this.listaUsers = jsonAdapterUsers.getObjects(pathFile, User[].class);
    }

    /**
     * Método para obtener todos los usuarios
     * @return listaUsers
     */
    public ListaDobleEnlazada<User> obtenerTodos() {
        return listaUsers;
    }

    /**
     * Método para agregar un usuario
     * @param user
     */
    public void agregarUser(User user) {
        listaUsers.agregarAlFinal(user);
        jsonAdapterUsers.writeObjects(pathFile, listaUsers);
    }

    /**
     * Método para eliminar un usuario
     * @param user
     */
    public void eliminarUser(User user) {
        listaUsers.eliminarElemento(user);
        jsonAdapterUsers.writeObjects(pathFile, listaUsers);
    }

    /**
     * Método para buscar un usuario por su ID
     * @param user
     * @return user
     */
    public User buscarUsuarioPorUsuario(User user) {
        for (int i = 0; i < listaUsers.tamano(); i++) {
            User usuario = listaUsers.buscarPorIndiceIterar(i);
            if (usuario.getIdUser().equals(user.getIdUser())) {
                return usuario;
            }
        }
        return null;
    }

    //traer el id del usuario que este logeado
    public String traerIdUsuarioLogeado(){
        for (int i = 0; i < listaUsers.tamano(); i++) {
            User usuario = listaUsers.buscarPorIndiceIterar(i);
            if (usuario.isLogged()) {
                return usuario.getIdUser();
            }
        }
        return null;
    }

}
