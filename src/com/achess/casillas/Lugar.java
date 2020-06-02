package com.achess.casillas;

import com.achess.juego.Jugador;
import com.achess.juego.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
                 int grupo, Tablero campo) {
        super(nombre, precioCompra, precioHipoteca, costoEstancia, campo);
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

    private void construirCasa(){
        int g = getGrupo();
        int cG = getDuenio().getCampo().getGrupos().getCantidad(g);
        int cantidad = getDuenio().getLugares(g);

        if(casas == cantidadCasas){
            JOptionPane.showMessageDialog(null, "Cantidad de casas completadas");
        }
        else if(cG != cantidad){
            JOptionPane.showMessageDialog(null,"Aún no tiene todas las propiedades del grupo");
        }
        else {
            if(getDuenio().getDinero() >= precioCasa) {
                casas++;
                setCostoUso(getCostoUso() + (int) (getCostoUso() * 0.25));
                getDuenio().setDinero(getDuenio().getDinero() - precioCasa);
                JOptionPane.showMessageDialog(null, "Hecho");
            }
            else {
                JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
            }
        }
    }

    private void construirHotel(){
        if(hoteles == cantidadHoteles || casas != cantidadCasas){
            JOptionPane.showMessageDialog(null, "No puede construir hoteles");
        }
        else {
            if(getDuenio().getDinero() >= precioHotel) {
                hoteles++;
                setCostoUso(getCostoUso() + (int) (getCostoUso() * 0.35));
                getDuenio().setDinero(getDuenio().getDinero() - precioHotel);
                JOptionPane.showMessageDialog(null, "Hecho");
            }
            else {
                JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
            }
        }
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
    public void AgregarInfo() {
        super.AgregarInfo();
        setInfo("Casas", casas + "/" + cantidadCasas);
        setInfo("Hoteles", hoteles + "/" + cantidadHoteles);
    }

    @Override
    protected void opcionesDuenio(Jugador jugador) {
        String mensaje = "Bienvenido " + jugador.getNombre();
        //POner opciones
        String[] options = new String[] {"Construir casa", "Construir hotel",  "Hipotecar", "Pagar hipoteca", "Pasar"};
        int response = JOptionPane.showOptionDialog(null, mensaje, getNombre(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        switch (response){
            case 0: construirCasa(); break;
            case 1: construirHotel(); break;
            case 2: hipotecar(); break;
            case 3: pagarHipoteca(); break;
        }
    }
}
