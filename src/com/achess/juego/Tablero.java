package com.achess.juego;

import com.achess.Utils;
import com.achess.casillas.*;
import com.achess.listas.ListaCasillas;
import com.achess.listas.ListaJugadores;
import com.achess.listas.ListaTarjetas;
import com.achess.tarjetas.*;

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
    private Grupo grupos;
    private ListaCasillas casillas;
    private ListaJugadores jugadores;
    private Jugador turno;

    public Tablero(String nombre, int cantidadJugadores, int cantidadDinero, int cantidadCasillas,
                   int cantidadDineroPorVuelta, int cantidadDados, int cantidadCasas,
                   int cantidadHoteles, int interes) {
        Jugador.letra = 65;
        Lugar.nombres = 97;
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadDinero = cantidadDinero;
        this.cantidadCasillas = cantidadCasillas;
        this.cantidadDineroPorVuelta = cantidadDineroPorVuelta;
        this.cantidadDados = cantidadDados;
        this.cantidadCasas = cantidadCasas;
        this.cantidadHoteles = cantidadHoteles;
        this.interes = interes;
        crear();
    }

    private void crear(){
        int n1, n2, n3, c, h;
      Casilla nuevo[] = new Casilla[0];
      int neutro = (int)Math.ceil(cantidadCasillas*0.05);
      int estacion = (int)Math.ceil(cantidadCasillas*0.0);
      int servicio =  (int)Math.ceil(cantidadCasillas*0.08);
      int carcel = (int)Math.ceil(cantidadCasillas*0.07);
      int tarjeta = (int)Math.ceil(cantidadCasillas*0.08);
      int lugar = cantidadCasillas - (neutro+estacion+servicio+carcel+tarjeta+1);

      for(int index = 0; index < neutro; index++){
          nuevo = agregar(nuevo, new Neutro("Neutro"));
      }
      for(int index = 0; index < estacion; index++){
          n1 = numerosAleatorios(30, 50);
          n2 = numerosAleatorios(130, 150);
          n3 = numerosAleatorios(100, 120);
          nuevo = agregar(nuevo, new Estacion("Buses", n2, n3, n1, this));
      }

      for(int index = 0; index < servicio; index++){
          n1 = numerosAleatorios(20, 30);
          n2 = numerosAleatorios(110, 130);
          n3 = numerosAleatorios(80, 100);
          nuevo = agregar(nuevo, new Servicio("Servicios", n2, n3, n1, this));
      }
      for (int index = 0; index < carcel; index++){
          nuevo = agregar(nuevo, new Carcel("Cárcel"));
      }
      for(int index = 0; index < tarjeta; index++){
          nuevo = agregar(nuevo, new TomarTarjeta("Tomar tarjeta", nuevasTarjetas()));
      }
      grupos = new Grupo();
      int grupo = 0;
      for(int x = 0; x < lugar; x++){
          n1 = numerosAleatorios(25, 35);
          n2 = numerosAleatorios(120, 140);
          n3 = numerosAleatorios(95, 110);
          c = numerosAleatorios(50, 70);
          h = numerosAleatorios(80, 100);
          nuevo = agregar(nuevo, new Lugar(Character.toString(Lugar.nombres), n2, n3,cantidadHoteles, cantidadCasas,
                  n1,c, h, grupo, this));
          grupos.setCantidad(1,grupo);
          grupo++;
          if(grupo == 5){
              grupo = 0;
          }
      }
      casillas = escogerOrden(nuevo);
      jugadores = new ListaJugadores();
      for(int x = 0; x < cantidadJugadores; x++){
          jugadores.agregar(new Jugador(x, cantidadDinero, this));
      }
      setTurnoInicial();
      Jugador au;
      au = jugadores.getInicio();
      for(int x = 0; x < cantidadJugadores; x++){
          au.mover(casillas.getInicio());
          au = au.getSiguiente();
      }
    }

    private void setTurnoInicial(){
        int iniciar = numerosAleatorios(0, jugadores.getTamanio());
        for (int i = 0; i < iniciar; i++) {
            jugadores.correrLugares();
        }
        turno = jugadores.getInicio();
    }

    public Jugador getTurno() {
        return turno;
    }

    public void setTurno(Jugador turno) {
        this.turno = turno;
    }

    private ListaCasillas escogerOrden(Casilla casillas[]){
        Boolean repetido;
        int posiciones[] = new int[casillas.length];
        int index;
        for(int x = 0; x < casillas.length; x++){
            repetido = false;
            index = numerosAleatorios(0, casillas.length - 1);
            for(int y = 0; y < x; y++){
                if(index == posiciones[y]){
                    repetido = true;
                    break;
                }
            }
            if(repetido){
                x--;
                continue;
                //El for se repite hasta que el número creado no esté ya en el arreglo;
            }
            posiciones[x] = index;
        }

        ListaCasillas lista = new ListaCasillas();
        lista.agregar(new Inicio("INICIO"));
        for(int x = 0; x < casillas.length; x++){
            lista.agregar(casillas[posiciones[x]]);
        }

        return lista;
    }
    private Casilla[] agregar(Casilla arreglo[], Casilla elemento){
        Casilla a[] = new Casilla[arreglo.length +1];
        a[arreglo.length] = elemento;
        for(int x = 0; x < arreglo.length; x++){
            a[x] = arreglo[x];
        }

        return a;
    }

    public Grupo getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupo grupos) {
        this.grupos = grupos;
    }

    public ListaCasillas getCasillas() {
        return casillas;
    }

    public void setCasillas(ListaCasillas casillas) {
        this.casillas = casillas;
    }

    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    private ListaTarjetas nuevasTarjetas(){
        ListaTarjetas lista = new ListaTarjetas();
        int n;
        for (int i = 0; i < 20; i++) {
            n = numerosAleatorios(0,6);
            switch (n){
                case 0: lista.agregar(new TCaminar()); break;
                case 1: lista.agregar(new TMulta()); break;
                case 2: lista.agregar(new TPagar()); break;
                case 3: lista.agregar(new TPerderTurno()); break;
                case 4: lista.agregar(new TPremio()); break;
                case 5: lista.agregar(new TSalgaCarcel()); break;
                case 6: lista.agregar(new TVayaCarcel()); break;
            }
        }
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
