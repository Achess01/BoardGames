package com.achess;

public interface Utils {
    default int numerosAleatorios(int min, int max){
        int aleatorio = (int)Math.floor(Math.random()*(max - min +1) + min);
        return aleatorio;
    }

    default void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
