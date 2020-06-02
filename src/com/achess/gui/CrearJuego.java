package com.achess.gui;

import com.achess.Utils;
import com.achess.juego.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CrearJuego extends JPanel implements Utils {
        private JTextField nombre;
        private JTextField cantidadJugadores;
        private JTextField cantidadDinero;
        private JTextField cantidadCasillas;
        private JTextField cantidadDineroPorVuelta;
        private JTextField cantidadDados;
        private JTextField cantidadCasas;
        private JTextField cantidadHoteles;
        private JTextField interes;
        private JButton confirmacion;

    public CrearJuego(){
        setLayout(new GridLayout(2,1));
        JPanel main = new JPanel();
        JPanel botoncito = new JPanel();
        botoncito.setLayout(new BoxLayout(botoncito, BoxLayout.Y_AXIS));
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
        botoncito.add(confirmacion);
        botoncito.add(new Label("Llenar todas las casillas son obligatorias", JLabel.CENTER));
        botoncito.add(new Label("- El nombre no debe estar vacío", JLabel.CENTER));
        botoncito.add(new Label("- Cantidad jugadores: max 6, min 2", JLabel.CENTER));
        botoncito.add(new Label("- Cantidad de casillas: max 50, min 28", JLabel.CENTER));
        botoncito.add(new Label("- Cantidad dinero: max 1800, min 1100", JLabel.CENTER));
        botoncito.add(new Label("- Dinero por vuelta: max 300, min 100", JLabel.CENTER));
        botoncito.add(new Label("- Dados: max 3, min 1", JLabel.CENTER));
        botoncito.add(new Label("- Casas: max 4, min 2", JLabel.CENTER));
        botoncito.add(new Label("- Hoteles: max 4, min 2", JLabel.CENTER));
        botoncito.add(new Label("- Interes: max 20, min 5", JLabel.CENTER));
        this.add(main);
        this.add(botoncito);
        confirmacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n = nombre.getText();
                int cJugadores = validarEntero(cantidadJugadores.getText(), 2, 6);
                int cCasillas = validarEntero(cantidadCasillas.getText(), 28, 50);
                int cDinero = validarEntero(cantidadDinero.getText(), 1100, 1800);
                int cDineroPorVuelta = validarEntero(cantidadDineroPorVuelta.getText(), 100, 300);
                int cDados = validarEntero(cantidadDados.getText(), 1, 3);
                int cCasas = validarEntero(cantidadCasas.getText(), 2, 4);
                int cHoteles = validarEntero(cantidadHoteles.getText(), 2, 4);
                int cInteres = validarEntero(interes.getText(), 5, 20);

                if(n.isEmpty() || cJugadores < 0 || cCasillas < 0 || cDinero < 0 || cDineroPorVuelta < 0
                || cDados < 0 || cCasas < 0 || cHoteles < 0 || cInteres < 0){
                    JOptionPane.showMessageDialog(null, "Datos fuera de límites");
                }
                else {
                    Tablero t = new Tablero(n, cJugadores, cDinero, cCasillas,
                            cDineroPorVuelta, cDados, cCasas, cHoteles, cInteres);
                    guardarFichero("board", t);
                }
            }
        });
    }

    private int validarEntero(String n, int min, int max){
        try {
            int numero = Integer.parseInt(n);
            if(numero >= min && numero <= max){
                return numero;
            }
            return -1;
        }
        catch (Exception ex){
            return -1;
        }
    }

}
