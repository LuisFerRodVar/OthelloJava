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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class Esta clase es el controlador del menu principal de la
 * aplicacion
 *
 * @author luisf
 */
public class MenuPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Este metodo envia a la ventana de 1 jugador
     *
     * @param event Es el evento del boton 1 jugador
     */
    @FXML
    private void iniciarJuego1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/Pantalla1Jugador.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            Pantalla1JugadorController scenetwo = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("1 Jugador");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Este metodo envia a la ventana de 2 jugadores
     *
     * @param event Es el evento del boton 2 jugadores
     */
    @FXML
    private void iniciarJuego2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/Pantalla2Jugadores.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            Pantalla2JugadoresController scenetwo = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("2 Jugadores");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo envia a la ventana de acerca de
     *
     * @param event Es el evento del boton 2 jugadores
     */
    @FXML
    private void desplegarAcercaDe(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/AcercaDe.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            AcercaDeController scenetwo = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tarjetas");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo sale del programa
     *
     * @param event Es el evento del boton salir
     */
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
