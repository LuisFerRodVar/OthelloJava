/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Esta clase es el controlador de la ventana del acerca de
 *
 * @author luisf
 */
public class AcercaDeController implements Initializable {

    @FXML
    private Button btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Este metodo regresa al menu principal
     *
     * @param event Es el evento conseguido luego de presionar el boton volver
     */
    @FXML
    private void regresar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stageAc = (Stage) source.getScene().getWindow();
        stageAc.close();

    }

}
