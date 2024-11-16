package jjraprendizajevirtual.utilidades;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import jjraprendizajevirtual.JJRAprendizajeVirtual;
import jjraprendizajevirtual.controladores.FXMLMenuPrincipalController;
import jjraprendizajevirtual.modelo.pojo.Usuario;

/**
 * Clase de utilidades
 */
public class Utils {

    public static void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    public static <T> void cargarVistaConControlador(String rutaVista, ActionEvent evento, 
            Usuario usuario, Class<T> controladorClase) {
        try {
            FXMLLoader loader = new FXMLLoader(JJRAprendizajeVirtual.class.getResource(rutaVista));
            Parent root = loader.load();

            // Obtener el controlador
            T controlador = loader.getController();
            if (controlador instanceof FXMLMenuPrincipalController) {
                ((FXMLMenuPrincipalController) controlador).inicializarMenu(usuario);
            }

            // Cambiar la escena
            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo cargar la vista: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public static boolean validarCampo(String campo) {
        if (campo.trim().isEmpty())
        {
            return false;
        }
        return true;
    }
}
