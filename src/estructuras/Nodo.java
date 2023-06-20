/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 * Esta clase sirve para crear nodos del tablero
 *
 * @author luisf
 * @version 19/05/2022
 */
public class Nodo {

    private String pos;
    private boolean esBlanca;
    private boolean vacia;
    //Nodos consecuentes
    private Nodo supIzq;
    private Nodo sup;
    private Nodo supDer;
    private Nodo izq;
    private Nodo der;
    private Nodo infIzq;
    private Nodo inf;
    private Nodo infDer;

    /**
     * Este metodo asigna un nodo a supIzq y a su vez asigna a este nodo como su
     * infDer
     *
     * @param nodo Nodo por asignar
     */
    public void asignarSupIzq(Nodo nodo) {
        supIzq = nodo;
        nodo.infDer = this;
    }

    /**
     * Este metodo asigna un nodo a supDer y a su vez asigna a este nodo como su
     * infIzq
     *
     * @param nodo Nodo por asignar
     */
    public void asignarSupDer(Nodo nodo) {
        supDer = nodo;
        nodo.infIzq = this;
    }

    /**
     * Este metodo asigna un nodo a sup y a su vez asigna a este nodo como su
     * inf
     *
     * @param nodo Nodo por asignar
     */
    public void asignarSup(Nodo nodo) {
        sup = nodo;
        nodo.inf = this;
    }

    /**
     * Este metodo asigna un nodo a der y a su vez asigna a este nodo como su
     * izq
     *
     * @param nodo Nodo por asignar
     */
    public void asignarDer(Nodo nodo) {
        der = nodo;
        nodo.izq = this;
    }

    /**
     * Este metodo asigna un nodo a izq y a su vez asigna a este nodo como su
     * der
     *
     * @param nodo Nodo por asignar
     */
    public void asignarIzq(Nodo nodo) {
        izq = nodo;
        nodo.der = this;
    }

    /**
     * Este metodo asigna un nodo a supIzq y a su vez asigna a este nodo como su
     * infDer
     *
     * @param nodo Nodo por asignar
     */
    public void asignarInfIzq(Nodo nodo) {
        infIzq = nodo;
        nodo.supDer = this;
    }

    /**
     * Este metodo asigna un nodo a infDer y a su vez asigna a este nodo como su
     * supIzq
     *
     * @param nodo Nodo por asignar
     */
    public void asignarInfDer(Nodo nodo) {
        infDer = nodo;
        nodo.supIzq = this;
    }

    /**
     * Este metodo asigna un nodo a inf y a su vez asigna a este nodo como su
     * sup
     *
     * @param nodo Nodo por asignar
     */
    public void asignarInf(Nodo nodo) {
        inf = nodo;
        nodo.sup = this;
    }

    public Nodo(String pos) {
        this.pos = pos;
        this.vacia = true;
        this.der = null;
        this.izq = null;
        this.sup = null;
        this.inf = null;
        this.supDer = null;
        this.supIzq = null;
        this.infDer = null;
        this.infIzq = null;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public boolean isEsBlanca() {
        return esBlanca;
    }

    public void setEsBlanca(boolean esBlanca) {
        this.vacia = false;
        this.esBlanca = esBlanca;
    }

    public boolean isVacia() {
        return vacia;
    }

    public void setVacia(boolean vacia) {
        this.vacia = vacia;
    }

    public Nodo getSupIzq() {
        return supIzq;
    }

    public void setSupIzq(Nodo supIzq) {
        this.supIzq = supIzq;
    }

    public Nodo getSup() {
        return sup;
    }

    public void setSup(Nodo sup) {
        this.sup = sup;
    }

    public Nodo getSupDer() {
        return supDer;
    }

    public void setSupDer(Nodo supDer) {
        this.supDer = supDer;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Nodo getInfIzq() {
        return infIzq;
    }

    public void setInfIzq(Nodo infIzq) {
        this.infIzq = infIzq;
    }

    public Nodo getInf() {
        return inf;
    }

    public void setInf(Nodo inf) {
        this.inf = inf;
    }

    public Nodo getInfDer() {
        return infDer;
    }

    public void setInfDer(Nodo infDer) {
        this.infDer = infDer;
    }

}
