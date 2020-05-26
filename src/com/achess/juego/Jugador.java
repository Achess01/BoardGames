package com.achess.juego;

import com.achess.casillas.Casilla;
import com.achess.casillas.Propiedad;

import java.awt.*;

public class Jugador {
    public static final Color COLOR_FICHA[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.YELLOW,
    Color.MAGENTA, Color.RED};
    private static int letra = 65;
    private String nombre;
    private Propiedad propiedades[];
    private int salirCarcel;
    private int dinero;
    private Jugador siguiente;
    private Jugador anterior;
    private Casilla actual;
    private Color fondo;

    public Jugador(int index){
        siguiente = null;
        anterior = null;
        nombre = Character.toString(letra);
        letra++;
        this.fondo = COLOR_FICHA[index];
    }

    public Casilla getActual() {
        return actual;
    }

    public void setActual(Casilla actual) {
        this.actual = actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Propiedad[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Propiedad[] propiedades) {
        this.propiedades = propiedades;
    }

    public int getSalirCarcel() {
        return salirCarcel;
    }

    public void setSalirCarcel(int salirCarcel) {
        this.salirCarcel = salirCarcel;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }

    public Jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Jugador anterior) {
        this.anterior = anterior;
    }
}
