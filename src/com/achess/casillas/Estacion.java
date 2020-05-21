package com.achess.casillas;

public class Estacion extends Propiedad {
    private int costoUso;

    public Estacion(String nombre, int precioCompra, int precioHipoteca, int costoUso) {
        super(nombre, precioCompra, precioHipoteca);
        this.costoUso = costoUso;
    }

    public int getCostoUso() {
        return costoUso;
    }

    public void setCostoUso(int costoUso) {
        this.costoUso = costoUso;
    }
}
