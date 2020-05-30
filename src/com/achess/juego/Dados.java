package com.achess.juego;

import com.achess.Utils;
import com.achess.gui.EspacioJuego;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serializable;

public class Dados extends JLabel implements Runnable, Serializable, Utils {
    private int valor;

    public Dados(){
        setBorder(new LineBorder(Color.BLACK));
    }

    public int valor(){
        setValor(numerosAleatorios(1, 6));
        return getValor();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
        setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        EspacioJuego.dados.add(this);
        for(int x = 0; x < 10; x++){
            setText("   " + numerosAleatorios(1, 6) + "   ");
            esperarXsegundos(100);
            SwingUtilities.updateComponentTreeUI(this);
        }
        setText("   " + getValor() + "   ");
        SwingUtilities.updateComponentTreeUI(this);
    }


}
