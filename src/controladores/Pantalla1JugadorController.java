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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Dodo;
import modelo.Garza;
import modelo.Jugador;
import modelo.Loro;
import modelo.Partida;

/**
 * FXML Controller class Es el controlador de la ventana pantalla 1 jugador
 *
 * @author luisf
 */
public class Pantalla1JugadorController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox<String> comboBots;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBots.getItems().add("DODO");
        comboBots.getItems().add("GARZA");
        comboBots.getItems().add("LORO");

    }

    /**
     * Este metodo envia a la ventana de juego con un solo jugador y un bot,
     * requiere tener escrito el nombre del jugador y un bot seleccionado
     *
     * @param event Es el evento del boton iniciar
     */
    @FXML
    private void iniciar(ActionEvent event) {
        Jugador bot = new Jugador("toc");

        if(comboBots.getSelectionModel().getSelectedItem() == null){
            return;
        }
        if (comboBots.getSelectionModel().getSelectedItem().equals("DODO")) {
            bot = new Dodo();

        }
        if (comboBots.getSelectionModel().getSelectedItem().equals("GARZA")) {
            bot = new Garza();

        }
        if (comboBots.getSelectionModel().getSelectedItem().equals("LORO")) {
            bot = new Loro();

        }

        if (txtNombre.getText().isEmpty()) {
            return;
        }
        Jugador jugador = new Jugador(txtNombre.getText());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/PantallaJuego.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            PantallaJuegoController scenetwo = loader.getController();
            Partida partida = new Partida(jugador, bot);
            partida.setBot(true);
            scenetwo.setPartida(partida);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("1 Jugador");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo vuelve al menu principal
     *
     * @param event Es la accion del boton para volver
     */
    @FXML
    private void volver(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stageAc = (Stage) source.getScene().getWindow();
        stageAc.close();
    }

}
