package juli.vitalco.model.domain;

import juli.vitalco.misEstructuras.Generador;
import juli.vitalco.model.crud.repository.CitaRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Cita {
    private String idCita;
    private String tipoCita;
    private String idPaciente;
    private Especialidad especialidad;
    private String idMedico;
    private MotivoCita motivoCita;
    private String costo;
    private boolean atendida;
    private String idAutExamen; // Solo para CitaExamen

    public Cita(String idPaciente, Especialidad especialidad, String idMedico, MotivoCita motivoCita, String idAutExamen) {
        this.idCita = Generador.generarCodigoCita(especialidad, motivoCita);
        this.tipoCita = (motivoCita == MotivoCita.CONTROL) ? "CitaNormal" : "CitaExamen";
        this.idPaciente = idPaciente;
        this.especialidad = especialidad;
        this.idMedico = idMedico;
        this.motivoCita = motivoCita;
        this.costo = (motivoCita == MotivoCita.CONTROL) ? "0" : especialidad.getCosto();
        this.idAutExamen = idAutExamen;
        this.atendida = false;
    }

}
