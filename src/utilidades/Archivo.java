/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Esta clase contiene las herramientas necesarias para trabajar archivos
 *
 * @author luisf
 */
public class Archivo {

    /**
     * Este metodo escribe un archivo con la informacion de una partida
     *
     * @param jugadas Es una lista de las jugadas que va a escribir
     * @param jugador1 Es el nombre del primer jugador de la partida
     * @param jugador2 Es el nombre del segundo jugador de la partida
     */
    public static void escribirPartida(ArrayList<String> jugadas, String jugador1, String jugador2) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("partidas.txt");
            pw = new PrintWriter(fichero);

            pw.print(jugador1 + ":");
            pw.print(jugador2 + ":");
            pw.print(jugadas.get(0));
            for (int i = 1; i < jugadas.size(); i++) {
                pw.print("," + jugadas.get(i));
            }
            pw.println();
            fichero.close(); //CERRAR EL ARCHIVO

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
