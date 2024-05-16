package juli.vitalco.model.domain;

public enum Especialidad {
    MEDICINA_GENERAL("10"),
    CARDIOLOGIA("50"),
    DERMATOLOGIA("40"),
    GASTROENTEROLOGIA("60"),
    PEDIATRIA("45");

    private final String costo;

    Especialidad(String costo) {
        this.costo = costo;
    }

    public String getCosto() {
        return costo;
    }
}
