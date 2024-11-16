package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jjraprendizajevirtual.modelo.dao.PreguntaDAO;
import jjraprendizajevirtual.modelo.pojo.Pregunta;
import jjraprendizajevirtual.modelo.pojo.Usuario;
import jjraprendizajevirtual.utilidades.SingletonUsuario;
import jjraprendizajevirtual.utilidades.Utils;

public class FXMLForoController implements Initializable {

    private Usuario usuarioActual = SingletonUsuario.getInstaniaUsuario().getUsuario();
    @FXML
    private VBox contenedorPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

                Label titulo = new Label(pregunta.getTitulo());
                titulo.setStyle("-fx-padding: 10; -fx-font-size: 24px; -fx-font-weight: bold;");
                Label contenido = new Label(pregunta.getContenido());
                contenido.setStyle("-fx-padding: 10; -fx-font-size: 18px; -fx-wrap-text: true");
                Button btnResponder = new Button("Responder");
                btnResponder.setOnAction(this::btnResponder);
                btnResponder.setStyle("-fx-padding: 10; -fx-font-size: 16px;");

                // Agregar componentes a la publicación
                publicacion.getChildren().addAll(titulo, contenido, btnResponder);

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
    
    @FXML
    private void btnResponder(ActionEvent event) {
        
    }
}
