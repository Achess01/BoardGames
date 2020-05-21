package com.achess.casillas;

import java.io.Serializable;

public abstract class Casilla implements Serializable {
    private String nombre;
    private Casilla anterior;
    private Casilla siguiente;
    public Casilla(String nombre){
        this.nombre = nombre;
        this.anterior = null;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Casilla getAnterior() {
        return anterior;
    }

    public void setAnterior(Casilla anterior) {
        this.anterior = anterior;
    }

    public Casilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Casilla siguiente) {
        this.siguiente = siguiente;
    }
}
