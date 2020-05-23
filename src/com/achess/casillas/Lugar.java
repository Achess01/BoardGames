package com.achess.casillas;

import java.awt.*;

public class Lugar extends Propiedad {

    private int cantidadHoteles;
    private int cantidadCasas;
    private int precioCasa;
    private int precioHotel;
    private int grupo;

    public Lugar(String nombre, int precioCompra, int precioHipoteca, Color fondo, int cantidadHoteles, int cantidadCasas, int costoEstancia, int precioCasa, int precioHotel, int grupo) {
        super(nombre, precioCompra, precioHipoteca, costoEstancia);
        this.cantidadHoteles = cantidadHoteles;
        this.cantidadCasas = cantidadCasas;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
        this.grupo = grupo;
    }

    public int getCantidadHoteles() {
        return cantidadHoteles;
    }

    public void setCantidadHoteles(int cantidadHoteles) {
        this.cantidadHoteles = cantidadHoteles;
    }

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public void setCantidadCasas(int cantidadCasas) {
        this.cantidadCasas = cantidadCasas;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public void setPrecioCasa(int precioCasa) {
        this.precioCasa = precioCasa;
    }

    public int getPrecioHotel() {
        return precioHotel;
    }

    public void setPrecioHotel(int precioHotel) {
        this.precioHotel = precioHotel;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    @Override
    public void accion() {

    }
}
