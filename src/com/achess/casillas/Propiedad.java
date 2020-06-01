package com.achess.casillas;

import com.achess.juego.Jugador;
import com.achess.juego.Tablero;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Propiedad extends Casilla {

    private Jugador duenio;
    private int costoUso;
    private int precioCompra;
    private int precioHipoteca;
    private boolean hipoteca;
    private Tablero campo;

    public Propiedad(String nombre, int precioCompra, int precioHipoteca, int costoUso, Tablero campo) {
        super(nombre);
        this.campo = campo;
        duenio = null;
        this.precioCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
        this.costoUso = costoUso;
        hipoteca = false;
    }

    protected void opcionesNoDuenio(Jugador jugador){
        String mensaje = "Bienvenido " + jugador.getNombre();
        //POner opciones
        String[] options = new String[] {"Comprar por Q" + precioCompra, "Pasar"};
        int response = JOptionPane.showOptionDialog(null, mensaje, getNombre(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        if(response == 0){
            int d = jugador.getDinero();
            if(d >= precioCompra){
                jugador.agregarPropiedad(this);
                duenio = jugador;
                jugador.setDinero(d - precioCompra);
            }
            else{
                JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
            }
        }
    }

    protected void opcionesDuenio(Jugador jugador){
        String mensaje = "Bienvenido " + jugador.getNombre();
        //POner opciones
        String[] options = new String[] {"Hipotecar", "Pagar hipoteca", "Pasar"};
        int response = JOptionPane.showOptionDialog(null, mensaje, getNombre(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        switch (response){
            case 0: hipotecar(); break;
            case 1: pagarHipoteca(); break;
        }

    }


    protected void hipotecar(){
        if(!hipoteca){
            duenio.setDinero(duenio.getDinero() + precioHipoteca);
            hipoteca = true;
            JOptionPane.showMessageDialog(null, "Hipoteca hecha con éxito");
        }
        else {
            JOptionPane.showMessageDialog(null, "Esta propiedad ya está hipotecada");
        }
    }

    protected void pagarHipoteca(){
        if(hipoteca){
            int d = duenio.getDinero();
            int h = precioHipoteca + (int)0.1*precioHipoteca;
            if(d  < h){
                JOptionPane.showMessageDialog(null, "No tiene dinero para pagar la hipoteca. \n " +
                        "Le hacen falta Q" + (h-d));
            }
            else {
                duenio.setDinero(d - h);
                hipoteca = false;
                JOptionPane.showMessageDialog(null, "Hipoteca pagada");
            }
        }
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

    public int getCostoUso() {
        return costoUso;
    }

    public void setCostoUso(int costoUso) {
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

    @Override
    public void accion(Jugador jugador) {
        boolean esPropietario = jugador.equals(duenio) ? true : false;
        if(!esPropietario){
            if(duenio == null){
                opcionesNoDuenio(jugador);
            }
            else {
                String mensaje = jugador.getNombre() + " debe pagar Q" + costoUso +
                        "por pasar en esta propiedad";
                JOptionPane.showMessageDialog(null, mensaje);
                jugador.setDinero(jugador.getDinero() - costoUso);
                int d;
                if(jugador.getDinero() < costoUso){
                    d = duenio.getDinero() + jugador.getDinero();
                }
                else {
                    d = duenio.getDinero() + costoUso;
                }
                if(!hipoteca){
                    duenio.setDinero(d);
                }

            }
        }
        else {
            opcionesDuenio(jugador);
        }
    }
}
