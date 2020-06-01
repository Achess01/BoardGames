package com.achess.tarjetas;

import com.achess.juego.Jugador;

import javax.swing.*;

public class TMulta extends Tarjeta{
    private int multa;
    @Override
    public void accion(Jugador jugador) {
        multa = numerosAleatorios(200, 350);
        JOptionPane.showMessageDialog(null, "Lo han arrestado por correr " +
                "desnudo en el parque. Pague Q" + multa);
        jugador.setDinero(jugador.getDinero() - multa);
    }
}
