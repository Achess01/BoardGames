package com.achess.casillas;

public class Servicio extends Propiedad {
    private int costoServicio;

    public Servicio(String nombre, int precioCompra, int precioHipoteca, int costoServicio) {
        super(nombre, precioCompra, precioHipoteca);
        this.costoServicio = costoServicio;
    }

    public int getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(int costoServicio) {
        this.costoServicio = costoServicio;
    }
}
