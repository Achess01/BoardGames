package com.achess.listas;

import com.achess.casillas.Casilla;

import java.io.Serializable;

public class ListaCasillas implements Serializable {
    private Casilla inicio;
    private int tamanio;

    public ListaCasillas() {
        this.inicio = null;
        this.tamanio = 0;
    }

    public Casilla getInicio() {
        return inicio;
    }

    public void setInicio(Casilla inicio) {
        this.inicio = inicio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void agregar(Casilla nueva) {
        if (tamanio == 0) {
            inicio = nueva;
            inicio.setAnterior(nueva);
            inicio.setSiguiente(nueva);
        } else {
            Casilla aux = inicio;
            while (aux.getSiguiente() != inicio) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nueva);
            nueva.setAnterior(aux);
            nueva.setSiguiente(inicio);
            inicio.setAnterior(nueva);
        }
        tamanio++;
    }
    
    public void correrLugares(){
        inicio = inicio.getSiguiente();
    }
}
