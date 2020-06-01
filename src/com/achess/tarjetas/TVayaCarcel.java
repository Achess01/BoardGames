package com.achess.tarjetas;

import javax.swing.*;

public class TVayaCarcel extends Tarjeta  {
    @Override
    public void accion() {
        String mensaje = "Lo han encontrado en la calle en pleno toque de queda. Vaya a la cárcle";
        //POner opciones
        String[] options = new String[] {"Ok", "Usar cupón"};
        int response = JOptionPane.showOptionDialog(null, mensaje, "Cárcel",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        //0 para ir a carcel, 1 para buscar cupon;
    }
}
