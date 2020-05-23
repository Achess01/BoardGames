package com.achess.casillas;

import com.achess.juego.Jugador;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serializable;

public abstract class Casilla extends JPanel implements Serializable{
    public static final Color COLORES_CASILLAS[] = {Color.WHITE, Color.CYAN,
    Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLACK, Color.PINK};
    public static final Color COLORES_LUGARES[] = {Color.BLUE, Color.RED, Color.YELLOW,
    Color.GREEN, Color.ORANGE};
    private Color fondo;
    private String nombre;
    private Jugador jugadores[] = new Jugador[0];
    private Casilla anterior;
    private Casilla siguiente;
    private JPanel espacioJugadores;

    public Casilla(String nombre){
        this.nombre = nombre;
        this.anterior = null;
        this.siguiente = null;
        this.fondo = fondo;
        setLayout(new GridLayout(3, 1, 10, 0));
        espacioJugadores = new JPanel();
        espacioJugadores.setLayout(new GridLayout(2, 3, 20, 20));
        espacioJugadores.setBorder(new LineBorder(this.fondo));
        JLabel t = new JLabel(this.nombre, JLabel.CENTER);
        add(t);
        add(espacioJugadores);
        setBorder(new LineBorder(this.fondo));
        setBackground(this.fondo);
    }

    public abstract void accion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Casilla getAnterior() {
        return anterior;
    }

    public void setAnterior(Casilla anterior) {
        this.anterior = anterior;
    }

    public Casilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Casilla siguiente) {
        this.siguiente = siguiente;
    }

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public JPanel getEspacioJugadores() {
        return espacioJugadores;
    }

    public void setEspacioJugadores(JPanel espacioJugadores) {
        this.espacioJugadores = espacioJugadores;
    }

    public Jugador[] agregarJugadores(Jugador obj, Jugador[] objetos, boolean validar){
        if(validar) {
            Jugador newObjetos[] = new Jugador[objetos.length + 1];
            newObjetos[0] = obj;
            for (int x = 1; x < newObjetos.length; x++) {
                newObjetos[x] = objetos[x - 1];
            }
            return newObjetos;
        }
        else{
            Jugador newObjetos[] = new Jugador[objetos.length - 1];
            for (int x = 0; x < newObjetos.length; x++) {
                if(obj.equals(objetos[x])){
                    for(int y = x; y < newObjetos.length; y++){
                        objetos[x] = objetos[x+1];
                    }
                }
                newObjetos[x] = objetos[x];
            }
            return newObjetos;
        }
    }
}
