package com.achess.tarjetas;

import javax.swing.*;

public class TPremio extends Tarjeta{
    private int premio;
    @Override
    public void accion() {
        premio = numerosAleatorios(125, 350);
        JOptionPane.showMessageDialog(null, "Usted ha ganado una competencia " +
                "recibe Q" + premio + " de premio");
    }
}
