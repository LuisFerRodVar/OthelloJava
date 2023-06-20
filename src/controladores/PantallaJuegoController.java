/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import estructuras.Nodo;
import estructuras.Tablero;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.Dodo;
import modelo.Jugador;
import modelo.Partida;

/**
 * FXML Controller class Es el controlador para la ventana de juego, es la clase
 * mas importante del programa
 *
 * @author luisf
 */
public class PantallaJuegoController implements Initializable {

    private ArrayList<Button> botonesCasillas;
    private ArrayList<String> jugadasParaEscribir;
    private Partida partida;
    @FXML
    private Button btna1;
    @FXML
    private Button btnb1;
    @FXML
    private Button btnc1;
    @FXML
    private Button btnd1;
    @FXML
    private Button btne1;
    @FXML
    private Button btnf1;
    @FXML
    private Button btng1;
    @FXML
    private Button btnh1;
    @FXML
    private Button btna2;
    @FXML
    private Button btnb2;
    @FXML
    private Button btnc2;
    @FXML
    private Button btnd2;
    @FXML
    private Button btne2;
    @FXML
    private Button btnf2;
    @FXML
    private Button btng2;
    @FXML
    private Button btnh2;
    @FXML
    private Button btna3;
    @FXML
    private Button btnb3;
    @FXML
    private Button btnc3;
    @FXML
    private Button btnd3;
    @FXML
    private Button btne3;
    @FXML
    private Button btnf3;
    @FXML
    private Button btng3;
    @FXML
    private Button btnh3;
    @FXML
    private Button btna4;
    @FXML
    private Button btnb4;
    @FXML
    private Button btnc4;
    @FXML
    private Button btnd4;
    @FXML
    private Button btne4;
    @FXML
    private Button btnf4;
    @FXML
    private Button btng4;
    @FXML
    private Button btnh4;
    @FXML
    private Button btna5;
    @FXML
    private Button btnb5;
    @FXML
    private Button btnc5;
    @FXML
    private Button btnd5;
    @FXML
    private Button btne5;
    @FXML
    private Button btnf5;
    @FXML
    private Button btng5;
    @FXML
    private Button btnh5;
    @FXML
    private Button btna6;
    @FXML
    private Button btnb6;
    @FXML
    private Button btnc6;
    @FXML
    private Button btnd6;
    @FXML
    private Button btne6;
    @FXML
    private Button btnf6;
    @FXML
    private Button btng6;
    @FXML
    private Button btnh6;
    @FXML
    private Button btna7;
    @FXML
    private Button btnb7;
    @FXML
    private Button btnc7;
    @FXML
    private Button btnd7;
    @FXML
    private Button btne7;
    @FXML
    private Button btnf7;
    @FXML
    private Button btng7;
    @FXML
    private Button btnh7;
    @FXML
    private Button btna8;
    @FXML
    private Button btnb8;
    @FXML
    private Button btnc8;
    @FXML
    private Button btnd8;
    @FXML
    private Button btne8;
    @FXML
    private Button btnf8;
    @FXML
    private Button btng8;
    @FXML
    private Button btnh8;
    @FXML
    private ListView<String> listaJugadas;
    @FXML
    private Label labelJugadorNegras;
    @FXML
    private Label labelJugadorBlancas;
    @FXML
    private Label labelContadorNegras;
    @FXML
    private Label labelContadorBlancas;
    @FXML
    private Label labelTurno;
    private int contadorJugadas;
    @FXML
    private Button btnReinicio;

    /**
     * Este metodo refresca la pantalla y verifica las jugadas posibles del
     * jugador
     */
    public void refrescarTablero() {
        String[] COLUMNA = {"a", "b", "c", "d", "e", "f", "g", "h"};
        Nodo actual;
        //Asigna todos los botones del color indicado
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {

                actual = partida.getTablero().obtenerPosicion(COLUMNA[i] + j);
                if (!actual.isVacia()) {
                    for (int cont = 0; cont < botonesCasillas.size(); cont++) {

                        if (actual.getPos().equals(botonesCasillas.get(cont).getId())) {
                            botonesCasillas.get(cont).setVisible(true);

                            if (actual.isEsBlanca()) {

                                botonesCasillas.get(cont).setStyle("-fx-background-color: white;");
                            } else {
                                botonesCasillas.get(cont).setStyle("-fx-background-color: black;");
                            }
                        }
                    }
                } else {
                    for (int cont = 0; cont < botonesCasillas.size(); cont++) {

                        if (actual.getPos().equals(botonesCasillas.get(cont).getId())) {
                            botonesCasillas.get(cont).setVisible(false);

                        }
                    }
                }

            }
        }
        //Obtiene las jugadas posibles y marca los botones donde se puede realizar la posible jugada
        ArrayList<String[]> jugadasPosibles = partida.getTablero().jugadasPosibles();
        for (int i = 0; i < jugadasPosibles.size(); i++) {
            for (int j = 0; j < botonesCasillas.size(); j++) {
                if (botonesCasillas.get(j).getId().equals(jugadasPosibles.get(i)[0])) {
                    botonesCasillas.get(j).setVisible(true);
                }
            }
        }
        //Actualiza los labels del turno
        if (partida.getTablero().isTurnoBlancas()) {
            labelTurno.setTextFill(Color.color(1, 1, 1));
            labelTurno.setText("Juegan las blancas");
            if (partida.isBot()) {
                String jugadaBot = partida.getBlancas().realizarJugada(jugadasPosibles);
                if (jugadaBot.equals("nada")) {
                    btnReinicio.setVisible(true);
                    if (partida.getTablero().getContadorBlancas() > partida.getTablero().getContadorNegras()) {
                        labelTurno.setTextFill(Color.color(1, 1, 1));
                        labelTurno.setText("Ganan las blancas");
                    }
                    if (partida.getTablero().getContadorBlancas() < partida.getTablero().getContadorNegras()) {
                        labelTurno.setTextFill(Color.color(0, 0, 0));
                        labelTurno.setText("Ganan las negras");
                    }
                    if (partida.getTablero().getContadorBlancas() == partida.getTablero().getContadorNegras()) {
                        labelTurno.setTextFill(Color.color(192, 192, 192));
                        labelTurno.setText("Empate");
                    }
                    partida.guardarPartida(jugadasParaEscribir);
                    return;
                }
                jugadasParaEscribir.add(jugadaBot);
                listaJugadas.getItems().add(contadorJugadas + " " + jugadaBot);
                contadorJugadas++;
                refrescarTablero();
                return;
            }
        } else {
            labelTurno.setTextFill(Color.color(0, 0, 0));
            labelTurno.setText("Juegan las negras");
        }
        //Verifica si hay un ganador
        if (partida.getTablero().isGanador()) {
            btnReinicio.setVisible(true);
            if (partida.getTablero().getContadorBlancas() > partida.getTablero().getContadorNegras()) {
                labelTurno.setTextFill(Color.color(1, 1, 1));
                labelTurno.setText("Ganan las blancas");
            }
            if (partida.getTablero().getContadorBlancas() < partida.getTablero().getContadorNegras()) {
                labelTurno.setTextFill(Color.color(0, 0, 0));
                labelTurno.setText("Ganan las negras");
            }
            if (partida.getTablero().getContadorBlancas() == partida.getTablero().getContadorNegras()) {
                labelTurno.setTextFill(Color.color(0, 0, 0));
                labelTurno.setText("Empate");
            }
            partida.guardarPartida(jugadasParaEscribir);
        }
        //Actualiza los contadores de fichas
        labelContadorNegras.setText(String.valueOf(partida.getTablero().getContadorNegras()));
        labelContadorBlancas.setText(String.valueOf(partida.getTablero().getContadorBlancas()));

    }

    /**
     * Initializes the controller class. Coloca todos los botones y demas
     * apartados para el juego
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugadasParaEscribir = new ArrayList();

        btnReinicio.setVisible(false);
        contadorJugadas = 1;
        botonesCasillas = new ArrayList();
        botonesCasillas.add(btna1);
        botonesCasillas.add(btna2);
        botonesCasillas.add(btna3);
        botonesCasillas.add(btna4);
        botonesCasillas.add(btna5);
        botonesCasillas.add(btna6);
        botonesCasillas.add(btna7);
        botonesCasillas.add(btna8);
        botonesCasillas.add(btnb1);
        botonesCasillas.add(btnb2);
        botonesCasillas.add(btnb3);
        botonesCasillas.add(btnb4);
        botonesCasillas.add(btnb5);
        botonesCasillas.add(btnb6);
        botonesCasillas.add(btnb7);
        botonesCasillas.add(btnb8);
        botonesCasillas.add(btnc1);
        botonesCasillas.add(btnc2);
        botonesCasillas.add(btnc3);
        botonesCasillas.add(btnc4);
        botonesCasillas.add(btnc5);
        botonesCasillas.add(btnc6);
        botonesCasillas.add(btnc7);
        botonesCasillas.add(btnc8);
        botonesCasillas.add(btnd1);
        botonesCasillas.add(btnd2);
        botonesCasillas.add(btnd3);
        botonesCasillas.add(btnd4);
        botonesCasillas.add(btnd5);
        botonesCasillas.add(btnd6);
        botonesCasillas.add(btnd7);
        botonesCasillas.add(btnd8);
        botonesCasillas.add(btne1);
        botonesCasillas.add(btne2);
        botonesCasillas.add(btne3);
        botonesCasillas.add(btne4);
        botonesCasillas.add(btne5);
        botonesCasillas.add(btne6);
        botonesCasillas.add(btne7);
        botonesCasillas.add(btne8);
        botonesCasillas.add(btnf1);
        botonesCasillas.add(btnf2);
        botonesCasillas.add(btnf3);
        botonesCasillas.add(btnf4);
        botonesCasillas.add(btnf5);
        botonesCasillas.add(btnf6);
        botonesCasillas.add(btnf7);
        botonesCasillas.add(btnf8);
        botonesCasillas.add(btng1);
        botonesCasillas.add(btng2);
        botonesCasillas.add(btng3);
        botonesCasillas.add(btng4);
        botonesCasillas.add(btng5);
        botonesCasillas.add(btng6);
        botonesCasillas.add(btng7);
        botonesCasillas.add(btng8);
        botonesCasillas.add(btnh1);
        botonesCasillas.add(btnh2);
        botonesCasillas.add(btnh3);
        botonesCasillas.add(btnh4);
        botonesCasillas.add(btnh5);
        botonesCasillas.add(btnh6);
        botonesCasillas.add(btnh7);
        botonesCasillas.add(btnh8);
        for (int i = 0; i < botonesCasillas.size(); i++) {
            botonesCasillas.get(i).setShape(new Circle(18));
            botonesCasillas.get(i).setVisible(false);
        }

    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        labelJugadorNegras.setText(partida.getNegras().getNombre());
        labelJugadorNegras.setTextFill(Color.color(0, 0, 0));
        labelJugadorBlancas.setText(partida.getBlancas().getNombre());
        labelJugadorBlancas.setTextFill(Color.color(1, 1, 1));
        labelContadorBlancas.setTextFill(Color.color(1, 1, 1));
        labelContadorNegras.setTextFill(Color.color(0, 0, 0));
        this.partida = partida;
        refrescarTablero();

    }

    /**
     * Permite realizar jugadas a los jugadores ya sea en modo 1 jugador o en
     * modo 2 jugadores
     *
     * @param event Es el evento del boton
     */
    @FXML
    private void jugar(ActionEvent event) {

        Tablero tablero = partida.getTablero();
        Button boton = (Button) (event.getSource());
        for (int i = 0; i < jugadasParaEscribir.size(); i++) {
            if (boton.getId().equals(jugadasParaEscribir.get(i))) {
                return;
            }
        }
        listaJugadas.getItems().add(contadorJugadas + " " + boton.getId());
        contadorJugadas++;
        tablero.realizarJugada(boton.getId());
        jugadasParaEscribir.add(boton.getId());
        if (!partida.isBot()) {
            refrescarTablero();
        }

        if (partida.isBot()) {
            String jugadaBot = partida.getBlancas().realizarJugada(null);
            if (jugadaBot.equals("nada")) {
                refrescarTablero();
                return;
            }
            jugadasParaEscribir.add(jugadaBot);
            listaJugadas.getItems().add(contadorJugadas + " " + jugadaBot);
            contadorJugadas++;
            refrescarTablero();
        }

    }

    /**
     * Este metodo reinicia el tablero para realizar otra partida
     *
     * @param event Es el evento del boton que permite el reinicio
     */
    @FXML
    private void reiniciar(ActionEvent event) {
        jugadasParaEscribir = new ArrayList();
        jugadasParaEscribir.add("d4");
        jugadasParaEscribir.add("d5");
        jugadasParaEscribir.add("e4");
        jugadasParaEscribir.add("e5");

        btnReinicio.setVisible(false);

        partida.setTablero(new Tablero());
        partida.getBlancas().setTablero(partida.getTablero());
        String css = "-fx-background-color: #188137;";
        css += "\n-fx-border-color: black;";
        for (int i = 0; i < botonesCasillas.size(); i++) {

            botonesCasillas.get(i).setStyle(css);
        }
        refrescarTablero();
        listaJugadas.getItems().removeAll(listaJugadas.getItems());
        contadorJugadas = 1;

    }

}
