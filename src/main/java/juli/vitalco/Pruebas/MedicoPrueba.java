package juli.vitalco.Pruebas;

import juli.vitalco.model.crud.repository.MedicoRepository;
import juli.vitalco.model.domain.Especialidad;
import juli.vitalco.model.domain.Medico;

public class MedicoPrueba {
    public static void main(String[] args) {

        MedicoRepository medicoRepository = new MedicoRepository();

        //crear 4 medicos
        Medico medico1 = new Medico("Juan", Especialidad.CARDIOLOGIA, "1");
        Medico medico2 = new Medico("Pedro", Especialidad.DERMATOLOGIA, "2");
        Medico medico3 = new Medico("Maria", Especialidad.GASTROENTEROLOGIA, "3");
        Medico medico4 = new Medico("Jose", Especialidad.MEDICINA_GENERAL, "4");
        Medico medico5 = new Medico("Luis", Especialidad.PEDIATRIA, "5");

        //agregar medicos
        medicoRepository.agregarMedico(medico1);
        medicoRepository.agregarMedico(medico2);
        medicoRepository.agregarMedico(medico3);
        medicoRepository.agregarMedico(medico4);
        medicoRepository.agregarMedico(medico5);

        //busccar medicos por especialidad
        System.out.println(medicoRepository.obtenerPorEspecialidad(Especialidad.CARDIOLOGIA));

        System.out.println(medicoRepository.obtenerTodos());


    }


}
