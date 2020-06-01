package com.achess.casillas;

import com.achess.juego.Jugador;
import com.achess.juego.Tablero;

import javax.swing.*;
import java.awt.*;

public class Estacion extends Propiedad {

    public Estacion(String nombre, int precioCompra, int precioHipoteca, int costoServicio, Tablero campo) {
        super(nombre, precioCompra, precioHipoteca, costoServicio, campo);
        setFondo(Casilla.COLORES_CASILLAS[5]);
    }


}
