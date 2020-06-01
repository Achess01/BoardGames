package com.achess.casillas;

import com.achess.juego.Jugador;

import java.awt.*;

public class Neutro extends Casilla{
    public Neutro(String nombre) {
        super(nombre);
        setFondo(Casilla.COLORES_CASILLAS[2]);
    }

    @Override
    public void accion(Jugador jugador) {

    }
}
