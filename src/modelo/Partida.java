/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tablero;
import java.util.ArrayList;
import utilidades.Archivo;

/**
 * Esta clase genera partidas
 *
 * @version 29/05/2022
 * @author luisf
 */
public class Partida {

    private Jugador negras;
    private Jugador blancas;
    private Tablero tablero;
    private boolean bot;

    /**
     * Este metodo guarda la partida en un archivo
     *
     * @param jugadas Son las jugadas de la partida
     */
    public void guardarPartida(ArrayList<String> jugadas) {
        Archivo.escribirPartida(jugadas, negras.getNombre(), blancas.getNombre());

    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    /**
     * Este metodo crea partidas
     *
     * @param negras Es el jugador de piezas negras
     * @param blancas Es el jugador de piezas blancas
     */
    public Partida(Jugador negras, Jugador blancas) {
        bot = false;
        this.negras = negras;
        negras.setBlancas(false);
        this.blancas = blancas;
        blancas.setBlancas(true);
        this.tablero = new Tablero();
        negras.setTablero(tablero);
        blancas.setTablero(tablero);
    }

    public Jugador getNegras() {
        return negras;
    }

    public void setNegras(Jugador negras) {
        this.negras = negras;
    }

    public Jugador getBlancas() {
        return blancas;
    }

    public void setBlancas(Jugador blancas) {
        this.blancas = blancas;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

}
