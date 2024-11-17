package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jjraprendizajevirtual.modelo.dao.PreguntaDAO;
import jjraprendizajevirtual.modelo.pojo.Pregunta;
import jjraprendizajevirtual.modelo.pojo.Respuesta;
import jjraprendizajevirtual.modelo.pojo.Usuario;
import jjraprendizajevirtual.utilidades.SingletonUsuario;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLForoController implements Initializable {

    private Usuario usuarioActual = SingletonUsuario.getInstaniaUsuario().getUsuario();
    @FXML
    private VBox contenedorPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contenedorPrincipal.getChildren().clear(); // Limpia el contenido previo del contenedor principal
        VBox contenedorForo = new VBox(10);
        contenedorForo.setStyle("-fx-padding: 30;");

        Label encabezado = new Label("Preguntas del foro");
        encabezado.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

        Button btnRegresar = new Button("Regresar");
        btnRegresar.setOnAction(this::btnRegresar);

        AnchorPane contenedorEncabezado = new AnchorPane();
        contenedorEncabezado.setStyle("-fx-padding: 10;");
        contenedorEncabezado.getChildren().add(encabezado);

        AnchorPane.setTopAnchor(btnRegresar, 20.0);
        AnchorPane.setRightAnchor(btnRegresar, 20.0);
        contenedorEncabezado.getChildren().add(btnRegresar);

        contenedorForo.getChildren().add(contenedorEncabezado);

        List<Pregunta> preguntas = PreguntaDAO.obtenerPreguntas();

        if (preguntas != null && !preguntas.isEmpty()) {
            for (Pregunta pregunta : preguntas) {
                VBox publicacion = new VBox();
                publicacion.setStyle("-fx-padding: 20; -fx-border-color: gray; -fx-border-radius: 5; -fx-margin: 10;");

                Label nombreUsuario = new Label("Autor: " + PreguntaDAO.obtenerNombreUsuario(pregunta.getIdUsuario()));
                nombreUsuario.setStyle("-fx-padding: 5; -fx-font-size: 14px; -fx-font-style: italic;");

                Label titulo = new Label(pregunta.getTitulo());
                titulo.setStyle("-fx-padding: 10; -fx-font-size: 24px; -fx-font-weight: bold;");
                Label contenido = new Label(pregunta.getContenido());
                contenido.setStyle("-fx-padding: 10; -fx-font-size: 18px; -fx-wrap-text: true");

                VBox contenedorRespuestas = new VBox(10);
                contenedorRespuestas.setStyle("-fx-padding: 10; -fx-background-color: #f4f4f4; -fx-border-radius: 5;");

                // Mostrar respuestas asociadas
                // Mostrar respuestas asociadas
                List<Respuesta> respuestas = PreguntaDAO.obtenerRespuestasPorPregunta(pregunta.getIdPregunta());
                for (Respuesta respuesta : respuestas) {
                    Label lblRespuesta = new Label(respuesta.getContenido() + " - " + respuesta.getNombreUsuario());
                    lblRespuesta.setStyle("-fx-padding: 5; -fx-font-size: 14px;");
                    contenedorRespuestas.getChildren().add(lblRespuesta);
                }

                // Caja de texto para responder
                TextField txtResponder = new TextField();
                txtResponder.setPromptText("Escribe tu respuesta...");
                txtResponder.setStyle("-fx-padding: 5; -fx-font-size: 14px;");

                Button btnResponder = new Button("Enviar respuesta");
                btnResponder.setOnAction(event -> {
                    String contenidoRespuesta = txtResponder.getText().trim();
                    if (!contenidoRespuesta.isEmpty()) {
                        boolean resultado = PreguntaDAO.agregarRespuesta(pregunta.getIdPregunta(), contenidoRespuesta, usuarioActual.getIdUsuario());
                        if (resultado) {
                            Utils.mostrarAlerta("Respuesta agregada", "Tu respuesta se publicó correctamente.", Alert.AlertType.INFORMATION);
                            initialize(null, null); // Recarga la interfaz
                        } else {
                            Utils.mostrarAlerta("Error", "No se pudo publicar la respuesta. Intenta de nuevo.", Alert.AlertType.ERROR);
                        }
                    } else {
                        Utils.mostrarAlerta("Error", "La respuesta no puede estar vacía.", Alert.AlertType.WARNING);
                    }
                });

                VBox contenedorResponder = new VBox(5);
                contenedorResponder.getChildren().addAll(txtResponder, btnResponder);

                // Agregar componentes a la publicación
                publicacion.getChildren().addAll(nombreUsuario, titulo, contenido, contenedorRespuestas, contenedorResponder);

                // Agregar publicación al contenedor del foro
                contenedorForo.getChildren().add(publicacion);
            }
        } else {
            // Mostrar mensaje si no hay preguntas
            Label lbMensaje = new Label("No hay preguntas en el foro");
            lbMensaje.setStyle("-fx-padding: 20; -fx-font-size: 32px; -fx-font-weight: bold;");
            contenedorForo.getChildren().add(lbMensaje);
        }

        ScrollPane scrollPane = new ScrollPane(contenedorForo);
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);

        contenedorPrincipal.getChildren().add(scrollPane);
    }

    @FXML
    private void btnRegresar(ActionEvent event) {
        try {
            Utils.cargarVistaConControlador("vistas/FXMLMenuPrincipal.fxml", event, usuarioActual,
                    FXMLMenuPrincipalController.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
