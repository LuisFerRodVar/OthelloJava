/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tablero;
import java.util.ArrayList;

/**
 * Esta clase genera un bot Garza
 *
 * @author luisf
 */
public class Garza extends Bot {

    public Garza() {
        super("GARZA");
    }

    /**
     * Este metodo realiza las jugadas que una Garza puede pensar, basicamente
     * toma todas las jugadas posibles y elige una completamente al azar
     *
     * @param jugada Recibe una lista de jugadas posibles en la posicion
     * @return Retorna la jugada que realizo la Garza
     */
    @Override
    public String realizarJugada(ArrayList<String[]> jugada) { //1
        Tablero tablero1 = getTablero(); //2
        ArrayList<String[]> jugadas; //1
        if (jugada != null) { //1
            jugadas = jugada; //1
        } else { 
            jugadas = tablero1.jugadasPosibles(); //2
        }

        ArrayList<String> jugadasRealizables = new ArrayList(); //2
        if (jugadas.isEmpty()) { //1
            return "nada"; //1
        }

        for (int i = 0; i < jugadas.size(); i++) { //4n + 1

            jugadasRealizables.add(jugadas.get(i)[0]); //3

        }
        int rangoMayor = jugadasRealizables.size() - 1; //3
        int numero = (int) (Math.random() * (rangoMayor - 0 + 1)); //5
        tablero1.realizarJugada(jugadasRealizables.get(numero)); //2
        return jugadasRealizables.get(numero); //2
    }
}
