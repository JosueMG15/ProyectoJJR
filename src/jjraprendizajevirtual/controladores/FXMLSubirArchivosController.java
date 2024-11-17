package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import jjraprendizajevirtual.modelo.dao.ArchivosDAO;
import jjraprendizajevirtual.utilidades.SingletonUsuario;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLSubirArchivosController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfAutor;
    @FXML
    private TextField tfUrl;
    @FXML
    private ComboBox<String> cbTipoRecurso;
    @FXML
    private TextField tfExtra; // Para atributos específicos

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTipoRecurso.setItems(FXCollections.observableArrayList("Documento", "Imagen", "Video"));
    }

    @FXML
    private void btnGuardarArchivo(ActionEvent event) {
        String titulo = tfTitulo.getText().trim();
        String autor = tfAutor.getText().trim();
        String url = tfUrl.getText().trim();
        String tipoRecurso = cbTipoRecurso.getValue();
        String extra = tfExtra.getText().trim();

        if (!titulo.isEmpty() && !autor.isEmpty() && !url.isEmpty() && tipoRecurso != null) {
            boolean resultado = false;

            switch (tipoRecurso) {
                case "Documento":
                    resultado = ArchivosDAO.guardarDocumento(titulo, autor, url, extra);
                    break;
                case "Imagen":
                    resultado = ArchivosDAO.guardarImagen(titulo, autor, url, extra);
                    break;
                case "Video":
                    resultado = ArchivosDAO.guardarVideo(titulo, autor, url, extra);
                    break;
            }

            if (resultado) {
                Utils.mostrarAlerta("Éxito", "Recurso guardado correctamente", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                Utils.mostrarAlerta("Error", "No se pudo guardar el recurso", Alert.AlertType.ERROR);
            }
        } else {
            Utils.mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
        }
    }

    private void limpiarCampos() {
        tfTitulo.clear();
        tfAutor.clear();
        tfUrl.clear();
        tfExtra.clear();
        cbTipoRecurso.getSelectionModel().clearSelection();
    }

    @FXML
    private void btnCancelar(ActionEvent event) {
        try {
            Utils.cargarVistaConControlador("vistas/FXMLMenuPrincipal.fxml", event, SingletonUsuario.getInstaniaUsuario().getUsuario(),
                    FXMLMenuPrincipalController.class);
        } catch (Exception e) {
            e.printStackTrace();
            Utils.mostrarAlerta("Error", "No se pudo cargar la vista: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
