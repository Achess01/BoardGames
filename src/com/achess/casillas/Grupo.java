package com.achess.casillas;

import java.io.Serializable;

public class Grupo implements Serializable {
    private int cantidad[] = {0, 0, 0, 0, 0};

    public int getCantidad(int index) {
        return cantidad[index];
    }

    public void setCantidad(int valor, int index) {
        this.cantidad[index] += valor;
    }
}
