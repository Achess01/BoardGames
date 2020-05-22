package com.achess.tarjetas;

import javax.swing.*;

public class TSalgaCarcel extends Tarjeta{
    @Override
    public void accion() {
        String mensaje = "Usted ha sobornado a un policía. " +
                "Tome un cupón para salir de la cárcel";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
