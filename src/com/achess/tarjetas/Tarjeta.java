package com.achess.tarjetas;

import java.io.Serializable;

public class Tarjeta implements Serializable {
    public static int Cantidad = 0;
    private int id;
    private Tarjeta anterior;
    private Tarjeta siguiente;


    public Tarjeta() {
        id = Cantidad;
        Cantidad++;
        this.anterior = null;
        this.siguiente = null;
    }

    public Tarjeta getAnterior() {
        return anterior;
    }

    public void setAnterior(Tarjeta anterior) {
        this.anterior = anterior;
    }

    public Tarjeta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Tarjeta siguiente) {
        this.siguiente = siguiente;
    }
}
