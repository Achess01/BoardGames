package com.achess.gui;

import com.achess.Utils;
import com.achess.casillas.Casilla;
import com.achess.juego.Tablero;
import com.achess.listas.ListaCasillas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame  extends JFrame implements Utils {
    private final int WIDTH = 750;
    private final int  HEIGHT = 450;
    public static JPanel panelBienvenida = new JPanel();
    private boolean jugando;
    public MainFrame(){
       // setSize(WIDTH, HEIGHT);
        jugando = false;
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alto = tamanoPantalla.height;
        int ancho = tamanoPantalla.width;
        this.setSize(2*(ancho/3), 2*(alto/3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Juegos de mesa");
        JLabel mensaje = new JLabel("BIENVENIDO", JLabel.CENTER);
        mensaje.setFont(new Font("Nuevo",1,45));
        panelBienvenida.add(mensaje);
        this.setJMenuBar(navBar());
        this.setContentPane(panelBienvenida);
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    private JMenuBar navBar(){
            JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("Archivo");
            JMenuItem guardar = new JMenuItem("Guardar");

            //Opciones del menu Archivo
            JMenuItem newGame = new JMenuItem("Crear juego");
            newGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    setContentPane(new CrearJuego());
                    pack();
                }
            });
            JMenu play = new JMenu("Jugar");
            JMenuItem nuevo = new JMenuItem("Nuevo");
            JMenuItem cargar = new JMenuItem("Cargar");
            play.add(nuevo);
            play.add(cargar);
            nuevo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    EspacioJuego espacioJuego = abrirFichero("BOARD (Tablero inicial)", "board");
                    if(espacioJuego != null){
                        ListaCasillas l = espacioJuego.getCampo().getCasillas();
                        Casilla c = l.getInicio();
                        for (int i = 0; i < l.getTamanio(); i++) {
                            c.agregarEventos();
                            c = c.getSiguiente();
                        }


                        setContentPane(espacioJuego);
                        setJugando(true);
                        pack();
                    }
                }

            });

            cargar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    EspacioJuego espacioJuego = abrirFichero("GAME (Juego en proceso)", "game");
                    if(espacioJuego != null){
                        setContentPane(espacioJuego);
                        pack();
                        setJugando(true);
                    }
                }
            });

            guardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(jugando){
                        guardarFichero("game", EspacioJuego.getCampo());
                    }
                }
            });

            JMenuItem about = new JMenuItem("Acerca de");
            about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tablero t = new Tablero("aa", 2, 1232, 30,
                            123, 2, 2, 2, 6);

                    setContentPane(new EspacioJuego(t));

                }
            });

            menuFile.add(newGame);
            menuFile.add(play);
            menuFile.add(guardar);
            menuFile.add(about);
            menuBar.add(menuFile);
            return menuBar;
    }


    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        SwingUtilities.updateComponentTreeUI(this);
    }

}
