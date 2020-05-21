package com.achess.gui;

import javax.swing.*;
import java.awt.*;

public class CrearJuego extends JPanel {
        private JTextField nombre;
        private JTextField cantidadJugadores;
        private JTextField cantidadDinero;
        private JTextField cantidadCasillas;
        private JTextField cantidadDineroPorVuelta;
        private JTextField cantidadDados;
        private JTextField cantidadCasas;
        private JTextField cantidadHoteles;
        private JTextField interes;
        private JButton tarjetas;
        private JButton confirmacion;


    public CrearJuego(){
        setLayout(new GridLayout(2,1));
        JPanel main = new JPanel();
        JPanel botoncito = new JPanel();
        main.setLayout(new GridLayout(5, 4, 50, 10));
        nombre = new JTextField();
        cantidadJugadores = new JTextField();
        cantidadCasillas = new JTextField();
        cantidadDinero = new JTextField();
        cantidadDineroPorVuelta = new JTextField();
        cantidadDados = new JTextField();
        cantidadCasas = new JTextField();
        cantidadHoteles = new JTextField();
        interes = new JTextField();
        tarjetas = new JButton("Agregar tarjetas");
        confirmacion = new JButton("Guardar");
        main.add(new JLabel("Nombre del juego"));
        main.add(nombre);
        main.add(new JLabel("Cantidad de jugadores"));
        main.add(cantidadJugadores);
        main.add(new JLabel("Cantidad de casillas"));
        main.add(cantidadCasillas);
        main.add(new JLabel("Dinero inicial"));
        main.add(cantidadDinero);
        main.add(new JLabel("Dinero por vuelta"));
        main.add(cantidadDineroPorVuelta);
        main.add(new JLabel("Dados"));
        main.add(cantidadDados);
        main.add(new JLabel("Casas"));
        main.add(cantidadCasas);
        main.add(new JLabel("Hoteles"));
        main.add(cantidadHoteles);
        main.add(new JLabel("Interés"));
        main.add(interes);
        main.add(new JLabel("Agregar tarjetas"));
        main.add(tarjetas);
        botoncito.add(confirmacion);
        this.add(main);
        this.add(botoncito);
    }


}
