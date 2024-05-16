package juli.vitalco.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Paciente {
    private String idpaciente;
    private String nombre;
    private String apellido;
    private String edad;
    private String telefono;
    private String correo;

}
