package com.achess.casillas;

public class Lugar extends Propiedad {

    private int cantidadHoteles;
    private int cantidadCasas;
    private int CostoEstancia;
    private int precioCasa;
    private int precioHotel;
    private int grupo;

    public Lugar(String nombre, int precioCompra, int precioHipoteca,
                 int cantidadHoteles, int cantidadCasas, int costoEstancia, int precioCasa, int precioHotel, int grupo) {
        super(nombre, precioCompra, precioHipoteca);
        this.cantidadHoteles = cantidadHoteles;
        this.cantidadCasas = cantidadCasas;
        CostoEstancia = costoEstancia;
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

    public int getCostoEstancia() {
        return CostoEstancia;
    }

    public void setCostoEstancia(int costoEstancia) {
        CostoEstancia = costoEstancia;
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
}
