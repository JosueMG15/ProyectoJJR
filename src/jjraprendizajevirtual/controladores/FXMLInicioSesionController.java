/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package jjraprendizajevirtual.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author sosue
 */
public class FXMLInicioSesionController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField tfContraseña;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIniciarSesionClic(ActionEvent event) {
        
    }
    
}
