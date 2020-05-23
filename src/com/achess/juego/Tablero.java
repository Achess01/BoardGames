package com.achess.juego;

import com.achess.Utils;
import com.achess.casillas.*;
import com.achess.listas.ListaCasillas;
import com.achess.listas.ListaJugadores;
import com.achess.listas.ListaTarjetas;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Tablero implements Serializable, Utils {
    private String nombre;
    private int cantidadJugadores;
    private int cantidadDinero;
    private int cantidadCasillas;
    private int cantidadDineroPorVuelta;
    private int cantidadDados;
    private int cantidadCasas;
    private int cantidadHoteles;
    private int interes;
    private ListaCasillas casillas = new ListaCasillas();
    private ListaJugadores jugadores = new ListaJugadores();

    public Tablero(String nombre, int cantidadJugadores, int cantidadDinero, int cantidadCasillas,
                   int cantidadDineroPorVuelta, int cantidadDados, int cantidadCasas,
                   int cantidadHoteles, int interes) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadDinero = cantidadDinero;
        this.cantidadCasillas = cantidadCasillas;
        this.cantidadDineroPorVuelta = cantidadDineroPorVuelta;
        this.cantidadDados = cantidadDados;
        this.cantidadCasas = cantidadCasas;
        this.cantidadHoteles = cantidadHoteles;
        this.interes = interes;
    }

    private void crear(){
        int n1, n2, n3;
      Casilla nuevo[] = new Casilla[0];
      int neutro = (int)Math.ceil(cantidadCasillas*0.05);
      int estacion = (int)Math.ceil(cantidadCasillas*0.07);
      int servicio =  (int)Math.ceil(cantidadCasillas*0.1);
      int carcel = (int)Math.ceil(cantidadCasillas*0.07);
      int tarjeta = (int)Math.ceil(cantidadCasillas*0.1);
      int lugar = cantidadCasillas - (neutro+estacion+servicio+carcel+tarjeta+1);

      for(int index = 0; index < neutro; index++){
          nuevo = agregar(nuevo, new Neutro("Neutro"));
      }
      for(int index = 0; index < estacion; index++){
          n1 = numerosAleatorios(30, 50);
          n2 = numerosAleatorios(130, 150);
          n3 = numerosAleatorios(100, 120);
          nuevo = agregar(nuevo, new Estacion("Buses", n2, n3, n1));
      }

      for(int index = 0; index < servicio; index++){
          n1 = numerosAleatorios(20, 30);
          n2 = numerosAleatorios(110, 130);
          n3 = numerosAleatorios(80, 100);
          nuevo = agregar(nuevo, new Servicio("Servicios", n2, n3, n1));
      }
      for (int index = 0; index < carcel; index++){
          nuevo = agregar(nuevo, new Carcel("Cárcel"));
      }
      for(int index = 0; index < tarjeta; index++){
          nuevo = agregar(nuevo, new TomarTarjeta("Tomar tarjeta", nuevasTarjetas()));
      }
    }

    private Casilla[] agregar(Casilla arreglo[], Casilla elemento){
        Casilla a[] = new Casilla[arreglo.length +1];
        a[arreglo.length] = elemento;
        for(int x = 0; x < arreglo.length; x++){
            a[x] = arreglo[x];
        }

        return a;
    }

    private ListaTarjetas nuevasTarjetas(){
        ListaTarjetas lista = new ListaTarjetas();
        return  lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(int cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public int getCantidadCasillas() {
        return cantidadCasillas;
    }

    public void setCantidadCasillas(int cantidadCasillas) {
        this.cantidadCasillas = cantidadCasillas;
    }

    public int getCantidadDineroPorVuelta() {
        return cantidadDineroPorVuelta;
    }

    public void setCantidadDineroPorVuelta(int cantidadDineroPorVuelta) {
        this.cantidadDineroPorVuelta = cantidadDineroPorVuelta;
    }

    public int getCantidadDados() {
        return cantidadDados;
    }

    public void setCantidadDados(int cantidadDados) {
        this.cantidadDados = cantidadDados;
    }

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public void setCantidadCasas(int cantidadCasas) {
        this.cantidadCasas = cantidadCasas;
    }

    public int getCantidadHoteles() {
        return cantidadHoteles;
    }

    public void setCantidadHoteles(int cantidadHoteles) {
        this.cantidadHoteles = cantidadHoteles;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }
}
