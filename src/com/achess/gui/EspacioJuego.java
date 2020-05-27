package com.achess.gui;

import com.achess.casillas.Casilla;
import com.achess.juego.Tablero;
import com.achess.listas.ListaCasillas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EspacioJuego extends JPanel {
    private JPanel tablero;
    private JPanel sur;
    private JPanel oeste;
    private JPanel norte;
    private JPanel este;
    public EspacioJuego(Tablero tablero){
        int tamanio = tablero.getCasillas().getTamanio();
        ListaCasillas listaCasilla = tablero.getCasillas();
        sur = new JPanel();
        sur.setBorder(new LineBorder(Color.BLACK));
        oeste = new JPanel();
        oeste.setBorder(new LineBorder(Color.BLACK));
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        norte = new JPanel();
        norte.setBorder(new LineBorder(Color.BLACK));
        este = new JPanel();
        este.setBorder(new LineBorder(Color.BLACK));
        este.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        int s = tamanio/4;
        int o = s;
        int n = o;
        int e = n + tamanio%4;
        Casilla aux;
        aux = listaCasilla.getInicio();
        sur.add(aux);
        for(int x = 0; x < tamanio; x++){
            aux = aux.getSiguiente();
            if(x < s){
                sur.add(aux);
                cambiarOrden(sur);
            }
            else if(x < (s + o)){
                oeste.add(aux);
                cambiarOrden(oeste);
            }
            else if(x < (s + o + n)){
                norte.add(aux);
            }
            else{
                este.add(aux);
            }

        }
        add(sur, BorderLayout.SOUTH);
        add(oeste, BorderLayout.WEST);
        add(norte, BorderLayout.NORTH);
        add(este, BorderLayout.EAST);
    }

    private void cambiarOrden(JPanel component){
        Component lista[] = component.getComponents();
        component.removeAll();
        for (int x = lista.length - 1; x >= 0; x--){
            component.add(lista[x]);
        }
    }
}
