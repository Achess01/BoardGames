package com.achess.tarjetas;

import com.achess.juego.Jugador;

import javax.swing.*;

public class TPagar extends Tarjeta{
    private int pago;
    @Override
    public void accion(Jugador jugador) {
        pago = numerosAleatorios(25, 40);
        String mensaje = "Usted decide invitar a sus contrincantes a comer. " +
                "Dé Q" + pago +" a cada uno";
        JOptionPane.showMessageDialog(null, mensaje);
        int c = jugador.getCampo().getJugadores().getTamanio();
        jugador.setDinero(jugador.getDinero() - (c*pago));
        Jugador aux = jugador.getSiguiente();
        while (!aux.equals(jugador)){
            aux.setDinero(aux.getDinero() + pago);
            aux = aux.getSiguiente();
        }
    }
}
