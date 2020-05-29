package com.achess.casillas;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Carcel extends Casilla{
    public Carcel(String nombre) {
        super(nombre);
        setFondo(Casilla.COLORES_CASILLAS[4]);
    }

    @Override
    public void accion() {

    }

}
