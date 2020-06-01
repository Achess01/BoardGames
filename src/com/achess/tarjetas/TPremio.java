package com.achess.tarjetas;

import com.achess.juego.Jugador;

import javax.swing.*;

public class TPremio extends Tarjeta{
    private int premio;
    @Override
    public void accion(Jugador jugador) {
        premio = numerosAleatorios(125, 350);
        JOptionPane.showMessageDialog(null, "Usted ha ganado una competencia " +
                "recibe Q" + premio + " de premio");
        jugador.setDinero(jugador.getDinero() + premio);
    }
}
