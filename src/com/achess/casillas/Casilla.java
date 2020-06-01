package com.achess.casillas;

import com.achess.gui.EspacioJuego;
import com.achess.juego.Jugador;
import com.achess.juego.Tablero;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public abstract class Casilla extends JPanel implements Serializable{
    public static final Color COLORES_CASILLAS[] = {Color.WHITE, Color.CYAN,
    Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLACK, Color.PINK};
    private Color fondo;
    private String nombre;
    private Casilla anterior;
    private Casilla siguiente;
    private JPanel espacioJugadores;
    private JPanel inf = new JPanel();
    private boolean agregado;

    public Casilla(String nombre){
        agregado = false;
        this.nombre = nombre;
        this.anterior = null;
        this.siguiente = null;
        inf.setLayout(new BoxLayout(inf, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(2, 1));
        espacioJugadores = new JPanel();
        espacioJugadores.setLayout(new GridLayout(2, 3));
        JLabel t = new JLabel(this.nombre, JLabel.CENTER);
        add(t);
        add(espacioJugadores);
        setBorder(new LineBorder(this.fondo));
        setPreferredSize(new Dimension(100, 75));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                AgregarInfo();
                EspacioJuego.centro.add(inf);
                SwingUtilities.updateComponentTreeUI(EspacioJuego.centro);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                EspacioJuego.centro.remove(inf);
                SwingUtilities.updateComponentTreeUI(EspacioJuego.centro);
            }
        });
    }


    public abstract void accion(Jugador jugador);

    public void AgregarInfo(){
        inf.removeAll();
        setInfo("Nombre", nombre);
    }

    public void setInfo(String descripcion, String info) {
        inf.add(new JLabel(descripcion + ": "  + info, JLabel.CENTER));
        SwingUtilities.updateComponentTreeUI(inf);
    }

    public JPanel getInf() {
        return inf;
    }

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
        setBackground(this.fondo);
        inf.setBackground(this.fondo);
        espacioJugadores.setBorder(new LineBorder(this.fondo));
    }

    public JPanel getEspacioJugadores() {
        return espacioJugadores;
    }

    public void setEspacioJugadores(JPanel espacioJugadores) {
        this.espacioJugadores = espacioJugadores;
    }

    @Override
    public String toString() {
        return "='" + nombre + '\'' + "\n";
    }
}

