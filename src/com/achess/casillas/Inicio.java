package com.achess.casillas;

import com.achess.juego.Jugador;

import java.awt.*;
import java.io.Serializable;

public class Inicio extends Casilla{

    public Inicio(String nombre) {
        super(nombre);
        setFondo(Casilla.COLORES_CASILLAS[0]);
    }

    @Override
    public void accion(Jugador jugador) {

    }
}
