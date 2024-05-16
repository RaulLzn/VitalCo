package juli.vitalco.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import javafx.util.Callback;
import juli.vitalco.misEstructuras.ListaDobleEnlazada;
import juli.vitalco.model.crud.repository.CitaRepository;
import juli.vitalco.model.crud.repository.UserRepository;
import juli.vitalco.model.domain.Cita;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CancelarCitaViewController {

    @FXML
    private TableView<Cita> citasTable;

    @FXML
    private TableColumn<Cita, String> tipoCita;

    @FXML
    private TableColumn<Cita, String> idCita;

    @FXML
    private TableColumn<Cita, String> especialidad;

    @FXML
    private TableColumn<Cita, String> medico;

    @FXML
    private TableColumn<Cita, String> motivoCita;

    @FXML
    private TableColumn<Cita, Void> cancelar;

    @FXML
    private Button atras;

    CitaRepository citaRepository = new CitaRepository();
    UserRepository userRepository = new UserRepository();

    @FXML
    public void initialize() {
        // Configura las columnas de la tabla
        tipoCita.setCellValueFactory(new PropertyValueFactory<>("tipoCita"));
        idCita.setCellValueFactory(new PropertyValueFactory<>("idCita"));
        especialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        medico.setCellValueFactory(new PropertyValueFactory<>("idMedico"));
        motivoCita.setCellValueFactory(new PropertyValueFactory<>("motivoCita"));

        // Configura la columna de "Cancelar" para que use celdas personalizadas
        cancelar.setCellFactory(new Callback<TableColumn<Cita, Void>, TableCell<Cita, Void>>() {
            @Override
            public TableCell<Cita, Void> call(final TableColumn<Cita, Void> param) {
                final TableCell<Cita, Void> cell = new TableCell<Cita, Void>() {

                    private final Button btn = new Button("Cancelar");

                    {
                        btn.setOnAction(event -> {
                            Cita cita = getTableView().getItems().get(getIndex());
                            // Lógica para cancelar la cita
                            cancelarCita(cita);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        });

        // Cargar las citas en la tabla
        cargarCitas();
    }

    private void cargarCitas() {
        ListaDobleEnlazada<Cita> citas = citaRepository.obtenerPorPaciente(userRepository.traerIdUsuarioLogeado());
        ObservableList<Cita> citasObservableList = convertirAObservableList(citas);
        citasTable.setItems(citasObservableList);
    }

    private ObservableList<Cita> convertirAObservableList(ListaDobleEnlazada<Cita> listaDobleEnlazada) {
        List<Cita> lista = new ArrayList<>();
        for (int i = 0; i < listaDobleEnlazada.tamano(); i++) {
            Cita cita = listaDobleEnlazada.buscarPorIndiceIterar(i);
            lista.add(cita);
        }
        return FXCollections.observableArrayList(lista);
    }

    private void cancelarCita(Cita cita) {
        // Lógica para cancelar la cita en el repositorio
        citaRepository.eliminarCita(cita);

        // Volver a cargar las citas para actualizar la vista
        cargarCitas();
    }

    @FXML
    private void cerrarVentana() {
        // Obtener la referencia al Stage actual y cerrarlo
        Stage stage = (Stage) atras.getScene().getWindow();
        stage.close();
    }
}
