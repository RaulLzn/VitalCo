package juli.vitalco.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AuthExamen {
    private String idAuthExamen;
    private String idPaciente;
    private Examen examen;
    private Estado estado;
    private String descripcion;

    public AuthExamen(String idAuthExamen, String idPaciente, Examen examen, Estado estado) {
        this.idAuthExamen = idAuthExamen;
        this.idPaciente = idPaciente;
        this.examen = examen;
        this.estado = estado;
        this.descripcion = examen.getDescripcion();
    }

}
