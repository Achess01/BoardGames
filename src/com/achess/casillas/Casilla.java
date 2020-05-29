package com.achess.casillas;

import com.achess.gui.EspacioJuego;
import com.achess.juego.Jugador;

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
    private Jugador jugadores[] = new Jugador[0];
    private Casilla anterior;
    private Casilla siguiente;
    private JPanel espacioJugadores;
    private JPanel inf = new JPanel();

    public Casilla(String nombre){
        this.nombre = nombre;
        this.anterior = null;
        this.siguiente = null;
        inf.setLayout(new BoxLayout(inf, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(3, 1, 10, 0));
        espacioJugadores = new JPanel();
        espacioJugadores.setLayout(new GridLayout(2, 3, 20, 20));
        JLabel t = new JLabel(this.nombre, JLabel.CENTER);
        add(t);
        add(espacioJugadores);
        setBorder(new LineBorder(this.fondo));
        setPreferredSize(new Dimension(100, 75));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                setNombre("chuy");
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
                EspacioJuego.centro.removeAll();
                SwingUtilities.updateComponentTreeUI(EspacioJuego.centro);
            }
        });
    }


    public abstract void accion();

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

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' + "\n";
    }
}

