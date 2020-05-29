package com.achess.casillas;

import java.awt.*;

public class Lugar extends Propiedad {
    public static final Color COLORES_LUGARES[] = {Color.BLUE, Color.RED, Color.YELLOW,
            Color.GREEN, Color.ORANGE};
    public static int nombres = 97;
    private int cantidadHoteles;
    private int cantidadCasas;
    private int precioCasa;
    private int precioHotel;
    private int grupo;
    private int casas;
    private int hoteles;

    public Lugar(String nombre, int precioCompra, int precioHipoteca,
                 int cantidadHoteles, int cantidadCasas, int costoEstancia, int precioCasa, int precioHotel,
                 int grupo) {
        super(nombre, precioCompra, precioHipoteca, costoEstancia);
        this.cantidadHoteles = cantidadHoteles;
        this.cantidadCasas = cantidadCasas;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
        this.grupo = grupo;
        casas = 0;
        hoteles = 0;
        setFondo(COLORES_LUGARES[this.grupo]);
        nombres++;

    }

    @Override
    public void AgregarInfo() {
        super.AgregarInfo();
        setInfo("Casas", casas + "/" + cantidadCasas);
        setInfo("Hoteles", hoteles + "/" + cantidadHoteles);
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public int getHoteles() {
        return hoteles;
    }

    public void setHoteles(int hoteles) {
        this.hoteles = hoteles;
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
