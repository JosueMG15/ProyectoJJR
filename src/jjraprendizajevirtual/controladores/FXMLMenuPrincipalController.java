package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jjraprendizajevirtual.modelo.dao.PreguntaDAO;
import jjraprendizajevirtual.modelo.pojo.Pregunta;
import jjraprendizajevirtual.modelo.pojo.Usuario;
import jjraprendizajevirtual.utilidades.SingletonUsuario;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;
    @FXML
    private Button btnSubirArchivo; // Ahora correctamente inicializado desde FXML
    private Usuario usuarioActual = SingletonUsuario.getInstaniaUsuario().getUsuario();
    @FXML
    private TextField tfTitulo;
    @FXML
    private TextArea tfPregunta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // No es necesario inicializar manualmente aquí.
    }

    public void inicializarMenu(Usuario usuario) {
        this.usuarioActual = usuario;

        lbMenuPrincipal.setText("Bienvenido, " + usuario.getNombre());

        if (usuarioActual.getAdministrador().equals("0")) {
            btnSubirArchivo.setDisable(true); // Desactiva el botón si no es administrador
        }
    }

    @FXML
    private void btnSubirArchivo(ActionEvent event) {
        try {
            Utils.cargarVistaConControlador("vistas/FXMLSubirArchivos.fxml", event, usuarioActual,
                    FXMLSubirArchivosController.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnConsultarArchivo(ActionEvent event) {
        try {
            Utils.cargarVistaConControlador("vistas/FXMLConsultarArchivo.fxml", event, usuarioActual,
                    FXMLConsultarArchivoController.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnForo(ActionEvent event) {
        System.out.println("Abriendo foro...");
        try {
            Utils.cargarVistaConControlador("vistas/FXMLForo.fxml", event, usuarioActual,
                    FXMLMenuPrincipalController.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnEnviarPregunta(ActionEvent event) {
        Pregunta pregunta = generarPregunta();
        if (pregunta != null) {
            boolean resultado = PreguntaDAO.subirPregunta(pregunta);
            if (resultado) {
                Utils.mostrarAlerta("Su pregunta ha sido publicada en el foro",
                        "Para poder visualizar su pregunta consulte el apartado de foro",
                        Alert.AlertType.INFORMATION);
                tfTitulo.clear();
                tfPregunta.clear();
            }
        }
    }

    private Pregunta generarPregunta() {
        Pregunta pregunta = new Pregunta();
        String titulo = tfTitulo.getText().trim();
        String contenido = tfPregunta.getText().trim();
        Date fechaCreacion = new Date();
        int idUsuario = usuarioActual.getIdUsuario();

        if (Utils.validarCampo(titulo) && Utils.validarCampo(contenido)) {
            pregunta.setTitulo(titulo);
            pregunta.setContenido(contenido);
            pregunta.setFechaCreacion(fechaCreacion);
            pregunta.setIdUsuario(idUsuario);
        } else {
            Utils.mostrarAlerta("Error en el registro de su pregunta", "Su pregunta tiene campos sin completar o incorrectos, "
                    + "por lo que no se ha podido enviar.", Alert.AlertType.WARNING);
        }

        return pregunta;
    }
}
