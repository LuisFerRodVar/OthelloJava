/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import estructuras.Tablero;
import java.util.ArrayList;

/**
 * Esta clase contiene los datos de un jugador para una partida.
 *
 * @author luisf
 * @version 05/05/2022
 */
public class Jugador {

    private String nombre;
    private boolean blancas;
    private Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Esta clase hace que el jugador realice una jugada
     *
     * @param jugada Es la lista de jugadas posibles en la posicion
     * @return Retorna la jugada deseada por el jugador
     */
    public String realizarJugada(ArrayList<String[]> jugada) {
        return null;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public boolean isBlancas() {
        return blancas;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

}
