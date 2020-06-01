package com.achess.casillas;

import com.achess.juego.Tablero;

import java.awt.*;

public class Servicio extends Propiedad {
    public Servicio(String nombre, int precioCompra, int precioHipoteca, int costoServicio, Tablero campo) {
        super(nombre, precioCompra, precioHipoteca, costoServicio, campo);
        setFondo(Casilla.COLORES_CASILLAS[3]);
    }

}
