/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.util.ArrayList;

/**
 * Esta clase genera tableros utilizando nodos de la clase Nodo
 *
 * @author luisf
 * @version 05/05/2022
 */
public class Tablero {

    private Nodo a1;
    private Nodo a8;
    private Nodo h1;
    private Nodo h8;
    private int contadorBlancas;
    private int contadorNegras;
    private boolean turnoBlancas;
    private boolean ganador;
    private boolean pasoTurno;
    

    //Constante donde se guardan las columnas
    private final char[] COLUMNA = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public boolean isGanador() {
        return ganador;
    }

    /**
     * Este metodo crea el tablero, asigna todos sus nodos y coloca las
     * posiciones iniciales del juego
     */
    public Tablero() {
        iniciarTablero();
        Nodo actual = obtenerPosicion("d4");
        actual.setEsBlanca(true);
        actual = obtenerPosicion("d5");
        actual.setEsBlanca(false);
        actual = obtenerPosicion("e4");
        actual.setEsBlanca(false);
        actual = obtenerPosicion("e5");
        actual.setEsBlanca(true);
        turnoBlancas = false;
        contadorBlancas = 2;
        contadorNegras = 2;
        pasoTurno = false;
        ganador = false;

    }

    /**
     * Este metodo obtiene el nodo en una posicion especifica en notacion
     * algebraica
     *
     * @param posicion Es la posicion en notacion algebraica
     * @return El nodo en la posicion ingresada
     */
    public Nodo obtenerPosicion(String posicion) {
        int columna = 0;
        int fila = Character.getNumericValue(posicion.charAt(1));
        for (int i = 0; i < 8; i++) {
            if (posicion.charAt(0) == COLUMNA[i]) {
                columna = i;
                break;
            }
        }

        Nodo actual = a1;
        for (int i = 0; i < columna; i++) {
            actual = actual.getDer();
        }
        for (int i = 1; i < fila; i++) {
            actual = actual.getInf();
        }
        return actual;

    }

    public void realizarJugada(String jugada) {

        Nodo nodoJugado = obtenerPosicion(jugada);

        Nodo actual = nodoJugado;
        //Coloca el nodo actual del color del jugador actual
        nodoJugado.setEsBlanca(turnoBlancas);
        if (turnoBlancas) {
            contadorBlancas++;
        } else {
            contadorNegras++;
        }
        //Verifica y modifica hacia el lado izquierdo del nodo
        boolean banderaJugadaPosible = false;
        int potenciaPosible = 0;
        if (actual.getIzq() != null) {
            while (actual.getIzq() != null) {
                if (actual.getIzq().isVacia()) {
                    break;
                }
                if ((actual.getIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getDer();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getIzq();
            }
        }
        //Verifica y modifica hacia el lado derecho del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getDer() != null) {
            while (actual.getDer() != null) {
                if (actual.getDer().isVacia()) {
                    break;
                }
                if ((actual.getDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getIzq();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getDer();
            }
        }//Verifica y modifica hacia el lado inferior del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getInf() != null) {
            while (actual.getInf() != null) {
                if (actual.getInf().isVacia()) {
                    break;
                }
                if ((actual.getInf().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getSup();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getInf();
            }
        }
        //Verifica y modifica hacia el lado superior del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getSup() != null) {
            while (actual.getSup() != null) {
                if (actual.getSup().isVacia()) {
                    break;
                }
                if ((actual.getSup().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getInf();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getSup();
            }
        }
        //Verifica y modifica hacia el lado superior derecho del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getSupDer() != null) {
            while (actual.getSupDer() != null) {
                if (actual.getSupDer().isVacia()) {
                    break;
                }
                if ((actual.getSupDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getInfIzq();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getSupDer();
            }
        }
        //Verifica y modifica hacia el lado superior izquierdo del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getSupIzq() != null) {
            while (actual.getSupIzq() != null) {
                if (actual.getSupIzq().isVacia()) {
                    break;
                }
                if ((actual.getSupIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getInfDer();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getSupIzq();
            }
        }
        //Verifica y modifica hacia el lado inferior derecho del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getInfDer() != null) {
            while (actual.getInfDer() != null) {
                if (actual.getInfDer().isVacia()) {
                    break;
                }
                if ((actual.getInfDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getSupIzq();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getInfDer();
            }
        }
        //Verifica y modifica hacia el lado inferior izquierdo del nodo
        banderaJugadaPosible = false;
        actual = nodoJugado;
        potenciaPosible = 0;
        if (actual.getInfIzq() != null) {
            while (actual.getInfIzq() != null) {
                if (actual.getInfIzq().isVacia()) {
                    break;
                }
                if ((actual.getInfIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        while (potenciaPosible != 0) {
                            actual.setEsBlanca(turnoBlancas);
                            actual = actual.getSupDer();
                            potenciaPosible--;
                            if (turnoBlancas) {
                                contadorBlancas++;
                                contadorNegras--;
                            } else {
                                contadorNegras++;
                                contadorBlancas--;
                            }
                        }

                    }
                    break;
                }
                actual = actual.getInfIzq();
            }
        }
        //Pasa el turno al siguiente jugador
        turnoBlancas = !turnoBlancas;
    }

    /**
     * Este metodo retorna las jugadas posibles en la posicion actual del
     * tablero, tambien si un jugador no tiene jugadas posibles pasa su turno y
     * calcula las de su adversario. Si su adversario tampoco tiene jugadas
     * posibles cambia la bandera que avisa si hay un ganador a true
     *
     * @return Retorna las jugadas posibles en un ArrayList que contiene un
     * Array donde el primer valor del Array es la jugada y el segundo es el
     * material ganado con esa jugada
     *
     */
    public ArrayList<String[]> jugadasPosibles() {
        ArrayList<String[]> resultado = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                String[] jugada;
                jugada = evaluarJugada(String.valueOf(COLUMNA[i]) + j);
                if (!jugada[1].equals("0")) {
                    resultado.add(jugada);
                }
            }
        }
        if (pasoTurno && resultado.isEmpty()) {
            ganador = true;
            return resultado;
        }
        if (pasoTurno && !resultado.isEmpty()) {
            pasoTurno = false;
        }
        if (resultado.isEmpty()) {
            turnoBlancas = !turnoBlancas;
            pasoTurno = true;
            return jugadasPosibles();

        }
        return resultado;
    }

    /**
     * Este metodo evalua una jugada y determina que tanto material se gana
     * haciendo esa jugada con la posicion del tablero actual
     *
     * @param jugada Jugada por evaluar, se escribe utilizando un formato
     * algebraico Ej: e5
     * @return Retorna un Array donde la primera posicion es la jugada en
     * formato algebraico y la segunda posicion es la cantidad de material
     * ganado
     */
    public String[] evaluarJugada(String jugada) {
        Nodo nodoEvaluado = obtenerPosicion(jugada);
        if (!nodoEvaluado.isVacia()) {
            String[] resultado = {jugada, "0"};
            return resultado;
        }
        Nodo actual = nodoEvaluado;
        int potenciaJugada = 0;
        boolean banderaJugadaPosible = false;
        int potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia la izquierda
        if (actual.getIzq() != null) {
            while (actual.getIzq() != null) {
                if (actual.getIzq().isVacia()) {
                    break;
                }
                if ((actual.getIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getIzq();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia la derecha
        if (actual.getDer() != null) {
            while (actual.getDer() != null) {
                if (actual.getDer().isVacia()) {
                    break;
                }
                if ((actual.getDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getDer();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia abajo
        if (actual.getInf() != null) {
            while (actual.getInf() != null) {
                if (actual.getInf().isVacia()) {
                    break;
                }
                if ((actual.getInf().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getInf();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia arriba
        if (actual.getSup() != null) {
            while (actual.getSup() != null) {
                if (actual.getSup().isVacia()) {
                    break;
                }
                if ((actual.getSup().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getSup();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia el lado superior derecho
        if (actual.getSupDer() != null) {
            while (actual.getSupDer() != null) {
                if (actual.getSupDer().isVacia()) {
                    break;
                }
                if ((actual.getSupDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getSupDer();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia el lado superior izquierdo
        if (actual.getSupIzq() != null) {
            while (actual.getSupIzq() != null) {
                if (actual.getSupIzq().isVacia()) {
                    break;
                }
                if ((actual.getSupIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getSupIzq();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia el lado inferior derecho
        if (actual.getInfDer() != null) {
            while (actual.getInfDer() != null) {
                if (actual.getInfDer().isVacia()) {
                    break;
                }
                if ((actual.getInfDer().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getInfDer();
            }
        }
        actual = nodoEvaluado;
        banderaJugadaPosible = false;
        potenciaPosible = 0;
        //Comprueba si hay jugadas posibles hacia el lado inferior izquierdo
        if (actual.getInfIzq() != null) {
            while (actual.getInfIzq() != null) {
                if (actual.getInfIzq().isVacia()) {
                    break;
                }
                if ((actual.getInfIzq().isEsBlanca()) != turnoBlancas) {
                    banderaJugadaPosible = true;
                    potenciaPosible++;
                } else {
                    if (banderaJugadaPosible) {
                        potenciaJugada += potenciaPosible;

                    }
                    break;
                }
                actual = actual.getInfIzq();
            }
        }
        String[] resultado = {jugada, String.valueOf(potenciaJugada)};
        return resultado;
    }

    /**
     * Este metodo inicia el tablero de othello
     */
    public void iniciarTablero() {
        //Asigna el nodo a1
        a1 = new Nodo("a1");
        //Asigna punteros del nodo a1
        Nodo actual = a1;
        //Asigna del nodo a1 hasta el g1 incluyendo punteros
        for (int i = 1; i < 8; i++) {
            actual.asignarDer(new Nodo(COLUMNA[i] + "1"));
            actual = actual.getDer();
        }
        //Asigna punteros del nodo h1
        h1 = actual;
        Nodo encima = a1;
        for (int i = 2; i < 9; i++) {
            //Asigna la columna A
            encima.asignarInf(new Nodo("a" + i));
            actual = encima.getInf();
            if (i == 8) {
                a8 = actual;
            }
            actual.asignarSupDer(encima.getDer());
            encima = actual;
            actual.asignarDer(new Nodo("b" + i));
            actual = actual.getDer();
            //Asigna desde la columna B hasta la columna G
            for (int j = 2; j < 8; j++) {
                actual.asignarSupIzq(actual.getIzq().getSup());
                actual.asignarSup(actual.getIzq().getSupDer());
                actual.asignarSupDer(actual.getSup().getDer());
                actual.asignarDer(new Nodo("" + COLUMNA[j] + i));
                actual = actual.getDer();

            }
            //Asigna la columna H
            actual.asignarSupIzq(actual.getIzq().getSup());
            actual.asignarSup(actual.getSupIzq().getDer());
            if (i == 8) {
                h8 = actual;
            }
        }

    }

    public int getContadorBlancas() {
        return contadorBlancas;
    }

    public int getContadorNegras() {
        return contadorNegras;
    }

    public boolean isTurnoBlancas() {
        return turnoBlancas;
    }

    public Nodo getA1() {
        return a1;
    }

    public Nodo getA8() {
        return a8;
    }

    public Nodo getH1() {
        return h1;
    }

    public Nodo getH8() {
        return h8;
    }

}
