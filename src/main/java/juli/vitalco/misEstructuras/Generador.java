package juli.vitalco.misEstructuras;

import juli.vitalco.model.domain.Especialidad;
import juli.vitalco.model.domain.MotivoCita;

import java.util.Random;

public class Generador {

    public static String generarCodigoCita(Especialidad especialidad, MotivoCita motivoCita) {
        StringBuilder codigo = new StringBuilder();

        // Tomar la primera letra de la especialidad y del motivo de cita
        codigo.append(especialidad.name().charAt(0));
        codigo.append(motivoCita.name().charAt(0));

        // Generar tres números aleatorios
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            codigo.append(random.nextInt(10));
        }

        return codigo.toString();
    }

    //Generar un codigo aleatorio de 5 caracteres entre letras y numeros
    public static String generarCodigo() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generar la letra aleatoria
        char letra = generarLetraAleatoria();
        sb.append(letra);

        // Generar los números aleatorios
        for (int i = 0; i < 3; i++) {
            int numeroAleatorio = random.nextInt(10); // Números del 0 al 9
            sb.append(numeroAleatorio);
        }

        return sb.toString();
    }

    // Método auxiliar para generar una letra aleatoria (mayúscula)
    private static char generarLetraAleatoria() {
        Random random = new Random();
        // Rango de letras mayúsculas en ASCII (A=65, Z=90)
        return (char) (random.nextInt(26) + 65);
    }

}