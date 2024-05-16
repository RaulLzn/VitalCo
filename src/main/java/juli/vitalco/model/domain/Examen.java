package juli.vitalco.model.domain;

public enum Examen {
    ELECTRO(Especialidad.CARDIOLOGIA, "Electrocardiograma para adultos"),
    ECOGRAFIA(Especialidad.CARDIOLOGIA, "Ecografía cardíaca (transtorácica)"),
    BIOPSIA_PIEL(Especialidad.DERMATOLOGIA, "Biopsia de piel (escisión)" ),
    DERMATOSCOPIA(Especialidad.DERMATOLOGIA, "Dermatoscopia de piel"),
    ENDOSCOPIA(Especialidad.GASTROENTEROLOGIA, "Endoscopia digestiva"),
    COLONOSCOPIA(Especialidad.GASTROENTEROLOGIA, "Colonoscopia total"),
    ECOGRAFIA_ABDOMINAL(Especialidad.PEDIATRIA, "Ecografía abdominal en niños"),
    PRUEBA_DE_ALERGIA(Especialidad.PEDIATRIA, "Prueba de alergia en niños"),;

    private final Especialidad especialidad;
    private final String descripcion;

    Examen(Especialidad especialidad, String descripcion) {
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
