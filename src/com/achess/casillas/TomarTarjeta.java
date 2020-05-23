package com.achess.casillas;

import com.achess.listas.ListaTarjetas;

import java.awt.*;

public class TomarTarjeta extends Casilla {
    private ListaTarjetas lista;

    public TomarTarjeta(String nombre, ListaTarjetas lista) {
        super(nombre);
        this.lista = lista;
        setFondo(Casilla.COLORES_CASILLAS[1]);
    }


    @Override
    public void accion() {

    }
}
