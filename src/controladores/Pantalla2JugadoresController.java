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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Partida;

/**
 * FXML Controller class Es el controlador para la pantalla 2 jugadores
 *
 * @author luisf
 */
public class Pantalla2JugadoresController implements Initializable {

    @FXML
    private TextField txtJugador1;
    @FXML
    private TextField txtJugador2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Este metodo vuelve al menu principal
     *
     * @param event Es el evento del boton volver
     */
    @FXML
    private void volver(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stageAc = (Stage) source.getScene().getWindow();
        stageAc.close();
    }

    /**
     * Este metodo envia a la ventana de juego y asigna el nombre de los
     * jugadores
     *
     * @param event Es el evento del boton iniciar
     */
    @FXML
    private void iniciar(ActionEvent event) {
        if (txtJugador1.getText().isEmpty()) {
            return;
        }
        if (txtJugador2.getText().isEmpty()) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/PantallaJuego.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            PantallaJuegoController scenetwo = loader.getController();
            scenetwo.setPartida(new Partida(new Jugador(txtJugador1.getText()), new Jugador(txtJugador2.getText())));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("2 Jugadores");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
