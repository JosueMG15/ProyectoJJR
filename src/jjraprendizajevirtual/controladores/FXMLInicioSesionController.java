package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jjraprendizajevirtual.JJRAprendizajeVirtual;
import jjraprendizajevirtual.modelo.dao.AutenticacionDAO;
import jjraprendizajevirtual.modelo.pojo.Usuario;
import jjraprendizajevirtual.utilidades.SingletonUsuario;
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
            if (usuario.getAdministrador().equals("1")) {
                SingletonUsuario.getInstaniaUsuario().setUsuario(usuario);
                String mensaje = "¡Bienvenido administrador!";
                Utils.mostrarAlerta("Inicio de sesión exitoso", mensaje, Alert.AlertType.INFORMATION);
            } else {
                SingletonUsuario.getInstaniaUsuario().setUsuario(usuario);
                String mensaje = "¡Bienvenido estudiante";
                Utils.mostrarAlerta("Inicio de sesión exitoso", mensaje, Alert.AlertType.INFORMATION);
            }

            // Cargar la vista con el controlador ya configurado
            Utils.cargarVistaConControlador("vistas/FXMLMenuPrincipal.fxml", event, usuario,
                FXMLMenuPrincipalController.class);
        } else {
            Utils.mostrarAlerta("Inicio de sesión fallido", "Credenciales incorrectas. Intente nuevamente.", Alert.AlertType.ERROR);
        }
    }
}
