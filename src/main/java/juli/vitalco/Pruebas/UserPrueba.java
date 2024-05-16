package juli.vitalco.Pruebas;

import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.User;

public class UserPrueba {
    public static void main(String[] args) {
        // Crear una instancia de UserRepository
        UserRepository userRepository = new UserRepository();

//        // Crear dos usuarios
//        User user1 = new User("usuario1", "contraseña1");
//        User user2 = new User("usuario2", "contraseña2");
//
//        // Agregar los usuarios a la lista
//        userRepository.agregarUser(user1);
//        userRepository.agregarUser(user2);
//
//        // Mostrar la lista de usuarios después de agregarlos
//        ListaDobleEnlazada<User> listaUsuarios = userRepository.obtenerTodos();
//        System.out.println("Lista de usuarios después de agregar:");
//        for (int i = 0; i < listaUsuarios.tamano(); i++) {
//            User usuario = listaUsuarios.buscarPorIndiceIterar(i);
//            System.out.println("ID de usuario: " + usuario.getIdUser());
//        }

        // Buscar un usuario por su usuario
        User usuarioBuscado = userRepository.buscarUsuarioPorUsuario(new User("usuario1", "contraseña1"));
        System.out.println("Usuario encontrado: " + usuarioBuscado.getIdUser());

    }
}
