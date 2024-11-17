package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import jjraprendizajevirtual.modelo.dao.ArchivosDAO;
import jjraprendizajevirtual.modelo.pojo.Recurso;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLConsultarArchivoController implements Initializable {

    @FXML
    private ListView<String> lvArchivos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarArchivos();
    }

    private void cargarArchivos() {
        List<Recurso> recursos = ArchivosDAO.obtenerRecursos();
        if (recursos != null && !recursos.isEmpty()) {
            for (Recurso recurso : recursos) {
                String detalle = recurso.getTitulo() + " - " + recurso.getAutor();
                switch (recurso.getTipo()) {
                    case "Documento":
                        detalle += " (Contenido: " + recurso.getContenido() + ")";
                        break;
                    case "Imagen":
                        detalle += " (Resolución: " + recurso.getResolucion() + ")";
                        break;
                    case "Video":
                        detalle += " (Duración: " + recurso.getDuracion() + ")";
                        break;
                }
                lvArchivos.getItems().add(detalle);
            }
        } else {
            Utils.mostrarAlerta("Información", "No hay recursos disponibles", Alert.AlertType.INFORMATION);
        }
    }
}
