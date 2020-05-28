package com.achess.gui;

import com.achess.casillas.Casilla;
import com.achess.juego.Tablero;
import com.achess.listas.ListaCasillas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serializable;

public class EspacioJuego extends JPanel implements Serializable {
    private JPanel tablero;
    private JPanel sur;
    private JPanel oeste;
    private JPanel norte;
    private JPanel este;
    private Tablero campo;
    public EspacioJuego(Tablero campo){
        this.campo = campo;
        int tamanio = this.campo.getCasillas().getTamanio();
        ListaCasillas listaCasilla = this.campo.getCasillas();
        sur = new JPanel();
        sur.setBorder(new LineBorder(Color.BLACK));
        oeste = new JPanel();
        oeste.setBorder(new LineBorder(Color.BLACK));
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        norte = new JPanel();
        norte.setBorder(new LineBorder(Color.BLACK));
        este = new JPanel();
        este.setBorder(new LineBorder(Color.BLACK));
        este.setLayout(new BoxLayout(este, BoxLayout.Y_AXIS));
        int s = tamanio/4;
        int o = s;
        int n = o;
        int e = n + tamanio%4;
        Casilla aux;
        aux = listaCasilla.getInicio();
        sur.add(aux);
        System.out.println(tamanio);
        for(int x = 0; x < tamanio - 1; x++){
            aux = aux.getSiguiente();
            if(x < s){
                sur.add(aux);
            }
            else if(x < (s + o)){
                oeste.add(aux);
            }
            else if(x < (s + o + n)){
                norte.add(aux);
            }
            else if(x < (s+o+n+e)){
                este.add(aux);
            }

        }
        tablero = new JPanel();
        cambiarOrden(sur);
        cambiarOrden(oeste);
        tablero.setLayout(new BorderLayout());
        tablero.add(sur, BorderLayout.SOUTH);
        tablero.add(oeste, BorderLayout.WEST);
        tablero.add(norte, BorderLayout.NORTH);
        tablero.add(este, BorderLayout.EAST);
        add(tablero);
    }

    private void cambiarOrden(JPanel component){
        Component lista[] = component.getComponents();
        component.removeAll();
        for (int x = lista.length - 1; x >= 0; x--){
            component.add(lista[x]);
        }
    }
}
