package juli.vitalco.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class AutExamen {
    private String idAutExamen;
    private String idPaciente;
    private Examen examen;
    private String estado;


}
