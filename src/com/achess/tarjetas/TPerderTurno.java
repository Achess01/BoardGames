package com.achess.tarjetas;

import com.achess.juego.Jugador;

import javax.swing.*;

public class TPerderTurno extends Tarjeta {
    private int turnos;
    @Override
    public void accion(Jugador jugador) {
        turnos = numerosAleatorios(1, 3);
        String mensaje = "Lo ha arrollado un toro de Zacapa. " +
                "Pierde " + turnos + " turnos";
        JOptionPane.showMessageDialog(null, mensaje);
        jugador.setPerderTurno(jugador.getPerderTurno() + turnos);
    }
}
