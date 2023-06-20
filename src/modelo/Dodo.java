/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tablero;
import java.util.ArrayList;

/**
 * Esta clase genera un bot Dodo
 *
 * @author luisf
 */
public class Dodo extends Bot {

    public Dodo() {
        super("DODO");
    }

    /**
     * Este metodo realiza las jugadas que un Dodo puede pensar, basicamente
     * toma todas las jugadas posibles las evalua y elige una al azar entre las
     * jugadas que menos material otorgan en la posicion
     *
     * @param jugada Recibe una lista de jugadas posibles en la posicion
     * @return Retorna la jugada que realizo el Dodo
     */
    @Override
    public String realizarJugada(ArrayList<String[]> jugada) {//1
        Tablero tablero1 = getTablero();//2
        ArrayList<String[]> jugadas;//1
        if (jugada != null) {//1
            jugadas = jugada;//1
        } else {
            jugadas = tablero1.jugadasPosibles();//3
        }

        ArrayList<String> jugadasRealizables = new ArrayList();//1
        if (jugadas.isEmpty()) {//1
            return "nada";//1
        }
        int menor = Integer.valueOf(jugadas.get(0)[1]);//4
        for (int i = 0; i < jugadas.size(); i++) {//1 + 4n
            if (Integer.valueOf(jugadas.get(i)[1]) < menor) {//4n
                menor = Integer.valueOf(jugadas.get(0)[1]); //4
            }
        }
        for (int i = 0; i < jugadas.size(); i++) {//1 + 4n
            if (Integer.valueOf(jugadas.get(i)[1]) == menor) {//4n
                jugadasRealizables.add(jugadas.get(i)[0]); //3 
            }
        }
        int rangoMayor = jugadasRealizables.size() - 1; //3
        int numero = (int) (Math.random() * (rangoMayor - 0 + 1)); //5
        tablero1.realizarJugada(jugadasRealizables.get(numero)); //2 
        return jugadasRealizables.get(numero); //2
    }

}
