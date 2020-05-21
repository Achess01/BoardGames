package com.achess.listas;

import com.achess.tarjetas.Tarjeta;

import java.io.Serializable;

public class ListaTarjetas implements Serializable {
        private Tarjeta inicio;
        private int tamanio;

        public ListaTarjetas() {
            this.inicio = null;
            this.tamanio = 0;
        }

        public Tarjeta getInicio() {
            return inicio;
        }

        public void setInicio(Tarjeta inicio) {
            this.inicio = inicio;
        }

        public int getTamanio() {
            return tamanio;
        }

        public void setTamanio(int tamanio) {
            this.tamanio = tamanio;
        }

        public void agregar(Tarjeta nueva) {
            if (tamanio == 0) {
                inicio = nueva;
                inicio.setAnterior(nueva);
                inicio.setSiguiente(nueva);
            } else {
                Tarjeta aux = inicio;
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
