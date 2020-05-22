package com.achess.tarjetas;

import javax.swing.*;

public class TPagar extends Tarjeta{
    private int pago;
    @Override
    public void accion() {
        pago = numerosAleatorios(25, 40);
        String mensaje = "Usted decide invitar a sus contrincantes a comer. " +
                "De Q" + pago +" a cada uno";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
