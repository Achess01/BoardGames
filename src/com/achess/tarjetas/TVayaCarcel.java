package com.achess.tarjetas;

import com.achess.casillas.Carcel;
import com.achess.casillas.Casilla;
import com.achess.juego.Jugador;

import javax.swing.*;

public class TVayaCarcel extends Tarjeta  {
    @Override
    public void accion(Jugador jugador) {
        String mensaje = "Lo han encontrado en la calle en pleno toque de queda. Vaya a la cárcle";
        //POner opciones
        String[] options = new String[] {"Ok", "Usar cupón"};
        int response = JOptionPane.showOptionDialog(null, mensaje, "Cárcel",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        //0 para ir a carcel, 1 para buscar cupon;
        switch (response){
            case 0: irCarcel(jugador); break;
            case 1: usarCupon(jugador); break;
        }
    }

    private void irCarcel(Jugador jugador){
        jugador.setPerderTurno(jugador.getPerderTurno() + 1);
        int adelante = 0, atras = 0;
        Casilla act = jugador.getActual();
        while (!(act.getSiguiente() instanceof Carcel)){
            act = act.getSiguiente();
            adelante++;
            if(adelante >= jugador.getCampo().getCasillas().getTamanio()){
                adelante = 0;
                break;
            }
        }
        while (!(act.getAnterior() instanceof Carcel)){
            act = act.getAnterior();
            atras--;
            if(Math.abs(atras) >= jugador.getCampo().getCasillas().getTamanio()){
                atras = 0;
                break;
            }
        }

        if(Math.abs(atras) < adelante){
            int c[] = {atras};
            jugador.comprobarDados(c);
        }
        else{
            int c[] = {adelante};
            jugador.comprobarDados(c);
        }
    }

    private void usarCupon(Jugador jugador){
        int cupones = jugador.getSalirCarcel();
        if(cupones > 0){
            jugador.setSalirCarcel(jugador.getSalirCarcel() -1);
            JOptionPane.showMessageDialog(null, "Cupón canjeado. Restantes: " + jugador.getSalirCarcel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Usted no cuenta con cupones");
            irCarcel(jugador);
        }
    }
}
