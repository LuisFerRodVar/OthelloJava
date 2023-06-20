/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * Esta clase funciona de padre de los bots utilizados en el juego
 * @author luisf
 */
public class Bot extends Jugador{
    public Bot(String nombre){
        super(nombre);
        
    }
    @Override
    public String realizarJugada(ArrayList<String[]> jugada){
        return null;
    }
    
}
