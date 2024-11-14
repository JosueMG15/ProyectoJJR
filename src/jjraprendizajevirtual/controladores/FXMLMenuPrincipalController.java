package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jjraprendizajevirtual.modelo.pojo.Usuario;

/**
 * FXML Controller class
 */
public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;
    @FXML
    private Button btnSubirArchivo; // Ahora correctamente inicializado desde FXML
    private Usuario usuarioActual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // No es necesario inicializar manualmente aquí.
    }

    public void inicializarMenu(Usuario usuario) {
        this.usuarioActual = usuario;

        lbMenuPrincipal.setText("Bienvenido, " + usuario.getNombre());

        if (usuario.getAdministrador().equals("0")) {
            btnSubirArchivo.setDisable(true); // Desactiva el botón si no es administrador
        }
    }

    @FXML
    private void btnSubirArchivo(ActionEvent event) {
        System.out.println("Subiendo archivo...");
    }

    @FXML
    private void btnConsultarArchivo(ActionEvent event) {
        System.out.println("Consultando archivo...");
    }

    @FXML
    private void btnForo(ActionEvent event) {
        System.out.println("Abriendo foro...");
    }

    @FXML
    private void btnError(ActionEvent event) {
        System.out.println("Error...");
    }
}
