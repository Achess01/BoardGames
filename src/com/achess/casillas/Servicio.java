package com.achess.casillas;

import com.achess.juego.Tablero;

import java.awt.*;

public class Servicio extends Propiedad {
    public static int cantidad = 0;
    public Servicio(String nombre, int precioCompra, int precioHipoteca, int costoServicio, Tablero campo) {
        super(nombre, precioCompra, precioHipoteca, costoServicio, campo);
        nombre = nombre+cantidad;
        cantidad++;
        setNombre(nombre);
        setFondo(Casilla.COLORES_CASILLAS[3]);
    }

}
