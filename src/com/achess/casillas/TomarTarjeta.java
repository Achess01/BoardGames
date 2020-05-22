package com.achess.casillas;

import com.achess.listas.ListaTarjetas;

import java.awt.*;

public class TomarTarjeta extends Casilla {
    private ListaTarjetas lista;

    public TomarTarjeta(String nombre, Color fondo, ListaTarjetas lista) {
        super(nombre, fondo);
        this.lista = lista;
    }


    @Override
    public void accion() {

    }
}
