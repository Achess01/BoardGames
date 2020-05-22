package com.achess;

public interface Utils {
    default int numerosAleatorios(int min, int max){
        int aleatorio = (int)Math.floor(Math.random()*(max - min +1) + min);
        return aleatorio;
    }

}
