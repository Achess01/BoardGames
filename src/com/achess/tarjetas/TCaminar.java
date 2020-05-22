package com.achess.tarjetas;

import com.achess.Utils;

import javax.swing.*;

public class TCaminar extends Tarjeta{
    private int casillas;
    private boolean avanzar;
    @Override
    public void accion() {
        JOptionPane.showMessageDialog(null, "Hoy es su día de suerte " +
                "camine " + casillas);
        int validar = numerosAleatorios(0, 1);
        int casillas = numerosAleatorios(-3, 3);
        avanzar = (validar == 1) ? true : false;
    }
}
