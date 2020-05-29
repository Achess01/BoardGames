package com.achess.casillas;

import com.achess.juego.Jugador;
import javax.swing.*;
import java.awt.*;

public abstract class Propiedad extends Casilla {

    private Jugador duenio;
    private int costoUso;
    private int precioCompra;
    private int precioHipoteca;
    private boolean hipoteca = false;
    public Propiedad(String nombre, int precioCompra, int precioHipoteca, int costoUso) {
        super(nombre);
        duenio = null;
        this.precioCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
        this.costoUso = costoUso;
    }

    @Override
    public void AgregarInfo() {
        super.AgregarInfo();
        setInfo("Dueño", (duenio == null ? "Sin dueño": duenio.getNombre()));
        setInfo("Precio compra",  "Q "+ precioCompra);
        setInfo("Precio hipoteca",  "Q "+ precioHipoteca);
        setInfo("Precio estancia",  "Q "+ costoUso);
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
