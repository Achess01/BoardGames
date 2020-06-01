package com.achess.tarjetas;

import com.achess.Utils;
import com.achess.juego.Jugador;

import javax.swing.*;

public class TCaminar extends Tarjeta{
    private int casillas;
    @Override
    public void accion(Jugador jugador) {
        int casillas = numerosAleatorios(-3, 3);
        JOptionPane.showMessageDialog(null, "Hoy es su día de suerte " +
                "camine " + casillas);
        int d[] = {casillas};
        jugador.comprobarDados(d);
    }
}
