package com.achess.casillas;

import javax.swing.*;
import java.awt.*;

public class Estacion extends Propiedad {

    public Estacion(String nombre, int precioCompra, int precioHipoteca, int costoUso) {
        super(nombre, precioCompra, precioHipoteca, costoUso);
        setFondo(Casilla.COLORES_CASILLAS[5]);
    }

    @Override
    public void accion() {

    }
}
