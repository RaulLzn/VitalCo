package juli.vitalco.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Medico {
    String nombre;
    Especialidad especialidad;
    String ideMedico;

}
