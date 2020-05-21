package com.achess.casillas;

import com.achess.juego.Jugador;

public abstract class Propiedad extends Casilla {

    private Jugador duenio;
    private int precioCompra;
    private int precioHipoteca;
    private boolean hipoteca = false;
    public Propiedad(String nombre, int precioCompra, int precioHipoteca) {
        super(nombre);
        this.precioCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
    }

    public Jugador getDuenio() {
        return duenio;
    }

    public void setDuenio(Jugador duenio) {
        this.duenio = duenio;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrcioHipoteca() {
        return precioHipoteca;
    }

    public void setPrcioHipoteca(int prcioHipoteca) {
        this.precioHipoteca = prcioHipoteca;
    }

    public boolean isHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(boolean hipoteca) {
        this.hipoteca = hipoteca;
    }
}
