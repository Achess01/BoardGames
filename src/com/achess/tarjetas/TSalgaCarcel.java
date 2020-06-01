package com.achess.tarjetas;

import com.achess.juego.Jugador;

import javax.swing.*;

public class TSalgaCarcel extends Tarjeta{
    @Override
    public void accion(Jugador jugador) {
        String mensaje = "Usted ha sobornado a un policía. " +
                "Tome un cupón para salir de la cárcel";
        JOptionPane.showMessageDialog(null, mensaje);
        jugador.setSalirCarcel(jugador.getSalirCarcel() + 1);
    }
}
