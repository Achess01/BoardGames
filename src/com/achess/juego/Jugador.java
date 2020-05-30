package com.achess.juego;

import com.achess.casillas.Casilla;
import com.achess.casillas.Propiedad;
import com.achess.gui.EspacioJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Jugador extends JPanel implements Serializable {
    public static final Color COLOR_FICHA[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.YELLOW,
    Color.MAGENTA, Color.RED};
    public static int letra = 65;
    private String nombre;
    private Propiedad propiedades[] = new Propiedad[0];
    private int salirCarcel;
    private int dinero;
    private Jugador siguiente;
    private Jugador anterior;
    private Casilla actual;
    private Color fondo;

    public Jugador(int index, int dinero){
        this.dinero = dinero;
        salirCarcel = 0;
        actual = null;
        siguiente = null;
        anterior = null;
        nombre = Character.toString(letra);
        letra++;
        this.fondo = COLOR_FICHA[index];
        //setPreferredSize(new Dimension(30, 50));
        setBackground(this.fondo);
        add(new Label(nombre), JLabel.CENTER);
    }

    public void mover(Casilla casilla){
        if(actual != null){
            actual.getEspacioJugadores().remove(this);
            SwingUtilities.updateComponentTreeUI(actual);
        }
        actual = casilla;
        casilla.getEspacioJugadores().add(this);
        SwingUtilities.updateComponentTreeUI(actual);
    }

    public void comprobarDados(int valoresDados[]){
        int suma = 0;
        for (int valor : valoresDados) {
            suma += valor;
            System.out.println(valor);
        }
        Casilla aux = actual;
        for (int i = 0; i < suma; i++) {
            aux = aux.getSiguiente();
        }
        System.out.println(suma);
        mover(aux);
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
