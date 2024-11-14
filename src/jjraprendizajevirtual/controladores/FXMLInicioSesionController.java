package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jjraprendizajevirtual.modelo.dao.AutenticacionDAO;
import jjraprendizajevirtual.modelo.pojo.Usuario;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLInicioSesionController implements Initializable {

    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField tfContraseña;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // No es necesario inicializar nada aquí
    }

    @FXML
    private void btnIniciarSesionClic(ActionEvent event) {
        String correo = tfCorreo.getText();
        String contrasena = tfContraseña.getText();

        if (correo.isEmpty() || contrasena.isEmpty()) {
            Utils.mostrarAlerta("Campos vacíos", "Por favor, complete todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        Usuario usuario = AutenticacionDAO.iniciarSesionUsuario(correo, contrasena);

        if (usuario != null) {
            String mensaje = usuario.getAdministrador().equals("1")
                    ? "¡Bienvenido administrador!" : "¡Bienvenido estudiante!";
            Utils.mostrarAlerta("Inicio de sesión exitoso", mensaje, Alert.AlertType.INFORMATION);

            // Cargar la vista con el controlador ya configurado
            Utils.cargarVistaConControlador("/jjraprendizajevirtual/vistas/FXMLMenuPrincipal.fxml", event, usuario);
        } else {
            Utils.mostrarAlerta("Inicio de sesión fallido", "Credenciales incorrectas. Intente nuevamente.", Alert.AlertType.ERROR);
        }
    }
}
