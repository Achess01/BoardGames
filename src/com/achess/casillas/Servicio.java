package com.achess.casillas;

import java.awt.*;

public class Servicio extends Propiedad {
    public Servicio(String nombre, int precioCompra, int precioHipoteca, int costoServicio) {
        super(nombre, precioCompra, precioHipoteca, costoServicio);
        setFondo(Casilla.COLORES_CASILLAS[3]);
    }


    @Override
    public void accion() {

    }
}
