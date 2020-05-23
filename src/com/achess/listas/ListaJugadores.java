package com.achess.listas;

import com.achess.juego.Jugador;

public class ListaJugadores {

    private Jugador inicio;
    private int tamanio;

    public ListaJugadores() {
        this.inicio = null;
        this.tamanio = 0;
    }

    public Jugador getInicio() {
        return inicio;
    }

    public void setInicio(Jugador inicio) {
        this.inicio = inicio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void agregar(Jugador nueva) {
        if (tamanio == 0) {
            inicio = nueva;
            inicio.setAnterior(nueva);
            inicio.setSiguiente(nueva);
        } else {
            Jugador aux = inicio;
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

    public void eliminar(Jugador jugador){
        Jugador anterior = jugador.getAnterior();
        Jugador siguiente = jugador.getSiguiente();
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
    }
}
